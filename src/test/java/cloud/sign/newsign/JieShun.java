package cloud.sign.newsign;

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
public class JieShun extends AbstractTestNGSpringContextTests {

    //验签状态
    String regx=".*\"isSignatory\":(.+?)";
    //redis成功验签数据
    String scuusign="JSCSP:SIGN:CARSIGNRECORD:CODE.INFO:藏-JK11111";
    //redis失败验签数据
    String failsign="JSCSP:SIGN:CARSIGNRECORD_FAIL:CODE.INFO:藏-CK1111";

    @Autowired
    RedisTools redis;

    @Autowired
    ApiRequst re;

    @Test(description = "捷顺验签及验签反查")
    public void jieshun(){
        String requstjson ="{\"serviceId\":\"fc.park.signatoryResult.OrderQuery\",\"data\":{\"parkCode\":\"20181213001\",\"dataItems\":[{\"carNo\":\"藏-JK2222\",\"inTime\":\""+ Constants.SATA +"\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\"}]}}";
        String sign= stringmd5(requstjson+Constants.PARKSIG);
        String response= re.signapipost(Constants.SIGN_URL,requstjson,sign).asString();
        String signstatus = (Regxvalue.getSubUtilSimple(response, regx));
        int staus = Integer.valueOf(signstatus).intValue();
        Assertion.verifyTrue(staus==1 , "捷顺验签状态："+staus);
    }

    @Test(description = "捷顺验签签名失败")
    public void jssigerror(){
        String requstjson ="{\"serviceId\":\"fc.park.signatoryResult.OrderQuery\",\"data\":{\"parkCode\":\"20181213001\",\"dataItems\":[{\"carNo\":\"藏-JK1111\",\"inTime\":\""+Constants.SATA +"\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"GREEN\\\"}\"}]}}";
        String sign="pooiikjjkiioi1111";
        String response= re.signapipost(Constants.SIGN_URL,requstjson,sign).asString();
        String rgx=".*\"result\":\"(.+?)\"";
        String signstatus = (Regxvalue.getSubUtilSimple(response, rgx));
        Assertion.verifyTrue(signstatus.equals("1"), "捷顺验签返回："+response);
    }

    @Test(description = "未开通捷顺代扣")
    public void jsclose(){
        String requstjson ="{\"serviceId\":\"fc.park.signatoryResult.OrderQuery\",\"data\":{\"parkCode\":\"20181213001\",\"dataItems\":[{\"carNo\":\"藏-CK1111\",\"inTime\":\""+Constants.SATA +"\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\"}]}}";
        String sign= stringmd5(requstjson+Constants.PARKSIG);
        String response= re.signapipost(Constants.SIGN_URL,requstjson,sign).asString();
        String signstatus = (Regxvalue.getSubUtilSimple(response, regx));
        int staus = Integer.valueOf(signstatus).intValue();
        Assertion.verifyTrue(staus!=1 , "捷顺验签状态："+staus);
    }

    @Test(description = "反查超过一天的验签记录")
    public void sigyesterday() throws SQLException {
        String signatoryCode=".*\"signatoryCode\":(1021)";
        String requstjson =MysqlJdbc.postdata("cloudtestdata","signnew","jieshun","");
        String sign= stringmd5(requstjson+Constants.PARKSIG);
        String response= re.signapipost(Constants.SIGN_URL,requstjson,sign).asString();
        String signCode = (Regxvalue.getSubUtilSimple(response, signatoryCode));
        int staus = Integer.valueOf(signCode).intValue();
        Assertion.verifyTrue(staus==1021 , "捷顺验签状态："+staus);
    }

    //缓存中检索验签成功结果
    @Test(dependsOnMethods = "jieshun",description = "缓存中检索验签成功结果")
    public void redisscusig() {
        String source= redis.reddata("",scuusign);
        if(!source.equals("")){
            Assertion.verifyTrue(true, "");
        }
        else {
            Assertion.verifyFalse(true, "没有写入redis:"+source);
        }
    }
    //缓存中检索验签失败结果
    @Test(dependsOnMethods = "jsclose",description = "缓存中检索验签失败结果")
    public void redisfail() {
        String source= redis.reddata("",failsign);
        if(!source.equals("")){
            Assertion.verifyTrue(true, "");
        }
        else {
            Assertion.verifyFalse(true, "没有写入redis:"+source);
        }
    }
}



//    @DataProvider(name="sendkafak")
//    public Object[][] signdata() throws Exception{
//        String path= con.Signdatas;
//        String sheetname="SignNew";
//        Object signtest[][]= ExcelUtils.getTableArray(path,sheetname);
//        return signtest;
//    }
//
//    @Test(dataProvider = "sendkafak",enabled = false)
//    public void signkafka(String classname,String requestbody) throws Exception{
//        String json=requestbody;
//        String cname=classname;
//        KafkaTools kf = new KafkaTools();
//
//        switch(cname){
//            case "wxisv":
//                kf.produce(json);
//                kf.produceclose();
//                break;
//        }
//        Thread.sleep(5000);
//    }



