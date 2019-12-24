package cloud.order.prepay;

import cloud.order.zdf.MakeCarOrder;
import org.zt.ApplicationTest;
import org.zt.common.ApiRequst;
import org.zt.common.Assertion;
import org.zt.common.Constants;
import org.zt.common.MysqlJdbc;
import org.zt.common.AssertionListener;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.sql.SQLException;

@Listeners({ AssertionListener.class })
@SpringBootTest(classes = { ApplicationTest.class })
public class OrderPrepay extends AbstractTestNGSpringContextTests {

    public String col="ORDER_NO";

    @Test(groups = "smoke", description = "支付宝车牌缴费预支付")
    public void zfbprepay() throws SQLException {
        String order= MakeCarOrder.makecarorder();
        String zfbjson = "{\"attributes\": {\"appType\":\"APP_JSCARLIFE\",\"channelId\": \"ZFB\",\"orderNo\": \""
                + order + "\"},\"serviceId\": \"ac.pay.prepay\"}";
        String zfbsta = ApiRequst.orderapipost(Constants.ORDER_URL, zfbjson).asString();
        String sql="select "+col+" from cs_biz_order where ORDER_NO='"+order+"'";
        String redata=MysqlJdbc.seledata("cloud-db",sql,col);
        Assertion.verifyTrue(!redata.equals(""), "创建支付宝车牌预支付订单"+zfbsta);
    }

    @Test(groups = "smoke", description = "微信车牌缴费预支付")
    public void wxprepay() throws SQLException {
        String order= MakeCarOrder.makecarorder();
        String zfbjson = "{\"attributes\": {\"appType\":\"APP_JSCARLIFE\",\"channelId\": \"WX\",\"orderNo\": \""
                + order + "\"},\"serviceId\": \"ac.pay.prepay\"}";
        String wxbsta = ApiRequst.orderapipost(Constants.ORDER_URL, zfbjson).asString();
        String sql="select "+col+" from cs_biz_order where ORDER_NO='"+order+"'";
        String redata=MysqlJdbc.seledata("cloud-db",sql,col);
        Assertion.verifyTrue(!redata.equals(""), "创建微信车牌预支付订单"+wxbsta);
    }
}
