package com.kk.mybatis.plus.quickstart.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kk.mybatis.plus.quickstart.config.PageRequestVo;
import com.kk.mybatis.plus.quickstart.entity.Student;
import com.kk.mybatis.plus.quickstart.mapper.StudentMapper;
import com.kk.mybatis.plus.quickstart.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kk
 * @since 2019-04-15
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired
    StudentMapper mapper;

    @Override
    public Page<Student> getSelectPageByGrade(PageRequestVo vo) {
        HashMap<String, Object> params = vo.getParams();
        Page<Student> page = new Page<>(vo.getCurrent(),vo.getSize());
        List<Student> students = mapper.selectByGrade(page, params);
        page.setRecords(students);
        return page;
    }
}
