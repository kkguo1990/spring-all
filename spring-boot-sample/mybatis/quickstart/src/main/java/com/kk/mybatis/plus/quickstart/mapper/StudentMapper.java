package com.kk.mybatis.plus.quickstart.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kk.mybatis.plus.quickstart.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kk
 * @since 2019-04-15
 */
public interface StudentMapper extends BaseMapper<Student> {

    Student selectMy();

    List<Student> selectByGrade(Page<Student> page,@Param("ew") HashMap<String , Object> params);
}
