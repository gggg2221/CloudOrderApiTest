package cloud.order.zdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.stereotype.Service;
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
public class MakeCarOrder extends AbstractTestNGSpringContextTests {

    private String regs="\"orderNo\":\"(.+?)\"";

    @Autowired
    Parameters pt;

    @Autowired
    RedisTools redis;

    @Autowired
    ApiRequst re;

    @Test(groups = "smoke",description = "新车牌生成订单")
    public String makecarorder() throws SQLException {
        String requstjson = postdata("cloudtestdata","cloud_order", "makecarorder", "");
        String res = re.orderapipost(pt.getOrderurl(), requstjson).asString();
        String order = Regxvalue.getSubUtilSimple(res, regs);
        if (!order.equals("")) {
            String source= redis.reddata(order,"");
            Assertion.verifyTrue(!source.equals(""), "车牌生成订单");
        }
        else {
            Assertion.verifyTrue(false, "车牌生成订单失败"+res);
        }
        return order;
    }

}
