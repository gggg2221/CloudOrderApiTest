package org.zt.common;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.zt.common.MD5.stringmd5;

@Service
public class SignPub {

    @Autowired
    ApiRequst re;

    @Autowired
    Parameters pt;

    //验签状态
    String regx = ".*\"isSignatory\":(.+?)";

    private static final Logger logger = Logger.getLogger(SignPub.class);

    //验签数据
    private String requstjson;
    private int status;
    private String intime= MyUntils.intime;

    public int signnew(String sigchannel) {

        switch (sigchannel) {
            case "wxisv":
                this.requstjson = "{\"serviceId\":\"fc.park.signatoryResult.OrderQuery\",\"data\":{\"parkCode\":\""+pt.getParkcode()+"\",\"dataItems\":[{\"carNo\":\""+ pt.getWxisv() +"\",\"inTime\":\""+ intime +"\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\"}]}}";
                break;
            case "zfbisv":
                this.requstjson = "{\"serviceId\":\"fc.park.signatoryResult.OrderQuery\",\"data\":{\"parkCode\":\""+pt.getParkcode()+"\",\"dataItems\":[{\"carNo\":\""+ pt.getZfbisv() +"\",\"inTime\":\""+ intime +"\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"BLUE\\\"}\"}]}}";
                break;
            default:
                this.requstjson = "{\"serviceId\":\"fc.park.signatoryResult.OrderQuery\",\"data\":{\"parkCode\":\""+pt.getParkcode()+"\",\"dataItems\":[{\"carNo\":\""+ pt.getOtherisv() +"\",\"inTime\":\""+ intime +"\",\"vehicleInfo\":\"{\\\"plateColor\\\":\\\"YELLOW\\\"}\"}]}}";
                break;
        }

        try {
            String sign = stringmd5(requstjson + pt.getParksign());
            String response = re.signapipost(pt.getSignurl(), requstjson, sign).asString();
            logger.debug(response + ":【返回验签结果！】");
            String signstatus = (Regxvalue.getSubUtilSimple(response, regx));
            status = Integer.valueOf(signstatus).intValue();

        } catch (Exception e) {
            System.out.println("------车场密钥与车场code不匹配------");
        }
        return status;
    }
}
