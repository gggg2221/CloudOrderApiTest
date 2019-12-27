package org.zt.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Refound {

    @Autowired
    ApiRequst re;

    public String reforder(String reorder){
        String regs = "\"message\":\"(.+?)\"";
        String refundorder = reorder;
        String refoundjson = "{\"serviceId\": \"ac.order.refund\",\"attributes\":{\"parkCode\":\"20181213001\",\"orderNo\":\"" + refundorder + "\",\"refundApplyNo\":\"" + refundorder + "\",\"source\":\"PARK\",\"needConfirm\":\"1\"}}";
        String res = re.orderapipost(Constants.ORDER_URL, refoundjson).asString();
        String message = Regxvalue.getSubUtilSimple(res, regs);
        return message;
    }
}
