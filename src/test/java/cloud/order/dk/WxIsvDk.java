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
public class WxIsvDk extends AbstractTestNGSpringContextTests {

    @Autowired
    OrderController c;

    @Autowired
    KafkaTools kf;

    @Autowired
    Refound refound;

    private String wxorderno = "";

    @Test(groups = "smoke", description = "微信代扣")
    public void wxisvdk() throws InterruptedException {
        //发送出场数据到kafka
        kf.produce(Constants.DKTOPIC, Constants.wxoutjson);
        Thread.sleep(2000);
        //查询dk订单是否成功
        String order1 = c.dkorder(Constants.WXISV, Constants.SATA);
        wxorderno = order1;
        Assertion.verifyTrue(!order1.equals(""), "微信代扣成功");
    }

    @Test(dependsOnMethods = {"wxisvdk"}, groups = "smoke", description = "微信退款")
    public void wxrefund() {
        String message = refound.reforder(wxorderno);
        Assertion.verifyTrue(message.equals("成功"), "退款成功");
    }
}