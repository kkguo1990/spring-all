package com.kk.mybatis.dynamic.service.impl;

import com.kk.mybatis.dynamic.annotation.TargetDataSource;
import com.kk.mybatis.dynamic.commons.DataSourceKey;
import com.kk.mybatis.dynamic.mapper.UserInfoMapper;
import com.kk.mybatis.dynamic.entity.UserInfo;
import com.kk.mybatis.dynamic.service.UserInfoService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author RocLiu [apedad@qq.com]
 * @version 1.0
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    private static final Logger LOG = Logger.getLogger(UserInfoServiceImpl.class);
    @Resource
    private UserInfoMapper userInfoMapper;

    @TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
    @Override
    public List<UserInfo> listAll() {
        return userInfoMapper.listAll();
    }

    @TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
    @Override
    public int insert(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }
}
