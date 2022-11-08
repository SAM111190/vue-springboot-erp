package com.example.erp.mapper;

import com.example.erp.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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
}
