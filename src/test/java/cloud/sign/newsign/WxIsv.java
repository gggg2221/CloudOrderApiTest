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
import org.zt.common.SignPub;


@Listeners({AssertionListener.class})
@SpringBootTest(classes = {ApplicationTest.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, SqlScriptsTestExecutionListener.class})
@Transactional
@Rollback(false)
public class WxIsv extends AbstractTestNGSpringContextTests {

    @Autowired
    SignPub sign;

    @Test(description = "微信车主平台验签及验签反查")
    public void wxisv(){
        //获取验签反查密钥
        int status=sign.signnew("wxisv");
        Assertion.verifyTrue(status==1 , "微信车主验签状态："+status);
    }

//    @Test(description = "微信车主签名失败")
//    public void wxsignerror(){
//        //获取验签反查密钥
//        String sign="dfdsf435435345gdfgd";
//        String response= ApiRequst.signapipost(con.SIGN_URL,requstjson,sign).asString();
//        String signstatus = (Regxvalue.getSubUtilSimple(response, rgx));
//        Assertion.verifyTrue(signstatus.equals("1"), "微信车主验签返回："+response);
//    }

//    @Test(description = "未开通微信车主代扣")
//    public void wxclose(){
//        //获取验签反查密钥
//        int status=sig.signnew("wxisv");
//        Assertion.verifyTrue(status!=1 , "微信车主验签状态："+status);
//    }

}
