package com.zben.miaosha.redis;

/**
 * @Author:zben
 * @Date: 2018/7/14/014 15:10
 */
public class UserKey extends BasePrefix {

    private UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    private UserKey(String prefix) {
        super(prefix);
    }


    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");
}
