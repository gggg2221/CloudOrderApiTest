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
public class OrderDetails extends AbstractTestNGSpringContextTests {

	String rgex = ".*\"message\":\"(.+?)\"";

	@Autowired
    ApiRequst re;
	@Autowired
    Parameters pt;


	@Test(description = "订单详情查询")
	// 查询订单详情
	public void orderdetails() throws SQLException {
        String requstjson = postdata("cloudtestdata","cloud_order","orderdetails","");
		String res = re.orderapipost(pt.getOrderurl(), requstjson).asString();
		String result = (Regxvalue.getSubUtilSimple(res, rgex));
        Assertion.verifyTrue(result.equals("成功"), "查询成功");

	}

}
