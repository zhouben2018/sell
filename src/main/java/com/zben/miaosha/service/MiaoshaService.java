package com.zben.miaosha.service;

import com.zben.miaosha.domain.MiaoshaUser;
import com.zben.miaosha.domain.OrderInfo;
import com.zben.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:zben
 * @Date: 2018/7/15/015 14:15
 */
@Service
public class MiaoshaService {

    @Autowired
    GoodsService goodsService;
    @Autowired
    OrderService orderService;

    @Transactional
    public OrderInfo miaosha(MiaoshaUser user, GoodsVo goods) {
        //减库存
        goodsService.reduce(goods);
        //下订单 写入秒杀订单
        OrderInfo orderInfo = orderService.createOrder(user, goods);
        return orderInfo;
    }
}
