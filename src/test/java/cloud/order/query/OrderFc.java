package cloud.order.query;

import java.sql.SQLException;

import org.zt.ApplicationTest;
import org.zt.common.AssertionListener;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.zt.common.ApiRequst;
import org.zt.common.Assertion;
import org.zt.common.Constants;
import org.zt.common.Regxvalue;

import static org.zt.common.MysqlJdbc.Postdata;

@Listeners({ AssertionListener.class })
@SpringBootTest(classes = { ApplicationTest.class })
public class OrderFc extends AbstractTestNGSpringContextTests {
	String rgex = ".*\"orderNo\":\"(.+?)\"";

	@Test(description = "订单反查")
	// 订单反查
	public void orderfc() throws SQLException {
        String requstjson = Postdata("cloudtestdata","cloud_order","orderfc","");
		String res = ApiRequst.OrderApiPost(Constants.ORDER_URL, requstjson).asString();
		String order = (Regxvalue.getSubUtilSimple(res, rgex));
		if (order != "") {
			Assertion.verifyTrue(order != "", "查询成功");
		} else {
            Assertion.verifyTrue(false, "查询失败"+res);
		}

	}

}
