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
public class MakeCarOrder extends AbstractTestNGSpringContextTests {

    private static String regs="\"orderNo\":\"(.+?)\"";

    @Test(groups = "smoke",description = "新车牌生成订单")
    public static String makecarorder() throws SQLException {
        String requstjson = Postdata("cloudtestdata","cloud_order", "makecarorder", "");
        String res = ApiRequst.OrderApiPost(Constants.ORDER_URL, requstjson).asString();
        String order = Regxvalue.getSubUtilSimple(res, regs);
        if (!order.equals("")) {
            String source= RedisTools.RedData(order,"");
            Assertion.verifyTrue(!source.equals(""), "车牌生成订单");
        }
        else {
            Assertion.verifyTrue(false, "车牌生成订单失败"+res);
        }
        return order;
    }

}
