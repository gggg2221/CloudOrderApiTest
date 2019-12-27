package cloud.sign.oldsign;

import org.springframework.beans.factory.annotation.Autowired;
import org.zt.ApplicationTest;
import org.zt.common.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.zt.common.MD5.stringmd5;

@Listeners({ AssertionListener.class })
@SpringBootTest(classes = { ApplicationTest.class })
public class ZfbIsvo extends AbstractTestNGSpringContextTests {

    //验签状态
    String regx=".*\"is_signatory\":(.+?)";

    @Autowired
    Constants con;

    @Autowired
    ApiRequst re;

    @Test(description = "支付宝车主平台老验签")
    public void zfbisvoldsign() throws SQLException {
        String requstjson =MysqlJdbc.postdata("cloudtestdata","signold","zfbisvoldsign","");
        //获取验签反查密钥
        String sign= stringmd5(requstjson+con.PARKSIG);
        String response= re.signapipost(con.OLDSIGN_URL,requstjson,sign).asString();
        String signstatus = (Regxvalue.getSubUtilSimple(response, regx));
        int staus = Integer.valueOf(signstatus).intValue();
        Assertion.verifyTrue(staus==1 , "支付宝车主验签状态："+staus);
    }
}
