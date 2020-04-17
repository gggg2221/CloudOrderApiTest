package org.zt.mybatis.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zt.mybatis.entity.Order;
import org.zt.mybatis.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/order")
public class OrderController {

    private final Log logger = LogFactory.getLog(OrderController.class);


    @Autowired
    OrderServiceImpl orderService;


    @RequestMapping(value="/byno", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public Map<String,Object> byno(String carNo,String createTime) {
        Map<String,Object> orderMap = new HashMap();
        Order or = orderService.getdkorder(carNo ,createTime);
        orderMap.put("order",or);
        return orderMap;

    }

    @RequestMapping(value="/byo", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public String byo(String orderNo) {
        Order or = orderService.queryorder(orderNo);
        String dkorder=or.getOrderNo();
        return dkorder;

    }
    //查询代扣订单
    @RequestMapping(value="/bno", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public String dkorder(String carNo,String createTime) throws InterruptedException {
        Thread.sleep(5000);
        Order or=orderService.getdkorder(carNo,createTime);
        System.out.println(or);
        String order=or.getOrderNo();
        return order;
    }
}