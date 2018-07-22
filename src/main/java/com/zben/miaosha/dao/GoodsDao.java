package com.zben.miaosha.dao;

import com.zben.miaosha.domain.MiaoshaGoods;
import com.zben.miaosha.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author:zben
 * @Date: 2018/7/15/015 14:15
 */
@Mapper
public interface GoodsDao {

    @Select("select g.*,mg.miaosha_price, mg.stock_count, mg.start_date, mg.end_date from miaosha_goods mg left join goods g on mg.goods_id=g.id")
    public List<GoodsVo> listGoodsVo();

    @Select("select g.*,mg.miaosha_price, mg.stock_count, mg.start_date, mg.end_date from miaosha_goods mg left join goods g on mg.goods_id=g.id" +
            " where g.id=#{goodsId}")
    GoodsVo getGoodsVoByGoodsId(@Param("goodsId") long goodsId);

    @Update("update miaosha_goods set stock_count= stock_count-1 where goods_id=#{goodsId}")
    void reduce(MiaoshaGoods g);
}
