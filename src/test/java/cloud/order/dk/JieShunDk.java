package cloud.order.dk;

import org.zt.ApplicationTest;
import org.zt.common.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.sql.SQLException;

@Listeners({ AssertionListener.class })
@SpringBootTest(classes= {ApplicationTest.class})
public class JieShunDk extends AbstractTestNGSpringContextTests {


    private static String times=Constants.sata;
    private static String orderid=Constants.oderid;

    @Test(groups = "smoke", description = "捷顺代扣")
    public static void jieshundk() throws SQLException, InterruptedException {
        KafkaTools kf = new KafkaTools();
        //入场验签写kafka(验签case已经完成，此处不需要实现)
        //发送出场数据到kafka
        String outjson = "{\"isReal\":0,\"parkName\":\"\",\"ysMoney\":0.01,\"yhMoney\":0.0,\"inEquipName\":\"入口\",\"outMode\":\"NORMAL\",\"outOperator\":\"Admin\",\"outEquipCode\":\"2\",\"ssMoney\":0.01,\"freeMoney\":0,\"dkTag\":1,\"orderNo\":\"\",\"outCarPhoto\":\"20181213001/NISSP_IMG_PARK_OUT/20181112/1\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\",\"overTimeFlag\":0,\"idno\":\"16100552\",\"inRecordId\":\"" + times + "\",\"payTypeName\":\"云代扣\",\"carNumber\":\"藏-JK1111\",\"inTime\":\"" + times + "\",\"itemId\":\"" + orderid + "\",\"outEquipName\":\"出口\",\"inEquipCode\":\"1\",\"parkCode\":\"20181213001\",\"hgMoney\":0.0,\"outTime\":\"" + times + "\"}";
        kf.produce(Constants.DkTopic, outjson);
        //查询dk订单是否成功
        Thread.sleep(3000);
        String sql = "SELECT ORDER_NO from cs_biz_order where CREATE_TIME=\"" + times + "\" and status=0;";
        String order=MysqlJdbc.seledata("cloud-db", sql, "ORDER_NO");
        System.out.println(order);
        Assertion.verifyTrue(!order.equals(""), "代扣成功");
    }
}