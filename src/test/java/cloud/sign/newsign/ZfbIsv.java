package cloud.sign.newsign;

import org.zt.ApplicationTest;
import org.zt.common.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.zt.common.MD5.StringMD5;

@Listeners({ AssertionListener.class })
@SpringBootTest(classes = { ApplicationTest.class })
public class ZfbIsv extends AbstractTestNGSpringContextTests {

    //验签状态
    String regx=".*\"isSignatory\":(.+?)";
    KafkaTools kf = new KafkaTools();

    @Test(description = "支付宝车主平台验签及验签反查")
    public void zfbisv(){
        String requstjson ="{\"serviceId\":\"fc.park.signatoryResult.OrderQuery\",\"data\":{\"parkCode\":\"20181213001\",\"dataItems\":[{\"carNo\":\"藏-Z12345\",\"inTime\":\""+Constants.sata+"\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\"}]}}";
        //获取验签反查密钥
        String sign=StringMD5(requstjson+Constants.parksig);
        String response= ApiRequst.SignApiPost(Constants.SIGN_URL,requstjson,sign).asString();
        String signstatus = (Regxvalue.getSubUtilSimple(response, regx));
        int staus = Integer.valueOf(signstatus).intValue();
        Assertion.verifyTrue(staus==1 , "支付宝车主验签状态："+staus);
    }

    @Test(description = "支付宝车主签名失败")
    public void zfbsignerror(){
        String requstjson ="{\"serviceId\":\"fc.park.signatoryResult.OrderQuery\",\"data\":{\"parkCode\":\"20181213001\",\"dataItems\":[{\"carNo\":\"藏-Z12345\",\"inTime\":\""+Constants.sata+"\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\"}]}}";
        //获取验签反查密钥
        String sign="dfdsf435435345gdfgd";
        String response= ApiRequst.SignApiPost(Constants.SIGN_URL,requstjson,sign).asString();
        String rgx=".*\"result\":\"(.+?)\"";
        String signstatus = (Regxvalue.getSubUtilSimple(response, rgx));
        Assertion.verifyTrue(signstatus.equals("1"), "支付宝车主验签返回："+response);
    }

    @Test(description = "未开通支付宝车主代扣")
    public void zfbclose(){
        String requstjson ="{\"serviceId\":\"fc.park.signatoryResult.OrderQuery\",\"data\":{\"parkCode\":\"20181213001\",\"dataItems\":[{\"carNo\":\"藏-Z12346\",\"inTime\":\""+Constants.sata+"\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\"}]}}";
        //获取验签反查密钥
        String sign=StringMD5(requstjson+Constants.parksig);
        String response= ApiRequst.SignApiPost(Constants.SIGN_URL,requstjson,sign).asString();
        String signstatus = (Regxvalue.getSubUtilSimple(response, regx));
        int staus = Integer.valueOf(signstatus).intValue();
        Assertion.verifyTrue(staus!=1 , "支付宝车主验签状态："+staus);
    }
}
