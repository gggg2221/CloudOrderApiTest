//package OrderZdf;
//
//import java.io.IOException;
//
//import org.testng.Reporter;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//
//import Assertion;
//import Constants;
//import Regxvalue;
//import Soucecsv;
//
//@Listeners({ AssertionListener.class })
//
//public class smTest {
//
//	String rgex = ".*\"orderNo\":\"(.+?)\"";
//	public static String smo = "";// 生成的订单编号
//
//	@Test(priority = 0, enabled = true)
//	public void smorder() throws IOException {
//		String requstjson = Soucecsv.read(1, 1, "smorder");
//		try {
//			Thread.sleep(3000);
//			// 获取请求返回数据
//			String s1 = ReHttpclient.doPost(Constants.COM_URL, requstjson);
//			// 获取订单号
//			String smo = Regxvalue.getSubUtilSimple(s1, rgex);
//			if (smo == "") {
//				Reporter.log("generate Order is fail lll 失败");
//				Assertion.verifyTrue(smo != "", "扫码生成订单");
//			} else {
//				Assertion.verifyTrue(smo != "", "扫码生成订单:" + smo);
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//	}
//
////	@Test(priority = 1, enabled = true, dependsOnMethods = "smorder")
//	// 支付宝预支付
//	public void zfbprepay() throws IOException {
//		String Order = smo;
//		String zfbjson = "{\"attributes\": {\"appType\":\"APP_JSCARLIFE\",\"channelId\": \"ZFB\",\"orderNo\": \""
//				+ Order + "\"},\"serviceId\": \"ac.pay.prepay\"}";
//		String s3 = ReHttpclient.doPost(Constants.COM_URL, zfbjson);
//		Assertion.verifyTrue(s3.indexOf("成功") != -1, "创建支付宝车牌预支付订单");
//
//	}
//
//}
