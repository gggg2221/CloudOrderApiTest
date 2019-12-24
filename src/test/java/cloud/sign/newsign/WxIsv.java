package cloud.sign.newsign;

import org.zt.ApplicationTest;
import org.zt.common.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.zt.common.MD5.stringmd5;
@Listeners({ AssertionListener.class })
@SpringBootTest(classes = { ApplicationTest.class })
public class WxIsv extends AbstractTestNGSpringContextTests {

    //验签状态
    String regx=".*\"isSignatory\":(.+?)";
    private static String wxcarno=Constants.WXISV;

    @Test(description = "微信车主平台验签及验签反查")
    public void wxisv(){
        String requstjson ="{\"serviceId\":\"fc.park.signatoryResult.OrderQuery\",\"data\":{\"parkCode\":\"20181213001\",\"dataItems\":[{\"carNo\":\""+wxcarno+"\",\"inTime\":\""+Constants.SATA +"\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\"}]}}";
        //获取验签反查密钥
        String sign= stringmd5(requstjson+Constants.PARKSIG);
        String response= ApiRequst.signapipost(Constants.SIGN_URL,requstjson,sign).asString();
        String signstatus = (Regxvalue.getSubUtilSimple(response, regx));
        int staus = Integer.valueOf(signstatus).intValue();
        Assertion.verifyTrue(staus==1 , "微信车主验签状态："+staus);
    }

    @Test(description = "微信车主签名失败")
    public void wxsignerror(){
        String requstjson ="{\"serviceId\":\"fc.park.signatoryResult.OrderQuery\",\"data\":{\"parkCode\":\"20181213001\",\"dataItems\":[{\"carNo\":\"藏-WX0000\",\"inTime\":\""+Constants.SATA +"\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\"}]}}";
        //获取验签反查密钥
        String sign="dfdsf435435345gdfgd";
        String response= ApiRequst.signapipost(Constants.SIGN_URL,requstjson,sign).asString();
        String rgx=".*\"result\":\"(.+?)\"";
        String signstatus = (Regxvalue.getSubUtilSimple(response, rgx));
        Assertion.verifyTrue(signstatus.equals("1"), "微信车主验签返回："+response);
    }

    @Test(description = "未开通微信车主代扣")
    public void wxclose(){
        String requstjson ="{\"serviceId\":\"fc.park.signatoryResult.OrderQuery\",\"data\":{\"parkCode\":\"20181213001\",\"dataItems\":[{\"carNo\":\"藏-AW1111\",\"inTime\":\""+Constants.SATA +"\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\"}]}}";
        //获取验签反查密钥
        String sign= stringmd5(requstjson+Constants.PARKSIG);
        String response= ApiRequst.signapipost(Constants.SIGN_URL,requstjson,sign).asString();
        String signstatus = (Regxvalue.getSubUtilSimple(response, regx));
        int staus = Integer.valueOf(signstatus).intValue();
        Assertion.verifyTrue(staus!=1 , "微信车主验签状态："+staus);
    }

}
