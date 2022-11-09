package com.example.erp.mapper;

import com.example.erp.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from `order` where game_id = #{id}")
    List<Order> findAllOrderById(Integer id);

    @Select("select count(DISTINCT user_id) from `order` where game_id = #{id}")
    Integer findNumByID(Integer id);

    @Select("select count(DISTINCT user_id) from `order`")
    Integer findAllOrderNum();

    Integer findNumByTwoId(Integer id1, Integer id2);
}
