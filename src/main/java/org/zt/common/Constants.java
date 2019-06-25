package org.zt.common;


import static org.zt.common.DataTimes.Dat;
import static org.zt.common.DataTimes.Randoms;

public class Constants {

    //获取项目路径
//    public static final String property = System.getProperty("user.dir");

    // 请求服务url
    public static final String ORDERIP = "10.10.203.19:8081";
    public static final String SIGNIP = "10.10.203.33:8185";
    public static final String OldSIGNIP = "10.10.203.33:8085";
    public static final String ORDER_URL = "http://" + ORDERIP + "/order-api-dispatcher/order/dispatcher";
    public static final String SIGN_URL = "http://" + SIGNIP + "/jscsp-signatory/serviceRequest/signatory";
    public static final String OldSIGN_URL = "http://" + OldSIGNIP + "/jscsp-signatory/signatory.servlet";
    //云订单redisIp
    public static final String redisIP = "10.10.203.12";
    //车场密钥
    public static final String parksig="7c44531ec05af74c1bd8df3975e8011e";

    //sign topic
    public final static String SigTopic = "dc.sign.park.in";

    //dk topic
    public final static String DkTopic = "dc.dk.park.out";

    //获取时间
    public final static String sata=Dat();
    //获取代扣订单入库随机id
    public final static String oderid= Randoms();

}
