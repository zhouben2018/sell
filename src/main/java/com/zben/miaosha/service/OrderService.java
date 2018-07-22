package com.zben.miaosha.service;

import com.zben.miaosha.dao.OrderDao;
import com.zben.miaosha.domain.MiaoshaOrder;
import com.zben.miaosha.domain.MiaoshaUser;
import com.zben.miaosha.domain.OrderInfo;
import com.zben.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author:zben
 * @Date: 2018/7/15/015 14:15
 */
@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    public MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(long userId, long goodsId) {
        return orderDao.getMiaoshaOrderByUserIdGoodsId(userId, goodsId);
    }

    //卖超问题， 可以user_id goods_id加唯一索引 ， 减库存的时候加一个判断 goods_stock > 0
    public OrderInfo createOrder(MiaoshaUser user, GoodsVo goods) {
        //下订单
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setGoodsId(goods.getId());
        orderInfo.setDeliveryAddrId(0L);
        orderInfo.setGoodsCount(1);
        orderInfo.setGoodsName(goods.getGoodsName());
        orderInfo.setGoodsPrice(goods.getGoodsPrice());
        orderInfo.setOrderChannel(1);
        orderInfo.setUserId(user.getId());
        orderInfo.setStatus(0);
        orderInfo.setCreateDate(new Date());
        long orderId = orderDao.insert(orderInfo);
        //写入秒杀订单
        MiaoshaOrder miaoshaOrder = MiaoshaOrder.builder()
                .goodsId(goods.getId()).orderId(orderId).userId(user.getId())
                .build();
        orderDao.insertMiaoshaOrder(miaoshaOrder);
        return orderInfo;
    }

    public OrderInfo getOrderById(long orderId) {
        return orderDao.getOrderById(orderId);
    }
}
