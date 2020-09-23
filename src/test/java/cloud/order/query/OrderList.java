package cloud.order.query;

import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
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
public class OrderList extends AbstractTestNGSpringContextTests {

    String rgex = ".*\"resultCode\":(.+?)";

    @Autowired
    Parameters pt;

    @Autowired
    ApiRequst re;


	@Test(groups = "smoke",description = "查询订单列表(非未支付)")
	// 查询订单列表（非未支付）
	public void orderlist0() throws SQLException {
		String requstjson = postdata("cloudtestdata","cloud_order","orderlist0","");
		String res = re.orderapipost(pt.getOrderurl(), requstjson).asString();
		String code = Regxvalue.getSubUtilSimple(res, rgex);
		if (code.equals("0")) {
			Assertion.verifyTrue(code.equals("0"), "查询成功");
		} else {
			Assertion.verifyTrue(false, "查询订单异常,错误码:\" + code");
		}
	}

	@Test(groups = "smoke",description = "查询订单列表(未支付代扣订单)")
	// 查询订单列表（未支付代扣订单）
	public void orderlist1() throws SQLException {
        String requstjson = postdata("cloudtestdata","cloud_order","orderlist1","");
		String res = re.orderapipost(pt.getOrderurl(), requstjson).asString();
		String code = Regxvalue.getSubUtilSimple(res, rgex);
		if (code.equals("0")) {
			Assertion.verifyTrue(code.equals("0"), "查询成功:");
		} else {
            Assertion.verifyTrue(false, "查询订单异常,错误码:\" + code");
		}
	}

	@Test(groups = "smoke",description = "查询订单列表(支付失败订单查询)")
	// 查询订单列表（支付失败订单查询）
	public void orderlist2() throws SQLException {
        String requstjson = postdata("cloudtestdata","cloud_order","orderlist2","");
		String res = re.orderapipost(pt.getOrderurl(), requstjson).asString();
		String code = Regxvalue.getSubUtilSimple(res, rgex);
		if (code.equals("0")) {
			Assertion.verifyTrue(code.equals("0"), "查询成功");
		} else {
            Assertion.verifyTrue(false, "查询订单异常,错误码:\" + code");
		}
	}

	@Test(description = "查询订单列表(查询单位时间段内的所有订单)")
	// 查询订单列表（查询单位时间段内的所有订单）
	public void orderlist3() throws SQLException {
        String requstjson = postdata("cloudtestdata","cloud_order","orderlist3","");
		String res = re.orderapipost(pt.getOrderurl(), requstjson).asString();
		String busno = "880075588888888";
		int count = StringUtils.countMatches(res, busno);
		if (count >= 4) {
			Assertion.verifyTrue(count >= 4, "查询成功");
		} else {
			Assertion.verifyTrue(false, "查询数量不正确与实际数据不匹配(查询时间单位内的所有订单)"+"实际订单数量:"+count);
		}
	}
}
