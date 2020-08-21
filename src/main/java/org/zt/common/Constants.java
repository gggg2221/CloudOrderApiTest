package org.zt.common;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Constants {

//    private Constants(){}

    //获取项目路径
//    public static final String property = System.getProperty("user.dir");

    // 请求服务url
    public static String HTTP="http://";
    public static String HTTPS="https://";
    public static String ORDERIP="10.10.203.19:8081";
    public static String SIGNIP="10.10.203.33:8185";
    public static String OLDSIGNIP = "10.10.203.33:8085";
    public static String SYXSIGNIP="syx.jslife.com.cn";
    public static String ORDER_URL = HTTP + ORDERIP + "/order-api-dispatcher/order/dispatcher";
    public static String SIGN_URL = HTTP + SIGNIP + "/jscsp-signatory/serviceRequest/signatory";
    public static String SYXSIGN_URL = HTTP + SYXSIGNIP + "/jscsp-sign/serviceRequest/signatory";
    public static String OLDSIGN_URL = HTTP + OLDSIGNIP + "/jscsp-signatory/signatory.servlet";
    //云订单redisIp
    public static String REDISIP = "10.10.203.12";
    //车场密钥
    public static String PARKSIG ="a413a0614997409cba4e109320d41b5c";
    //syx车场
//    public static String PARKSIG ="ea4145b3d2960a4fb53bd1c11cb92977";
    //世梁车场密钥
//    public static String PARKSIG ="b4a2b0ee3e3e274542baea7f0dcec399";

    //sign topic
//    public static final String SIGNTOPIC = "dc.sign.park.in";

    //dk topic
    public static String DKTOPIC = "dc.dk.park.out";

    //获取时间
    public static final String SATA = DataTimes.dat();
    //加转译符号
    public static String creattimes=" \"" + SATA + "\" ";

    //获取代扣订单入库随机id
    public static String ODERID = DataTimes.randoms();

    //支付宝isv车牌：藏-ZFB999
    public static String ZFBISV="藏-ZFB999";

    //微信isv车牌：藏-MMMMWX,受理机构：藏-ZZ1234 藏-CS1111
    public static String WXISV="藏-CS1111";

//    public static String wxcar=" \""+"藏-CS1111"+"\" ";
    public static String wxcar="藏-Z12345";

    //捷顺车牌：藏-JK1111
    public static String JIESHUN="藏-JK2222";

    /**其他渠道车：深圳银联：藏-D12345 福州城市大脑：闽-A66666 招商车主平台 蒙-BJS000 东莞通：粤-SR1111 天府通：川-Q11111
    小桔租车:藏-ZJSGGG1 GREEN 建行isv：藏-K78789
     **/
    public static String othercarno="藏-K78789";

    //车场code 20181213001 2019120311
    public static String PARKCODE="20181213001";

    //微信验签反查json
    public static String wxsigjson="{\"serviceId\":\"fc.park.signatoryResult.OrderQuery\",\"data\":{\"parkCode\":\""+PARKCODE+"\",\"dataItems\":[{\"carNo\":\""+ WXISV +"\",\"inTime\":\""+ SATA +"\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\"}]}}";

    //支付宝验签反查
    public static String zfbsigjson="{\"serviceId\":\"fc.park.signatoryResult.OrderQuery\",\"data\":{\"parkCode\":\"20181213001\",\"dataItems\":[{\"carNo\":\""+ ZFBISV +"\",\"inTime\":\""+ SATA +"\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\"}]}}";

    //其他渠道验签反查
    public static String sigjson="{\"serviceId\":\"fc.park.signatoryResult.OrderQuery\",\"data\":{\"parkCode\":\"20181213001\",\"dataItems\":[{\"carNo\":\""+ othercarno +"\",\"inTime\":\""+ SATA +"\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\"}]}}";

    //微信代扣出场数据
    public static String wxoutjson= "{\"isReal\":0,\"parkName\":\"梅test\",\"ysMoney\":0.01,\"yhMoney\":0.00,\"inEquipName\":\"车场入口\",\"outMode\":\"NORMAL\",\"outOperator\":\"Admin\",\"outEquipCode\":\"2\",\"ssMoney\":0.01" +
            ",\"freeMoney\":0,\"dkTag\":1,\"orderNo\":\"\",\"outCarPhoto\":\"2018113019/NISSP_IMG_PARK_OUT/20181112/1\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\",\"overTimeFlag\":0,\"idno\":\"01181016100552\",\"inRecordId\":\"" + ODERID + "\",\"payTypeName\":\"线上代扣\",\"carNumber\":\""+WXISV+"\",\"inTime\":\"" + SATA +"\",\"itemId\":\"" + ODERID + "\",\"outEquipName\":\"车场出口\",\"inEquipCode\":\"6\",\"parkCode\":\""+PARKCODE+"\",\"hgMoney\":0.0,\"outTime\":\"" + SATA + "\"}";

    //支付宝代扣出场数据
    public static String zfboutjson= "{\"isReal\":0,\"parkName\":\"梅test\",\"ysMoney\":0.01,\"yhMoney\":0.0,\"inEquipName\":\"车场入口\",\"outMode\":\"NORMAL\",\"outOperator\":\"Admin\",\"outEquipCode\":\"2\",\"ssMoney\":0.01,\"freeMoney\":0,\"dkTag\":1,\"orderNo\":\"\",\"outCarPhoto\":\"20181213001/NISSP_IMG_PARK_OUT/20181112/1\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\",\"overTimeFlag\":0,\"idno\":\"01181016100552\",\"inRecordId\":\"" + ODERID + "\",\"payTypeName\":\"线上代扣\",\"carNumber\":\""+ZFBISV+"\",\"inTime\":\"" + SATA + "\",\"itemId\":\"" + ODERID + "\",\"outEquipName\":\"车场出口\",\"inEquipCode\":\"6\",\"parkCode\":\""+PARKCODE+"\",\"hgMoney\":0.0,\"outTime\":\"" + SATA + "\"}";

    //其他渠道代扣出场数据
    public static String otheroutjson= "{\"isReal\":0,\"parkName\":\"梅test\",\"ysMoney\":0.01,\"yhMoney\":0.0,\"inEquipName\":\"车场入口\",\"outMode\":\"NORMAL\",\"outOperator\":\"Admin\",\"outEquipCode\":\"2\",\"ssMoney\":0.01,\"freeMoney\":0,\"dkTag\":1,\"orderNo\":\"\",\"outCarPhoto\":\"20181213001/NISSP_IMG_PARK_OUT/20181112/1\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\",\"overTimeFlag\":0,\"idno\":\"01181016100552\",\"inRecordId\":\"" + ODERID + "\",\"payTypeName\":\"线上代扣\",\"carNumber\":\""+othercarno+"\",\"inTime\":\"" + SATA + "\",\"itemId\":\"" + ODERID + "\",\"outEquipName\":\"车场出口\",\"inEquipCode\":\"6\",\"parkCode\":\""+PARKCODE+"\",\"hgMoney\":0.0,\"outTime\":\"" + SATA + "\"}";
//    public static String otheroutjson= "{\"isReal\":0,\"parkName\":\"梅test\",\"ysMoney\":0.01,\"yhMoney\":0.0,\"inEquipName\":\"车场入口\",\"outMode\":\"NORMAL\",\"outOperator\":\"Admin\",\"outEquipCode\":\"2\",\"ssMoney\":0.01,\"freeMoney\":0,\"dkTag\":1,\"orderNo\":\"\",\"outCarPhoto\":\"20181213001/NISSP_IMG_PARK_OUT/20181112/1\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\",\"overTimeFlag\":0,\"idno\":\"01181016100552\",\"inRecordId\":\"" + ODERID + "\",\"payTypeName\":\"线上代扣\",\"carNumber\":\""+othercarno+"\",\"inTime\":\"2020-07-14 15:09:20\",\"itemId\":\"" + ODERID + "\",\"outEquipName\":\"车场出口\",\"inEquipCode\":\"6\",\"parkCode\":\""+PARKCODE+"\",\"hgMoney\":0.0,\"outTime\":\"" + SATA + "\"}";
}

