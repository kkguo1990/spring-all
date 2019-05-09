package com.kk.mybatis.plus.quickstart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kk.mybatis.plus.quickstart.entity.Grade;
import com.kk.mybatis.plus.quickstart.mapper.GradeMapper;
import com.kk.mybatis.plus.quickstart.service.IGradeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kk
 * @since 2019-04-15
 */
@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements IGradeService {

}
