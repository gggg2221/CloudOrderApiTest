package org.zt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zt.dao.OrderMapper;
import org.zt.pojo.Order;
import org.zt.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order selectOrderByno(String orderno) {

        Order od= orderMapper.selectOrderByno(orderno);
        return od;
    }

}
