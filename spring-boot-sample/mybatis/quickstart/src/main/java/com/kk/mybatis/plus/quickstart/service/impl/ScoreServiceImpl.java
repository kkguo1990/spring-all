package com.kk.mybatis.plus.quickstart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kk.mybatis.plus.quickstart.entity.Score;
import com.kk.mybatis.plus.quickstart.mapper.ScoreMapper;
import com.kk.mybatis.plus.quickstart.service.IScoreService;
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
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements IScoreService {

}
