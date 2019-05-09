package com.kk.mybatis.dynamic.service.impl;

import com.kk.mybatis.dynamic.mapper.UserMapper;
import com.kk.mybatis.dynamic.entity.User;
import com.kk.mybatis.dynamic.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author RocLiu [apedad@qq.com]
 * @version 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> listAll() {
        return userMapper.listAll();
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }
}
