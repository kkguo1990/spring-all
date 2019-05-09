package com.kk.mybatis.plus.quickstart.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kk.mybatis.plus.quickstart.config.PageRequestVo;
import com.kk.mybatis.plus.quickstart.entity.Student;
import com.kk.mybatis.plus.quickstart.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kk
 * @since 2019-04-15
 */
@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService service;

    @RequestMapping("/selecPageByGrade")
    public R<Object> getSelectPageByGrade(@RequestBody PageRequestVo vo){
        Page<Student> pageResult = service.getSelectPageByGrade(vo);
        return  R.ok(pageResult);
    }

    @RequestMapping("/hello")
    public R<String> hello(){
        return R.ok("heloo");
    }
}
