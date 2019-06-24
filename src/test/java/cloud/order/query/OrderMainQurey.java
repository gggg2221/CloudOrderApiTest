package cloud.order.query;

import org.zt.ApplicationTest;
import org.zt.common.ApiRequst;
import org.zt.common.Assertion;
import org.zt.common.Constants;
import org.zt.common.Regxvalue;
import org.zt.common.AssertionListener;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.zt.common.MysqlJdbc.Postdata;

@Listeners({ AssertionListener.class })
@SpringBootTest(classes = { ApplicationTest.class })
public class OrderMainQurey extends AbstractTestNGSpringContextTests {

        String regx=".*\"transactionId\":\"(.+?)\"";

        @Test(description = "订单主表查询")
        public void ordermainquery() throws SQLException {
            String requstjson = Postdata("cloudtestdata","cloud_order","ordermainquery","");
            String res = ApiRequst.OrderApiPost(Constants.ORDER_URL, requstjson).asString();
            String transactionId = (Regxvalue.getSubUtilSimple(res, regx));
            if(!transactionId.equals("")) {
                Assertion.verifyTrue(!transactionId.equals(""), "订单主表查询");
            }
            else {
                Assertion.verifyTrue(false, "订单主表查询"+res);
            }

    }

}
