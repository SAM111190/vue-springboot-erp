package com.example.erp.mapper;

import com.example.erp.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WJ
 * @since 2022-11-10
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    @Select("select * from `order` where game_id = #{id}")
    List<Order> findAllOrderById(Integer id);

    @Select("select count(DISTINCT user_id) from `order` where game_id = #{id}")
    Integer findNumByID(Integer id);

    @Select("select count(DISTINCT user_id) from `order`\n" +
            "where game_id in (select id from goods where type = #{type})")
    Integer findAllOrderNum(Integer type);

    Integer findNumByTwoId(Integer id1, Integer id2);
}
