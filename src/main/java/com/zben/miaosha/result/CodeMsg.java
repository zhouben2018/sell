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
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
    //登录模块  5002XX
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500201, "密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500202, "手机号不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500203, "手机号格式错误");
    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500204, "手机号不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500205, "密码错误");
    //商品模块  5003XX

    //订单模块  5004XX

    //秒杀模块  5005XX
    public static CodeMsg MIAOSHA_OVER = new CodeMsg(500500, "秒杀已完毕");
    public static CodeMsg REPEAT_MIAOSHA = new CodeMsg(500501, "不能重复秒杀");

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }
}
