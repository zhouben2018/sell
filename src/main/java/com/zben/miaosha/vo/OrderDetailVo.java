package com.zben.miaosha.vo;

import com.zben.miaosha.domain.Goods;
import com.zben.miaosha.domain.OrderInfo;
import lombok.Data;

/**
 * @Author:zben
 * @Date: 2018/7/22/022 15:02
 */
@Data
public class OrderDetailVo {
    private Goods goods;
    private OrderInfo order;
}
