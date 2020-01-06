package org.zt.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zt.mybatis.dao.OrderMapper;
import org.zt.mybatis.entity.Order;
import org.zt.mybatis.service.OrderService;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderMapper orderMapper;

    @Override
    public Order queryorder(String orderNo){
        return orderMapper.queryorder(orderNo);
    }

    @Override
    public Order getdkorder(String carNo,String createTime){return orderMapper.getdkorder(carNo,createTime);}


}
