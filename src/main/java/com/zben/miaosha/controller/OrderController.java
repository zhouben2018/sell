package com.zben.miaosha.controller;

import com.zben.miaosha.domain.MiaoshaUser;
import com.zben.miaosha.domain.OrderInfo;
import com.zben.miaosha.redis.RedisService;
import com.zben.miaosha.result.CodeMsg;
import com.zben.miaosha.result.Result;
import com.zben.miaosha.service.GoodsService;
import com.zben.miaosha.service.MiaoshaUserService;
import com.zben.miaosha.service.OrderService;
import com.zben.miaosha.vo.GoodsVo;
import com.zben.miaosha.vo.OrderDetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:zben
 * @Date: 2018/7/15/015 8:40
 */
@Controller
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    MiaoshaUserService miaoshaUserService;
    @Autowired
    GoodsService goodsService;

    @Autowired
    RedisService redisService;
    @Autowired
    OrderService orderService;

   @RequestMapping("/detail")
    @ResponseBody
    public Result<OrderDetailVo> info(Model model, MiaoshaUser user,
                                      @RequestParam("orderId") long orderId) {
       if (user == null) {
           return Result.error(CodeMsg.SESSION_ERROR);
       }
       OrderInfo order = orderService.getOrderById(orderId);
       if (order == null) {
           return Result.error(CodeMsg.ORDER_NOT_EXIST);
       }
       Long goodsId = order.getGoodsId();
       GoodsVo goodsVo = goodsService.getGoodsVoByGoodsId(goodsId);
       OrderDetailVo vo = new OrderDetailVo();
       vo.setGoods(goodsVo);
       vo.setOrder(order);
       return Result.success(vo);
   }

}
