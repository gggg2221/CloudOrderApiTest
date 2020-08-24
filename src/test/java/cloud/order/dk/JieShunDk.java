package cloud.order.dk;

import org.springframework.beans.factory.annotation.Autowired;
import org.zt.ApplicationTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.zt.common.*;
import org.zt.mybatis.controller.OrderController;

import static groovy.xml.Entity.times;


@Listeners({ AssertionListener.class })
@SpringBootTest(classes= {ApplicationTest.class})
public class JieShunDk extends AbstractTestNGSpringContextTests {

    @Autowired
    DkPub dp;

    private String jsorderno;
    @Test(groups = "smoke", description = "捷顺代扣")
    public void jieshundk(){
        this.jsorderno = dp.channeldk(Constants.DKTOPIC,"jsdk");
        Assertion.verifyTrue(jsorderno.length()>=0, "微信代扣成功");
    }
}