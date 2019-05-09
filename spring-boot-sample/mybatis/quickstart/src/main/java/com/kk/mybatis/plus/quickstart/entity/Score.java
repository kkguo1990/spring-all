package com.kk.mybatis.plus.quickstart.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author kk
 * @since 2019-04-15
 */
@Data
@Accessors(chain = true)
public class Score  {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sid", type = IdType.AUTO)
    private Integer sid;

    private Integer studentId;

    private Integer courseId;

    private Integer score;


}
