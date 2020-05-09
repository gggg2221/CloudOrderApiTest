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
public class OrderFc extends AbstractTestNGSpringContextTests {
	String rgex = ".*\"message\":\"(.+?)\"";

	@Autowired
    ApiRequst re;

	@Test(description = "订单反查")
	// 订单反查
	public void orderfc() throws SQLException {
        String requstjson = postdata("cloudtestdata","cloud_order","orderfc","");
		String res = re.orderapipost(Constants.ORDER_URL, requstjson).asString();
		String result = (Regxvalue.getSubUtilSimple(res, rgex));
    	Assertion.verifyTrue(result.equals("成功"), "查询成功");

	}

}
