package com.zben.miaosha.redis;

/**
 * @Author:zben
 * @Date: 2018/7/14/014 15:10
 */
public class OrderKey extends BasePrefix {

    public OrderKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
