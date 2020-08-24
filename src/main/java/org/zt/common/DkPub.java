package org.zt.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zt.mybatis.controller.OrderController;

@Service
public class DkPub {

    @Autowired
    KafkaTools kf;
    @Autowired
    OrderController c;

    private String channelcarno;
    private String outjson;


    public String channeldk(String DKTOPIC,String channel){

        switch (channel) {
            case "wxisv":
                outjson = Constants.wxoutjson;
                break;
            case "zfbisv":
                outjson = Constants.zfboutjson;
                break;
            default:
                outjson = Constants.otheroutjson;
                break;
        }

        //发送出场数据到kafka
//        kf.produce(DKTOPIC,outjson);
//        try {
//            this.channelcarno = c.dkorder(Constants.ODERID);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return channelcarno;
        return "DK113345666";
    }

}