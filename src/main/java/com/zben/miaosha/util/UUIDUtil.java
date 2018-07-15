package com.zben.miaosha.util;

import java.util.UUID;

/**
 * @Author:zben
 * @Date: 2018/7/15/015 10:12
 */
public class UUIDUtil {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
