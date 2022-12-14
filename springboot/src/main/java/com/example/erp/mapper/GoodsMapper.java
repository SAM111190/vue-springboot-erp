package com.example.erp.mapper;

import com.example.erp.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author JHJ
 * @since 2022-11-01
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    int querySumSold();

    List<Goods> hotsold();

    List<Goods> selectPage(Integer pageNum, Integer pageSize);

    Integer selectTotal();

    @Select("select type from goods where id = #{id}")
    Integer findType(Integer id);

    @Select("select * from goods where id != #{id} and type = #{type}")
    List<Goods> findOtherGoods(Integer id, Integer type);
}
