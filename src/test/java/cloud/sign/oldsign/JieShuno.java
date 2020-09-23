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
public class JieShuno extends AbstractTestNGSpringContextTests {

    //验签状态
    String regx=".*\"is_signatory\":(.+?)";

    @Autowired
    Parameters pt;

    @Autowired
    ApiRequst re;

    @Test(description = "捷顺老验签")
    public void jssignold() throws SQLException {
        String requstjson=MysqlJdbc.postdata("cloudtestdata","signold","jssignold","");
        String sign= stringmd5(requstjson+pt.getParksign());
        String response= re.signapipost(pt.getOldsignurl(),requstjson,sign).asString();
        String signstatus = (Regxvalue.getSubUtilSimple(response, regx));
        int staus = Integer.valueOf(signstatus).intValue();
        Assertion.verifyTrue(staus==1 , "捷顺验签状态："+staus);
    }
}




