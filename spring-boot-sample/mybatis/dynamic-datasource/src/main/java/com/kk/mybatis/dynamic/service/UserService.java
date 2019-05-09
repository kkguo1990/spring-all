package com.kk.mybatis.dynamic.service;

import com.kk.mybatis.dynamic.entity.User;

import java.util.List;

/**
 * @author RocLiu [apedad@qq.com]
 * @version 1.0
 */
public interface UserService {
    List<User> listAll();

    int insert(User user);
}
