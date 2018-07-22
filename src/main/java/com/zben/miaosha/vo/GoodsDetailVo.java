package com.zben.miaosha.vo;

import com.zben.miaosha.domain.Goods;
import com.zben.miaosha.domain.MiaoshaUser;
import lombok.Data;

/**
 * @Author:zben
 * @Date: 2018/7/22/022 15:02
 */
@Data
public class GoodsDetailVo {
    private int miaoshaStatus = 0;
    private int remainSeconds = 0;
    private Goods goods;
    private MiaoshaUser user;
}
