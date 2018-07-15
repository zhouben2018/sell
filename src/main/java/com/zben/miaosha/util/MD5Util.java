package com.zben.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Author:zben
 * @Date: 2018/7/14/014 15:58
 */
public class MD5Util {

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    private static final String salt = "1a2b3c4d";

    public static String inputPassFormPass(String inputPass) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String formPassDBPass(String formPass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDBPass(String inputPass, String saltDB) {
        String formPass = inputPassFormPass(inputPass);
        String dbPass = formPassDBPass(formPass, saltDB);
        return dbPass;
    }

    public static void main(String[] args) {
//        System.out.println(inputPassFormPass("123456"));
//        System.out.println(formPassDBPass("d3b1294a61a07da9b49b6e22b2cbd7f9", "1a2b3c4d"));
        System.out.println(inputPassToDBPass("123456", "1a2b3c4d"));
    }
}
