package com.zben.miaosha.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author:zben
 * @Date: 2018/7/15/015 8:59
 */
@Data
public class MiaoshaUser {
    private Long id;
    private String nickname;
    private String password;
    private String salt;
    private String head;
    private Date registerDate;
    private Date lastLoginDate;
    private Integer loginCount;
}
