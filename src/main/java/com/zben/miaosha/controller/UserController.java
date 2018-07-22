package com.zben.miaosha.controller;

import com.zben.miaosha.domain.MiaoshaUser;
import com.zben.miaosha.redis.RedisService;
import com.zben.miaosha.result.Result;
import com.zben.miaosha.service.GoodsService;
import com.zben.miaosha.service.MiaoshaUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:zben
 * @Date: 2018/7/15/015 8:40
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    MiaoshaUserService miaoshaUserService;
    @Autowired
    GoodsService goodsService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/info")
    @ResponseBody
    public Result<MiaoshaUser> info(Model model, MiaoshaUser user) {

        return Result.success(user);
    }
}
