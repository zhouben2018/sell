package com.zben.miaosha.redis;

/**
 * @Author:zben
 * @Date: 2018/7/14/014 15:10
 */
public class GoodsKey extends BasePrefix {

    private GoodsKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    private GoodsKey(String prefix) {
        super(prefix);
    }


    public static GoodsKey getGoodsList = new GoodsKey(60, "gl");
    public static GoodsKey getGoodsDetail = new GoodsKey(60, "gd");
}
