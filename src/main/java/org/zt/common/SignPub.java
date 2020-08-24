package org.zt.common;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.zt.common.MD5.stringmd5;

@Service
public class SignPub {

    @Autowired
    ApiRequst re;

    //验签状态
    String regx = ".*\"isSignatory\":(.+?)";

    //验签结果
    String rgx = ".*\"result\":\"(.+?)\"";

    private static final Logger logger = Logger.getLogger(SignPub.class);

    //验签数据
    private String requstjson;
    private int status;

    public int signnew(String sigchannel) {

        switch (sigchannel) {
            case "wxisv":
                this.requstjson = Constants.wxsigjson;
                break;
            case "zfbisv":
                this.requstjson = Constants.zfbsigjson;
                break;
            default:
                this.requstjson = Constants.sigjson;
                break;
        }

        try {
            String sign = stringmd5(requstjson + Constants.PARKSIG);
            String response = re.signapipost(Constants.SIGN_URL, requstjson, sign).asString();
            logger.debug(response + "------:返回验签结果！");
            String signstatus = (Regxvalue.getSubUtilSimple(response, regx));
            status = Integer.valueOf(signstatus).intValue();

        } catch (Exception e) {
            System.out.println("------车场密钥与车场code不匹配------");
        }
        return status;
    }
}
