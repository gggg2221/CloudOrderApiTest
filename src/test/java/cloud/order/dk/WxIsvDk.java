package cloud.order.dk;

import org.zt.ApplicationTest;
import org.zt.common.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.sql.SQLException;

@Listeners({AssertionListener.class})
@SpringBootTest(classes = {ApplicationTest.class})
public class WxIsvDk extends AbstractTestNGSpringContextTests {

    private static String orderno = "";
    private static String rorderid = "";
    private static String times = Constants.sata;
    private static String orderid = Constants.oderid;

    @Test(groups = "smoke", description = "微信代扣")
    public static void wxisvdk() throws SQLException, InterruptedException {
        KafkaTools kf = new KafkaTools();
        //入场验签写kafka(验签case已经完成，此处不需要实现)
        //发送出场数据到kafka
        String outjson = "{\"isReal\":0,\"parkName\":\"\",\"ysMoney\":0.01,\"yhMoney\":0.0,\"inEquipName\":\"入口\",\"outMode\":\"NORMAL\",\"outOperator\":\"Admin\",\"outEquipCode\":\"2\",\"ssMoney\":0.01,\"freeMoney\":0,\"dkTag\":1,\"orderNo\":\"\",\"outCarPhoto\":\"20181213001/NISSP_IMG_PARK_OUT/20181112/1\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\",\"overTimeFlag\":0,\"idno\":\"01181016100552\",\"inRecordId\":\"" + orderid + "\",\"payTypeName\":\"云代扣\",\"carNumber\":\"藏-WW1111\",\"inTime\":\"" + times + "\",\"itemId\":\"" + orderid + "\",\"outEquipName\":\"出口\",\"inEquipCode\":\"1\",\"parkCode\":\"20181213001\",\"hgMoney\":0.0,\"outTime\":\"" + times + "\"}";
        kf.produce(Constants.DkTopic, outjson);
        Thread.sleep(10000);
        //查询dk订单是否成功
        String sql1 = "SELECT ORDER_NO from cs_biz_order where MER_GID='藏-WW1111' and PAY_TYPE='WX' and status=0 ORDER BY CREATE_TIME DESC LIMIT 1;";
        String order1 = MysqlJdbc.seledata("cloud-db", sql1, "ORDER_NO");
        orderno = order1;
        Assertion.verifyTrue(!orderno.equals(""), "代扣成功");
    }

    @Test(dependsOnMethods = {"wxisvdk"}, groups = "smoke", description = "微信退款")
    public static void wxrefund() throws SQLException, InterruptedException {
        String refundorder = orderno;
        System.out.println(refundorder);
        String refoundjson = "{\"serviceId\": \"ac.order.refund\",\"attributes\":{\"parkCode\":\"20181213001\",\"orderNo\":\"" + refundorder + "\",\"refundApplyNo\":\"" + refundorder + "\",\"source\":\"PARK\",\"needConfirm\":\"1\"}}";
        ApiRequst.OrderApiPost(Constants.ORDER_URL, refoundjson);
        Thread.sleep(3000);
        String sql2 = "SELECT ORDER_NO from cs_biz_order where status=300 and ORDER_NO=\"" + refundorder + "\"";
        String order2 = MysqlJdbc.seledata("cloud-db", sql2, "ORDER_NO");
        System.out.println(order2);
        Assertion.verifyTrue(!order2.equals(""), "退款成功");
    }
}