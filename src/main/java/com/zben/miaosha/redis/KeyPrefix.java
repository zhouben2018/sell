package com.zben.miaosha.redis;

/**
 * @Author:zben
 * @Date: 2018/7/14/014 14:47
 */
public interface KeyPrefix {

    public int expireSeconds();

    public String getPrefix();
}
