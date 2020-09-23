package org.zt.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="cloud")
public class Parameters {

    private String orderurl;
    private String signurl;
    private String syxsignurl;
    private String oldsignurl;
    private String parksign;
    private String dktopic;
    private String orderid;
    private String zfbisv;
    private String wxisv;
    private String otherisv;
    private String redisip;
    private String parkcode;
    private String kafkaip;

    public String getOrderurl() {
        return orderurl;
    }

    public void setOrderurl(String orderurl) {
        this.orderurl = orderurl;
    }

    public String getSignurl() {
        return signurl;
    }

    public void setSignurl(String signurl) {
        this.signurl = signurl;
    }

    public String getSyxsignurl() {
        return syxsignurl;
    }

    public void setSyxsignurl(String syxsignurl) {
        this.syxsignurl = syxsignurl;
    }

    public String getOldsignurl() {
        return oldsignurl;
    }

    public void setOldsignurl(String oldsignurl) {
        this.oldsignurl = oldsignurl;
    }

    public String getParksign() {
        return parksign;
    }

    public void setParksign(String parksign) {
        this.parksign = parksign;
    }

    public String getDktopic() {
        return dktopic;
    }

    public void setDktopic(String dktopic) {
        this.dktopic = dktopic;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getZfbisv() {
        return zfbisv;
    }

    public void setZfbisv(String zfbisv) {
        this.zfbisv = zfbisv;
    }

    public String getWxisv() {
        return wxisv;
    }

    public void setWxisv(String wxisv) {
        this.wxisv = wxisv;
    }

    public String getOtherisv() {
        return otherisv;
    }

    public void setOtherisv(String otherisv) {
        this.otherisv = otherisv;
    }

    public String getRedisip() {
        return redisip;
    }

    public void setRedisip(String redisip) {
        this.redisip = redisip;
    }

    public String getParkcode() {
        return parkcode;
    }

    public void setParkcode(String parkcode) {
        this.parkcode = parkcode;
    }

    public String getKafkaip() {
        return kafkaip;
    }

    public void setKafkaip(String kafkaip) {
        this.kafkaip = kafkaip;
    }
}
