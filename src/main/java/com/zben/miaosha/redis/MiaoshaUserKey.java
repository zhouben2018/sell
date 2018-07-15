package com.zben.miaosha.redis;

/**
 * @Author:zben
 * @Date: 2018/7/14/014 15:10
 */
public class MiaoshaUserKey extends BasePrefix {

    private static final int COOKIE_EXPIRED = 24 * 3600 * 2;

    private MiaoshaUserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    private MiaoshaUserKey(String prefix) {
        super(prefix);
    }


    public static MiaoshaUserKey getByToken = new MiaoshaUserKey(COOKIE_EXPIRED, "tk");
}
