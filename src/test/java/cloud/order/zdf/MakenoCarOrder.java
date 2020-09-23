package cloud.order.zdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.zt.ApplicationTest;
import org.zt.common.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.zt.common.MysqlJdbc.postdata;
@Listeners({ AssertionListener.class })
@SpringBootTest(classes = { ApplicationTest.class })
public class MakenoCarOrder extends AbstractTestNGSpringContextTests {

    String regs="\"orderNo\":\"(.+?)\"";

    @Autowired
    Parameters pt;

    @Autowired
    RedisTools redis;

    @Autowired
    ApiRequst re;

    @Test(enabled = false,groups = "smoke",description = "新无牌车扫码生成订单")
    public void makenocarorder() throws SQLException {
        String requstjson = postdata("cloudtestdata","cloud_order", "makenocarorder", "");
        String res = re.orderapipost(pt.getOrderurl(), requstjson).asString();
        String order = Regxvalue.getSubUtilSimple(res, regs);
        if (!order.equals("")) {
            String source= redis.reddata(order,"");
            Assertion.verifyTrue(!source.equals(""), "生成无牌车订单");
        }
        else {
            Assertion.verifyTrue(false, "生成无牌车订单失败"+res);
        }
    }
}
