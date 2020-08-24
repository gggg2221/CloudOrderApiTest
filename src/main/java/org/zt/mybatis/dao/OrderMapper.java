package org.zt.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.zt.mybatis.entity.Order;

public interface OrderMapper {

    Order queryorder(String orderNo);

//    Order getdkorder(@Param("carNo") String carNo, @Param("orderid") String createTime);
    Order getdkorder(@Param("orderid") String orderid);

}