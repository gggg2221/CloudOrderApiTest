package org.zt.mybatis.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zt.mybatis.entity.Order;
import org.zt.mybatis.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/order")
public class OrderController {

    private final Log logger = LogFactory.getLog(OrderController.class);


    @Autowired
    OrderServiceImpl orderService;


//    @RequestMapping(value="/byno", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
//    public Map<String,Object> byno(String orderNo) {
//        Map<String,Object> orderMap = new HashMap();
//        Order or = orderService.queryorder(orderNo);
//        orderMap.put("or",or);
//        return orderMap;
//
//    }

    @RequestMapping(value="/byo", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public String byo(String orderNo) {
        Order or = orderService.queryorder(orderNo);
        String dkorder=or.getOrderNo();
        return dkorder;

    }
    //查询代扣订单
    @RequestMapping(value="/bno", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public String dkorder(String carNo,String createTime) {
        Order or = orderService.getdkorder(carNo,createTime);
        String dkorder=or.getOrderNo();
        return dkorder;

    }
}