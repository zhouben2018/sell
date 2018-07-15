package com.zben.miaosha.exception;

import com.zben.miaosha.result.CodeMsg;

/**
 * @Author:zben
 * @Date: 2018/7/15/015 9:44
 */
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = -6248952864221731323L;

    private CodeMsg cm;

    public GlobalException(CodeMsg cm) {
        super(cm.toString());
        this.cm = cm;
    }

    public CodeMsg getCm() {
        return cm;
    }
}
