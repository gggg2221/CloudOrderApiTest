package cloud.sign.newsign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.zt.ApplicationTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.zt.common.Assertion;
import org.zt.common.AssertionListener;
import org.zt.common.Constants;
import org.zt.common.SignCom;


@Listeners({AssertionListener.class})
@SpringBootTest(classes = {ApplicationTest.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, SqlScriptsTestExecutionListener.class})
@Transactional
@Rollback(false)
public class ZfbIsv extends AbstractTestNGSpringContextTests {

    @Autowired
    SignCom sign;

    @Test(description = "支付宝车主平台验签及验签反查")
    public void zfbisv() {
        //获取验签反查密钥
        int staus = sign.signnew("zfbisv");
        Assertion.verifyTrue(staus == 1, "支付宝车主验签状态：" + staus);
    }

//    @Test(description = "支付宝车主签名失败")
//    public void zfbsignerror(){
//        //获取验签反查密钥
//        String sign="dfdsf435435345gdfgd";
//        String response= ApiRequst.signapipost(con.SIGN_URL,requstjson,sign).asString();
//        String signstatus = (Regxvalue.getSubUtilSimple(response, rgx));
//        Assertion.verifyTrue(signstatus.equals("1"), "支付宝车主验签返回："+response);
//    }
//
//    @Test(description = "未开通支付宝车主代扣")
//    public void zfbclose(){
//        //获取验签反查密钥
//        String sign= stringmd5(requstjson+con.PARKSIG);
//        String response= ApiRequst.signapipost(con.SIGN_URL,requstjson,sign).asString();
//        String signstatus = (Regxvalue.getSubUtilSimple(response, regx));
//        int staus = Integer.valueOf(signstatus).intValue();
//        Assertion.verifyTrue(staus!=1 , "支付宝车主验签状态："+staus);
//    }
}
