package com.kk.mybatis.plus.quickstart;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kk.mybatis.plus.quickstart.entity.Student;
import com.kk.mybatis.plus.quickstart.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuickstartApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Autowired
    StudentMapper mapper;
    @Test
    public void startQuery(){
        Student student = mapper.selectById(1);
    }

    @Test
    public void startMyMapper(){
        Student student = mapper.selectMy();
        System.out.println(student);
    }

    /**
     * 自定义分页
     */
    @Test
    public void selectPage(){
        Page<Student> page = new Page<>(1,10);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("gid",1);
        List<Student> students = mapper.selectByGrade(page, hashMap);
        System.out.println(students);
    }

    @Test
    public  void selecPageMore(){

    }


}
