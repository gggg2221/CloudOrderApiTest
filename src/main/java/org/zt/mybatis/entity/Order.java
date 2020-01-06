package org.zt.mybatis.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {

    private String id;


    private String ORDER_NO;


    private String parkId;


    private String parkCode;


    private String parkName;


    private String businesserId;


    private String businesserCode;


    private Integer totalFee;


    private Date CREATE_TIME;


    private String status;

    private String type;

    private String payType;

    private String CAR_NO;

    private String channelCode;


    private String channelBusCode;

    public Order() {
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }


    public String getOrderNo() {
        return ORDER_NO;
    }

    public void setOrderNo(String orderno) {
        this.ORDER_NO = orderno == null ? null : orderno.trim();
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId == null ? null : parkId.trim();
    }

    public String getParkCode() {
        return parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode == null ? null : parkCode.trim();
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName == null ? null : parkName.trim();
    }

    public String getBusinesserId() {
        return businesserId;
    }

    public void setBusinesserId(String businesserId) {
        this.businesserId = businesserId == null ? null : businesserId.trim();
    }

    public String getBusinesserCode() {
        return businesserCode;
    }

    public void setBusinesserCode(String businesserCode) {
        this.businesserCode = businesserCode == null ? null : businesserCode.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getCarNo() {
        return CAR_NO;
    }

    public void setCarNo(String carNo) {
        this.CAR_NO = carNo == null ? null : carNo.trim();
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public String getChannelBusCode() {
        return channelBusCode;
    }

    public void setChannelBusCode(String channelBusCode) {
        this.channelBusCode = channelBusCode == null ? null : channelBusCode.trim();
    }

    public Date getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(Date CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }
}