package org.zt.common;


import static org.zt.common.DataTimes.dat;
import static org.zt.common.DataTimes.randoms;

public class Constants {

    private Constants(){}

    //获取项目路径
//    public static final String property = System.getProperty("user.dir");

    // 请求服务url
    public static final String HTTP="http://";
    public static final String ORDERIP = "10.10.203.19:8081";
    public static final String SIGNIP = "10.10.203.33:8185";
    public static final String OLDSIGNIP = "10.10.203.33:8085";
    public static final String ORDER_URL = HTTP + ORDERIP + "/order-api-dispatcher/order/dispatcher";
    public static final String SIGN_URL = HTTP + SIGNIP + "/jscsp-signatory/serviceRequest/signatory";
    public static final String OLDSIGN_URL = HTTP + OLDSIGNIP + "/jscsp-signatory/signatory.servlet";
    //云订单redisIp
    public static final String REDISIP = "10.10.203.12";
    //车场密钥
    public static final String PARKSIG ="7c44531ec05af74c1bd8df3975e8011e";

    //sign topic
//    public static final String SIGNTOPIC = "dc.sign.park.in";

    //dk topic
    public static final String DKTOPIC = "dc.dk.park.out";

    //获取时间
    public static final String SATA = dat();
    //获取代扣订单入库随机id
    public static String ODERID = randoms();

    //支付宝isv车牌：藏-ZFB999
    public static final String ZFBISV="藏-ZFB999";

    //微信isv车牌：藏-MMMMWX,受理机构：藏-ZZ1234
    public static final String WXISV="藏-MMMMWX";

    //捷顺车牌：藏-JK1111
    public static final String JIESHUN="藏-JK1111";

    //车场code
    public static final String PARKCODE="20181213001";

    //微信代扣出场数据
    public static String wxoutjson= "{\"isReal\":0,\"parkName\":\"梅test\",\"ysMoney\":0.01,\"yhMoney\":0.0,\"inEquipName\":\"车场入口\",\"outMode\":\"NORMAL\",\"outOperator\":\"Admin\",\"outEquipCode\":\"2\",\"ssMoney\":0.01,\"freeMoney\":0,\"dkTag\":1,\"orderNo\":\"\",\"outCarPhoto\":\"20181213001/NISSP_IMG_PARK_OUT/20181112/1\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\",\"overTimeFlag\":0,\"idno\":\"01181016100552\",\"inRecordId\":\"" + ODERID + "\",\"payTypeName\":\"线上代扣\",\"carNumber\":\""+WXISV+"\",\"inTime\":\"" + SATA + "\",\"itemId\":\"" + ODERID + "\",\"outEquipName\":\"车场出口\",\"inEquipCode\":\"6\",\"parkCode\":\""+PARKCODE+"\",\"hgMoney\":0.0,\"outTime\":\"" + SATA + "\"}";

    //支付宝代扣出场数据
    public static String zfboutjson= "{\"isReal\":0,\"parkName\":\"梅test\",\"ysMoney\":0.01,\"yhMoney\":0.0,\"inEquipName\":\"车场入口\",\"outMode\":\"NORMAL\",\"outOperator\":\"Admin\",\"outEquipCode\":\"2\",\"ssMoney\":0.01,\"freeMoney\":0,\"dkTag\":1,\"orderNo\":\"\",\"outCarPhoto\":\"20181213001/NISSP_IMG_PARK_OUT/20181112/1\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\",\"overTimeFlag\":0,\"idno\":\"01181016100552\",\"inRecordId\":\"" + ODERID + "\",\"payTypeName\":\"线上代扣\",\"carNumber\":\""+ZFBISV+"\",\"inTime\":\"" + SATA + "\",\"itemId\":\"" + ODERID + "\",\"outEquipName\":\"车场出口\",\"inEquipCode\":\"6\",\"parkCode\":\""+PARKCODE+"\",\"hgMoney\":0.0,\"outTime\":\"" + SATA + "\"}";
}
