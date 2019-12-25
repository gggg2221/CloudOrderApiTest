package cloud.order.dk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.zt.ApplicationTest;
import org.zt.common.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.zt.mybatis.controller.OrderController;


@Listeners({AssertionListener.class})
@SpringBootTest(classes = {ApplicationTest.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, SqlScriptsTestExecutionListener.class})
@Transactional
@Rollback(false)
public class ZfbIsvDk extends AbstractTestNGSpringContextTests {

    private static String zfborderno = "";

    @Autowired
    OrderController c;

    @Autowired
    KafkaTools kf;

    @Test(groups = "smoke", description = "支付宝代扣")
    public void zfbisvdk() throws InterruptedException {
        //发送出场数据到kafka
        String outjson = Constants.zfboutjson;
        kf.produce(Constants.DKTOPIC, outjson);
        Thread.sleep(2000);
        //查询dk订单是否成功
        String order2 = c.dkorder(Constants.ZFBISV, Constants.SATA);
        zfborderno = order2;
        Assertion.verifyTrue(!order2.equals(""), "支付宝代扣成功");
    }

    @Test(dependsOnMethods = {"zfbisvdk"}, groups = "smoke", description = "支付宝退款")
    public void zfbrefund() {
        String message = Refound.reforder(zfborderno);
        Assertion.verifyTrue(message.equals("成功"), "退款成功");
    }
}