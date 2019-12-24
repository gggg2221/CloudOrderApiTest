package org.zt.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.zt.mybatis.entity.Order;

public interface OrderMapper {

    Order queryorder(String orderNo);

    Order getdkorder(@Param("carNo") String carNo, @Param("createTime") String createTime);

}