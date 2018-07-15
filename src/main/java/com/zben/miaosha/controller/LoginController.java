package com.zben.miaosha.controller;

import com.zben.miaosha.result.Result;
import com.zben.miaosha.service.MiaoshaUserService;
import com.zben.miaosha.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @Author:zben
 * @Date: 2018/7/15/015 8:40
 */
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    MiaoshaUserService miaoshaUserService;

    @RequestMapping("/to_login")
    public String login() {
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
        log.info("..." + loginVo.toString());
        //登录
        miaoshaUserService.login(response, loginVo);
        return Result.success(true);
    }


}
