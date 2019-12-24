package cloud.order.dk;

import org.zt.common.ApiRequst;
import org.zt.common.Constants;
import org.zt.common.Regxvalue;

public class Refound {

    public static String reforder(String reorder){
        String regs = "\"message\":\"(.+?)\"";
        String refundorder = reorder;
        String refoundjson = "{\"serviceId\": \"ac.order.refund\",\"attributes\":{\"parkCode\":\"20181213001\",\"orderNo\":\"" + refundorder + "\",\"refundApplyNo\":\"" + refundorder + "\",\"source\":\"PARK\",\"needConfirm\":\"1\"}}";
        String res = ApiRequst.orderapipost(Constants.ORDER_URL, refoundjson).asString();
        String message = Regxvalue.getSubUtilSimple(res, regs);
        return message;
    }
}
