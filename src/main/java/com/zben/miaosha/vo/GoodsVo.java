package com.zben.miaosha.vo;

import com.zben.miaosha.domain.Goods;
import lombok.Data;

import java.util.Date;

/**
 * @Author:zben
 * @Date: 2018/7/15/015 14:16
 */
@Data
public class GoodsVo extends Goods {
    private Double miaoshaPrice;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;
}
