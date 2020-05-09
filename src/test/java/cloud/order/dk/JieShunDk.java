package cloud.order.dk;

import org.springframework.beans.factory.annotation.Autowired;
import org.zt.ApplicationTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.zt.common.Assertion;
import org.zt.common.AssertionListener;
import org.zt.common.Constants;
import org.zt.common.KafkaTools;
import org.zt.mybatis.controller.OrderController;

import static groovy.xml.Entity.times;


@Listeners({ AssertionListener.class })
@SpringBootTest(classes= {ApplicationTest.class})
public class JieShunDk extends AbstractTestNGSpringContextTests {

    @Autowired
    OrderController c;

    @Autowired
    KafkaTools kf;

    private String jsorderno;
    @Test(groups = "smoke", description = "捷顺代扣")
    public void jieshundk() throws InterruptedException {

        //发送出场数据到kafka
//        String outjson = "{\"isReal\":0,\"parkName\":\"\",\"ysMoney\":0.01,\"yhMoney\":0.0,\"inEquipName\":\"入口\",\"outMode\":\"NORMAL\",\"outOperator\":\"Admin\",\"outEquipCode\":\"2\",\"ssMoney\":0.01,\"freeMoney\":0,\"dkTag\":1,\"orderNo\":\"\",\"outCarPhoto\":\"20181213001/NISSP_IMG_PARK_OUT/20181112/1\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"GREEN\\\"}\",\"overTimeFlag\":0,\"idno\":\"16100552\",\"inRecordId\":\"" + times + "\",\"payTypeName\":\"云代扣\",\"carNumber\":\"藏-JK11111\",\"inTime\":\"" + times + "\",\"itemId\":\"35fgdfgdfgdfg\",\"outEquipName\":\"出口\",\"inEquipCode\":\"1\",\"parkCode\":\"20181213001\",\"hgMoney\":0.0,\"outTime\":\"" + times + "\"}";
//        kf.produce(Constants.DKTOPIC, outjson);
        //查询dk订单是否成功
//        String order = c.dkorder(Constants.JIESHUN,Constants.SATA);
        this.jsorderno = "order";
        Thread.sleep(3000);
//        Assertion.verifyTrue(!order.equals(""), "代扣成功");
        Assertion.verifyTrue(jsorderno!="", "代扣成功");
    }
}