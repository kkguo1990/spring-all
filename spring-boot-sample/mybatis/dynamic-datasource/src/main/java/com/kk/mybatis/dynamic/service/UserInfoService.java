package com.kk.mybatis.dynamic.service;

import com.kk.mybatis.dynamic.entity.UserInfo;

import java.util.List;

/**
 * @author RocLiu [apedad@qq.com]
 * @version 1.0
 */
public interface UserInfoService {
    List<UserInfo> listAll();

    int insert(UserInfo userInfo);
}
