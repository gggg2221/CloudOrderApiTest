package cloud.order.dk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.zt.ApplicationTest;
import org.zt.common.*;
import org.zt.mybatis.controller.OrderController;


@Listeners({AssertionListener.class})
@SpringBootTest(classes = {ApplicationTest.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, SqlScriptsTestExecutionListener.class})
@Transactional
@Rollback(false)
public class OtherIsvDk extends AbstractTestNGSpringContextTests {

    @Autowired
    OrderController c;

    @Autowired
    KafkaTools kf;

    @Autowired
    Refound refound;

    private String otherorderno;

    @Test(groups = "smoke", description = "其他代扣")
    public void otherisvdk() throws InterruptedException {
        //发送出场数据到kafka
        kf.produce(Constants.DKTOPIC, Constants.otheroutjson);
        //查询dk订单是否成功
        String order = c.dkorder(Constants.othercarno, Constants.SATA);
        System.out.println("+++++++++++++++++++++++++++++++++++"+order);
        this.otherorderno = order;
        Assertion.verifyTrue(otherorderno.length()>0, "代扣成功");
    }
}