package com.kk.mybatis.plus.quickstart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kk.mybatis.plus.quickstart.entity.Teacher;
import com.kk.mybatis.plus.quickstart.mapper.TeacherMapper;
import com.kk.mybatis.plus.quickstart.service.ITeacherService;
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
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

}
