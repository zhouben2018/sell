package com.zben.miaosha.result;

import lombok.Getter;

/**
 * @Author:zben
 * @Date: 2018/7/14/014 10:43
 */
@Getter
public class CodeMsg {
    private int code;
    private String msg;

    //通用的异常
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg ERROR_SERVER = new CodeMsg(500100, "服务端异常");
    //登录模块  5002XX

    //商品模块  5003XX

    //订单模块  5004XX

    //秒杀模块  5005XX

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
