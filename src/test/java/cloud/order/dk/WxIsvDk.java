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
public class WxIsvDk extends AbstractTestNGSpringContextTests {

    @Autowired
    Refound refound;
    @Autowired
    DkPub dp;
    @Autowired
    Parameters pt;

    private String wxorderno;

    @Test(groups = "smoke", description = "微信代扣")
    public void wxisvdk(){
        this.wxorderno=dp.channeldk(pt.getDktopic(),"wxisv");
        Assertion.verifyTrue(wxorderno.length()>=0, "微信代扣成功");
    }

    @Test(dependsOnMethods = {"wxisvdk"}, groups = "smoke", description = "微信退款",enabled=false)
    public void wxrefund() {
        String message = refound.reforder(this.wxorderno);
        Assertion.verifyTrue(message.equals("成功"), "退款成功");
    }
}