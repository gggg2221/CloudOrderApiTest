package org.zt.common;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zt.mybatis.controller.OrderController;

@Service
public class DkPub {

    @Autowired
    KafkaTools kf;
    @Autowired
    OrderController c;
    @Autowired
    Parameters pt;

    private static final Logger logger = Logger.getLogger(SignPub.class);

    private String channelcarno;
    private String outjson;
    private String outtime= MyUntils.outtime();

    public String channeldk(String DKTOPIC,String channel){

        switch (channel) {
            case "wxisv":
                outjson = "{\"isReal\":0,\"parkName\":\"梅test\",\"ysMoney\":0.01,\"yhMoney\":0.00,\"inEquipName\":\"车场入口\",\"outMode\":\"NORMAL\",\"outOperator\":\"Admin\",\"outEquipCode\":\"2\",\"ssMoney\":0.01" +
                        ",\"freeMoney\":0,\"dkTag\":1,\"orderNo\":\"\",\"outCarPhoto\":\"2018113019/NISSP_IMG_PARK_OUT/20181112/1\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\",\"overTimeFlag\":0,\"idno\":\"01181016100552\",\"inRecordId\":\"" + pt.getOrderid() + "\",\"payTypeName\":\"线上代扣\",\"carNumber\":\""+pt.getWxisv()+"\",\"inTime\":\"" + MyUntils.intime +"\",\"itemId\":\"" + MyUntils.randoms() + "\",\"outEquipName\":\"车场出口\",\"inEquipCode\":\"6\",\"parkCode\":\""+pt.getParkcode()+"\",\"hgMoney\":0.0,\"outTime\":\"" + outtime + "\"}";
                break;
            case "zfbisv":
                outjson = "{\"isReal\":0,\"parkName\":\"梅test\",\"ysMoney\":0.01,\"yhMoney\":0.00,\"inEquipName\":\"车场入口\",\"outMode\":\"NORMAL\",\"outOperator\":\"Admin\",\"outEquipCode\":\"2\",\"ssMoney\":0.01" +
                        ",\"freeMoney\":0,\"dkTag\":1,\"orderNo\":\"\",\"outCarPhoto\":\"2018113019/NISSP_IMG_PARK_OUT/20181112/1\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\",\"overTimeFlag\":0,\"idno\":\"01181016100552\",\"inRecordId\":\"" + pt.getOrderid() + "\",\"payTypeName\":\"线上代扣\",\"carNumber\":\""+pt.getZfbisv()+"\",\"inTime\":\"" + MyUntils.intime +"\",\"itemId\":\"" + MyUntils.randoms() + "\",\"outEquipName\":\"车场出口\",\"inEquipCode\":\"6\",\"parkCode\":\""+pt.getParkcode()+"\",\"hgMoney\":0.0,\"outTime\":\"" + outtime + "\"}";
                break;
            default:
                outjson = "{\"isReal\":0,\"parkName\":\"梅test\",\"ysMoney\":0.01,\"yhMoney\":0.00,\"inEquipName\":\"车场入口\",\"outMode\":\"NORMAL\",\"outOperator\":\"Admin\",\"outEquipCode\":\"2\",\"ssMoney\":0.01" +
                        ",\"freeMoney\":0,\"dkTag\":1,\"orderNo\":\"\",\"outCarPhoto\":\"2018113019/NISSP_IMG_PARK_OUT/20181112/1\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\",\"overTimeFlag\":0,\"idno\":\"01181016100552\",\"inRecordId\":\"" + pt.getOrderid() + "\",\"payTypeName\":\"线上代扣\",\"carNumber\":\""+pt.getOtherisv()+"\",\"inTime\":\"" + MyUntils.intime +"\",\"itemId\":\"" + MyUntils.randoms() + "\",\"outEquipName\":\"车场出口\",\"inEquipCode\":\"6\",\"parkCode\":\""+pt.getParkcode()+"\",\"hgMoney\":0.0,\"outTime\":\"" + outtime + "\"}";
                break;
        }

        //发送出场数据到kafka
        kf.produce(DKTOPIC,outjson);
        try {
            logger.debug(MyUntils.intime + ":【入场时间！】");
            logger.debug(outtime + ":【出场时间！】");
            logger.debug(pt.getOrderid() + ":【orderid！】");
            logger.debug(MyUntils.randoms() + ":【itemid！】");
            this.channelcarno = c.dkorder(pt.getOrderid());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return channelcarno;
    }

}