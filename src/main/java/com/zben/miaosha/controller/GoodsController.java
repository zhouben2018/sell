package com.zben.miaosha.controller;

import com.zben.miaosha.domain.MiaoshaUser;
import com.zben.miaosha.redis.RedisService;
import com.zben.miaosha.service.MiaoshaUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:zben
 * @Date: 2018/7/15/015 8:40
 */
@Controller
@RequestMapping("/goods")
@Slf4j
public class GoodsController {

    @Autowired
    MiaoshaUserService miaoshaUserService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/to_list")
    public String list(Model model, MiaoshaUser user) {
        model.addAttribute("user", user);
        log.info("user: " +user.toString());
        return "goods_list";
    }


}
