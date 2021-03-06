package cloud.order.query;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.zt.ApplicationTest;
import org.zt.common.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.zt.common.MysqlJdbc.postdata;

@Listeners({ AssertionListener.class })
@SpringBootTest(classes = { ApplicationTest.class })
public class OrderPayType extends AbstractTestNGSpringContextTests {

	String rgex = ".*\"payType\":\"(.+?)\"";

	@Autowired
    ApiRequst re;

    @Autowired
    Parameters pt;

	@Test(description = "订单可用支付方式查询")
	// 订单可用支付方式查询
	public void orderpaytype() throws SQLException {
        String requstjson = postdata("cloudtestdata","cloud_order","orderpaytype","");
		String res = re.orderapipost(pt.getOrderurl(), requstjson).asString();
		String pytype = (Regxvalue.getSubUtilSimple(res, rgex));
		if (!pytype.equals("")) {
			Assertion.verifyTrue(!pytype.equals(""), "查询支付方式成功:");
		} else {
			Assertion.verifyTrue(false, "查询订单异常或未查询到对应支付方式");
		}

	}

}
