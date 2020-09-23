package cloud.order.query;

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
public class OrderMainQurey extends AbstractTestNGSpringContextTests {

        String regx=".*\"transactionId\":\"(.+?)\"";

        @Autowired
        ApiRequst re;

        @Autowired
        Parameters pt;

        @Test(description = "订单主表查询")
        public void ordermainquery() throws SQLException {
            String requstjson = postdata("cloudtestdata","cloud_order","ordermainquery","");
            String res = re.orderapipost(pt.getOrderurl(), requstjson).asString();
            String transactionId = (Regxvalue.getSubUtilSimple(res, regx));
            if(!transactionId.equals("")) {
                Assertion.verifyTrue(!transactionId.equals(""), "订单主表查询");
            }
            else {
                Assertion.verifyTrue(false, "订单主表查询"+res);
            }

    }

}
