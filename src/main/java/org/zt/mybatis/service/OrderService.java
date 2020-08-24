package org.zt.mybatis.service;

import org.zt.mybatis.entity.Order;



public interface OrderService {

    Order queryorder(String orderNo);

//    Order getdkorder(String carNo, String createTime);
    Order getdkorder(String orderid);

}
