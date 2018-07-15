package com.zben.miaosha.service;

import com.zben.miaosha.dao.MiaoshaUserDao;
import com.zben.miaosha.domain.MiaoshaUser;
import com.zben.miaosha.exception.GlobalException;
import com.zben.miaosha.redis.MiaoshaUserKey;
import com.zben.miaosha.redis.RedisService;
import com.zben.miaosha.result.CodeMsg;
import com.zben.miaosha.util.MD5Util;
import com.zben.miaosha.util.UUIDUtil;
import com.zben.miaosha.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:zben
 * @Date: 2018/7/15/015 9:02
 */
@Service
public class MiaoshaUserService {

    public static final String COOKIE_NAME = "token";

    @Autowired
    MiaoshaUserDao miaoshaUserDao;
    @Autowired
    RedisService redisService;

    public MiaoshaUser getById(long id) {
        return miaoshaUserDao.getById(id);
    }

    public boolean login(HttpServletResponse response, LoginVo loginVo) {
        if (loginVo == null) {
            throw new GlobalException(CodeMsg.ERROR_SERVER);
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        //判断手机号是否存在
        MiaoshaUser user = miaoshaUserDao.getById(Long.parseLong(mobile));
        if (user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPass = user.getPassword();
        String dbSalt = user.getSalt();

        String calcPass = MD5Util.formPassDBPass(formPass, dbSalt);
        if (!calcPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //生成token
        addToken(response, user);

        return true;
    }

    public MiaoshaUser getToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        MiaoshaUser user = redisService.get(MiaoshaUserKey.getByToken, token, MiaoshaUser.class);
        //延长有效期
        if (user != null) {
            addToken(response, user);
        }
        return user;
    }

    private void addToken(HttpServletResponse response, MiaoshaUser user) {
        String token = UUIDUtil.uuid();
        redisService.set(MiaoshaUserKey.getByToken, token, user);
        //写到cookie
        Cookie cookie = new Cookie(COOKIE_NAME, token);
        cookie.setMaxAge(MiaoshaUserKey.getByToken.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
