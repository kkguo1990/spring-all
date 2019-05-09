package com.kk.mybatis.plus.quickstart.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kk.mybatis.plus.quickstart.config.PageRequestVo;
import com.kk.mybatis.plus.quickstart.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kk
 * @since 2019-04-15
 */
public interface IStudentService extends IService<Student> {

   Page<Student> getSelectPageByGrade(PageRequestVo pageVo);

}
