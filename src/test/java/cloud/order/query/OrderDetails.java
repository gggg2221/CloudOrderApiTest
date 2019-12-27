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

	String rgex = ".*\"orderNo\":\"(.+?)\"";

	@Autowired
    Constants con;

	@Autowired
    ApiRequst re;

	@Test(description = "订单详情查询")
	// 查询订单详情
	public void orderdetails() throws SQLException {
        String requstjson = postdata("cloudtestdata","cloud_order","orderdetails","");
		String res = re.orderapipost(con.ORDER_URL, requstjson).asString();
		String order = (Regxvalue.getSubUtilSimple(res, rgex));
		if (!order.equals("")) {
			Assertion.verifyTrue(!order.equals(""), "查询成功");
		} else {
			Assertion.verifyTrue(false, "查询失败"+res);
		}

	}

}
