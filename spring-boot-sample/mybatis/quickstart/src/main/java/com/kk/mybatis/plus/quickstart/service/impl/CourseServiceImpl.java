package com.kk.mybatis.plus.quickstart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kk.mybatis.plus.quickstart.entity.Course;
import com.kk.mybatis.plus.quickstart.mapper.CourseMapper;
import com.kk.mybatis.plus.quickstart.service.ICourseService;
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
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

}
