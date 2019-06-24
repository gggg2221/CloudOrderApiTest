package org.zt.service;

import org.zt.pojo.Order;

public interface OrderService {

    Order selectOrderByno(String orderno);
}
