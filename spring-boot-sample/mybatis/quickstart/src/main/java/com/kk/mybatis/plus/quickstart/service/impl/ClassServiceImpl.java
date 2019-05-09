package com.kk.mybatis.plus.quickstart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kk.mybatis.plus.quickstart.entity.Class;
import com.kk.mybatis.plus.quickstart.mapper.ClassMapper;
import com.kk.mybatis.plus.quickstart.service.IClassService;
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
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements IClassService {

}
