package com.zben.miaosha.controller;

import com.zben.miaosha.domain.User;
import com.zben.miaosha.redis.RedisService;
import com.zben.miaosha.redis.UserKey;
import com.zben.miaosha.result.CodeMsg;
import com.zben.miaosha.result.Result;
import com.zben.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:zben
 * @Date: 2018/7/14/014 10:01
 */
@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "zhouben");
        return "hello";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello() {
        return Result.success("hello, zhouben");
    }

    @RequestMapping("/helloError")
    @ResponseBody
    public Result<String> helloError() {
        return Result.error(CodeMsg.ERROR_SERVER);
    }

    @RequestMapping("/db/doGet")
    @ResponseBody
    public Result<User> doGet() {
        return Result.success(userService.getById(1));
    }

    @RequestMapping("/db/doTx")
    @ResponseBody
    public Result<Boolean> doTx() {
        return Result.success(userService.tx());
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet() {
        User v1 = redisService.get(UserKey.getById, "" + 1, User.class);
        return Result.success(v1);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<User> redisSet() {
        User user = new User(1, "1111");
        redisService.set(UserKey.getById, "" + 1, user);
        User v2 = redisService.get(UserKey.getById, "" + 1, User.class);
        return Result.success(v2);
    }
}
