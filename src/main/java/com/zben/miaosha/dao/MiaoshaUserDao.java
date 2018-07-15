package com.zben.miaosha.dao;

import com.zben.miaosha.domain.MiaoshaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author:zben
 * @Date: 2018/7/15/015 9:00
 */
@Mapper
public interface MiaoshaUserDao {

    @Select(("select * from miaosha_user where id = #{id}"))
    public MiaoshaUser getById(@Param("id") long id);
}
