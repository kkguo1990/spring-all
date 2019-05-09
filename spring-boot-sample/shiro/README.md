shiro + jwt 
整合了 token 过期，并且发布新令牌的功能
主要是 max_time 与 min_time;在这个时间段内，请求接口会发布新的token令牌
min_time: token 快过期时间
max_time : token 过期时间
ps:因为是个人登录接口，并发量不会高，所以没用同步锁