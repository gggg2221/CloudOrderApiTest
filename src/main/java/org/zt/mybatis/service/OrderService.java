package org.zt.mybatis.service;

import org.zt.mybatis.entity.Order;

import java.util.List;


public interface OrderService {

    Order queryorder(String orderNo);

    Order getdkorder(String carNo, String createTime);

}
