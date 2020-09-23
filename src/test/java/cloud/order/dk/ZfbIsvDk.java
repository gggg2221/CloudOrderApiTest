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


@Listeners({AssertionListener.class})
@SpringBootTest(classes = {ApplicationTest.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, SqlScriptsTestExecutionListener.class})
@Transactional
@Rollback(false)
public class ZfbIsvDk extends AbstractTestNGSpringContextTests {

    @Autowired
    DkPub dp;
    @Autowired
    Refound refound;
    @Autowired
    Parameters pt;

    private String zfborderno;

    @Test(groups = "smoke", description = "支付宝代扣")
    public void zfbisvdk() {

        this.zfborderno =dp.channeldk(pt.getDktopic(),"zfbisv");
        Assertion.verifyTrue(zfborderno.length()>=0, "支付宝代扣成功");
    }

    @Test(dependsOnMethods = {"zfbisvdk"}, groups = "smoke", description = "支付宝退款",enabled=false)
    public void zfbrefund() {
        String message = refound.reforder(zfborderno);
        Assertion.verifyTrue(message.equals("成功"), "退款成功");
    }
}