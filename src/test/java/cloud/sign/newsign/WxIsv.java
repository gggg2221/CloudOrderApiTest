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
public class WxIsv extends AbstractTestNGSpringContextTests {

    //验签状态
    String regx=".*\"isSignatory\":(.+?)";

    @Test(description = "微信车主平台验签及验签反查")
    public void wxisv(){
        String requstjson ="{\"serviceId\":\"fc.park.signatoryResult.OrderQuery\",\"data\":{\"parkCode\":\"20181213001\",\"dataItems\":[{\"carNo\":\"藏-WW1111\",\"inTime\":\""+Constants.sata+"\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\"}]}}";
        //获取验签反查密钥
        String sign=StringMD5(requstjson+Constants.parksig);
        String response= ApiRequst.SignApiPost(Constants.SIGN_URL,requstjson,sign).asString();
        String signstatus = (Regxvalue.getSubUtilSimple(response, regx));
        int staus = Integer.valueOf(signstatus).intValue();
        Assertion.verifyTrue(staus==1 , "微信车主验签状态："+staus);
    }

    @Test(description = "微信车主签名失败")
    public void wxsignerror(){
        String requstjson ="{\"serviceId\":\"fc.park.signatoryResult.OrderQuery\",\"data\":{\"parkCode\":\"20181213001\",\"dataItems\":[{\"carNo\":\"藏-WW1111\",\"inTime\":\""+Constants.sata+"\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\"}]}}";
        //获取验签反查密钥
        String sign="dfdsf435435345gdfgd";
        String response= ApiRequst.SignApiPost(Constants.SIGN_URL,requstjson,sign).asString();
        String rgx=".*\"result\":\"(.+?)\"";
        String signstatus = (Regxvalue.getSubUtilSimple(response, rgx));
        Assertion.verifyTrue(signstatus.equals("1"), "微信车主验签返回："+response);
    }

    @Test(description = "未开通微信车主代扣")
    public void wxclose(){
        String requstjson ="{\"serviceId\":\"fc.park.signatoryResult.OrderQuery\",\"data\":{\"parkCode\":\"20181213001\",\"dataItems\":[{\"carNo\":\"藏-AW1111\",\"inTime\":\""+Constants.sata+"\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\"}]}}";
        //获取验签反查密钥
        String sign=StringMD5(requstjson+Constants.parksig);
        String response= ApiRequst.SignApiPost(Constants.SIGN_URL,requstjson,sign).asString();
        String signstatus = (Regxvalue.getSubUtilSimple(response, regx));
        int staus = Integer.valueOf(signstatus).intValue();
        Assertion.verifyTrue(staus!=1 , "微信车主验签状态："+staus);
    }

}
