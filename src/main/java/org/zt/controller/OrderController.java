package org.zt.controller;

import org.zt.pojo.Order;
import org.zt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/Order"})
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = {"/findAll"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public void Dkorder(String orderno) {
        String no = "BKbb7604bef7a94edca4864eb9c1b833";
        Order od = orderService.selectOrderByno(no);
        System.out.println(od);
    }
}

