package org.zt.common;

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

    //验签数据
    private String requstjson;

    public int signnew(String sigchannel) {

        switch (sigchannel) {
            case "wxisv":
                this.requstjson = Constants.wxsigjson;

                break;
            case "zfbisv":
                this.requstjson = Constants.zfbsigjson;
                break;
            default :
                this.requstjson = Constants.sigjson;
                break;
        }

        String sign = stringmd5(requstjson + Constants.PARKSIG);
        String response = re.signapipost(Constants.SIGN_URL, requstjson, sign).asString();
        String signstatus = (Regxvalue.getSubUtilSimple(response, regx));
        int staus = Integer.valueOf(signstatus).intValue();
        return staus;
    }
}
