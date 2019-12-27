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
public class MakeMonOrder extends AbstractTestNGSpringContextTests {

    String regs="\"orderNo\":\"(.+?)\"";

    @Autowired
    ApiRequst re;

    @Autowired
    RedisTools redis;

    @Autowired
    Constants con;

    @Test(groups = "smoke",description = "生成月卡订单")
    public void makemonorder() throws SQLException {
        String requstjson = postdata("cloudtestdata","cloud_order", "makemonorder", "");
        String res = re.orderapipost(con.ORDER_URL, requstjson).asString();
        String order = Regxvalue.getSubUtilSimple(res, regs);
        if (!order.equals("")) {
            String source= redis.reddata(order,"");
            Assertion.verifyTrue(!source.equals(""), "生成月卡订单");
        }
        else {
            Assertion.verifyFalse(true, "生成月卡订单失败:"+res);
        }
    }
}
