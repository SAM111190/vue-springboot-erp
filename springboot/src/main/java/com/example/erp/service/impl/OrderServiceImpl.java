package com.example.erp.service.impl;

import com.example.erp.entity.Order;
import com.example.erp.mapper.OrderMapper;
import com.example.erp.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WJ
 * @since 2022-11-10
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
