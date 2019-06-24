package cloud.order.zdf;

import org.zt.ApplicationTest;
import org.zt.common.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.zt.common.MysqlJdbc.Postdata;
@Listeners({ AssertionListener.class })
@SpringBootTest(classes = { ApplicationTest.class })
public class MakeMonOrder extends AbstractTestNGSpringContextTests {

    String regs="\"orderNo\":\"(.+?)\"";

    @Test(groups = "smoke",description = "生成月卡订单")
    public void makemonorder() throws SQLException {
        String requstjson = Postdata("cloudtestdata","cloud_order", "makemonorder", "");
        String res = ApiRequst.OrderApiPost(Constants.ORDER_URL, requstjson).asString();
        String order = Regxvalue.getSubUtilSimple(res, regs);
        if (!order.equals("")) {
            String source= RedisTools.RedData(order,"");
            Assertion.verifyTrue(!source.equals(""), "生成月卡订单");
        }
        else {
            Assertion.verifyFalse(true, "生成月卡订单失败:"+res);
        }
    }
}
