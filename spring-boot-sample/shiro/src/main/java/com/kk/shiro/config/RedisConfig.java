package com.kk.shiro.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.time.Duration;

/**
 * redis缓存配置类：1，使用json序列化；2，启用缓存注解
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    private static Jackson2JsonRedisSerializer jacksonRedisSerializer = null;

    @Value("${app.redis.timeout:10}")
    private Integer timeout;

    static {
        // 初始化json序列化类
        jacksonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        // 允许序列化未知属性
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        jacksonRedisSerializer.setObjectMapper(om);
    }

    /**
     * redis缓存的key生成策略，可以在注解中使用keyGenerator="cacheKeyGenerator"指定，也可以不用
     *
     * @return
     */
    @Bean
    public KeyGenerator cacheKeyGenerator() {
        KeyGenerator keyGenerator = new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getSimpleName()).append(":");
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(":").append(obj.toString());
                }
                return sb.toString();
            }
        };
        return keyGenerator;
    }

    /**
     * 缓存管理器
     *
     * @param factory
     * @param defaultCacheConfig 注入下面的redisCacheConfiguration()返回的bean
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory, RedisCacheConfiguration defaultCacheConfig) {
        // 初始化一个RedisCacheWriter
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(factory);

        // 初始化RedisCacheManager
        RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
        return cacheManager;
    }

    /**
     * redis模板类，使用json序列化类，优点：便于查看，不用每个模型类实现Serializable接口
     *
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 配置连接工厂
        template.setConnectionFactory(factory);

        // 值采用json序列化
        RedisSerializer<Object> serializer = getSerializer();
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);

        // 设置hash key 和value序列化模式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);
        template.afterPropertiesSet();

        return template;
    }

    private RedisSerializer<Object> getSerializer() {
        return jacksonRedisSerializer;
    }

    /**
     * 设置redis数据默认过期时间和序列化方式
     *
     * @return
     */
    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        // 设置Cacheable默认序列化方式
        RedisSerializer<Object> serializer = getSerializer();
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
        configuration = configuration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));

        //设置默认超过期时间
        configuration = configuration.entryTtl(Duration.ofDays(timeout));
        return configuration;
    }
}
