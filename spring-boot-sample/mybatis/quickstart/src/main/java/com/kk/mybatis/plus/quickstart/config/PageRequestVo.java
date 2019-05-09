package com.kk.mybatis.plus.quickstart.config;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.HashMap;

@Data
public class PageRequestVo extends Page {

    HashMap<String,Object> params;

}
