package org.zt.mybatis.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {

    private String id;


    private String ORDER_NO;

    private String userId;

    private String parkId;


    private String parkCode;


    private String parkName;


    private String businesserId;


    private String businesserCode;


    private String gcodeId;


    private String goodsTitle;


    private String merGid;


    private Date serviceStime;


    private Date serviceEtime;


    private Integer serviceFeeTime;


    private Integer curType;


    private Integer serviceFee;


    private Integer deductFee;


    private Integer discountFee;


    private Integer transportFee;


    private Integer otherFee;


    private Integer totalFee;


    private Date CREATE_TIME;


    private String goparkDesc;


    private String notifyUrl;


    private String subsystemUrl;


    private String remark;

    private Integer retcode;


    private String retmsg;


    private String attach;


    private String status;


    private String type;


    private Integer isShow;


    private Date receiptReceiveTime;


    private String receiptAddr;


    private String accessToken;


    private Date tokenTime;


    private String receiptOperator;


    private String accessSource;


    private String payType;


    private Integer isGetReceipt;


    private Integer isUpload;


    private Date uploadTime;


    private Integer isOutPark;


    private String couponType;


    private String couponValue;


    private Integer isStat;


    private String carNo;


    private String plateColor;


    private Date refundTime;


    private Date syncTime;


    private String preferentialMode;


    private String couponThrNo;


    private Integer couponThrType;


    private String memberNo;


    private BigDecimal deduction;


    private Integer isValid;


    private String inId;


    private Date prepayTime;


    private String channelCode;


    private String channelBusCode;


    private Date timeEnd;


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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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

    public String getGcodeId() {
        return gcodeId;
    }

    public void setGcodeId(String gcodeId) {
        this.gcodeId = gcodeId == null ? null : gcodeId.trim();
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle == null ? null : goodsTitle.trim();
    }

    public String getMerGid() {
        return merGid;
    }

    public void setMerGid(String merGid) {
        this.merGid = merGid == null ? null : merGid.trim();
    }

    public Date getServiceStime() {
        return serviceStime;
    }

    public void setServiceStime(Date serviceStime) {
        this.serviceStime = serviceStime;
    }

    public Date getServiceEtime() {
        return serviceEtime;
    }

    public void setServiceEtime(Date serviceEtime) {
        this.serviceEtime = serviceEtime;
    }

    public Integer getServiceFeeTime() {
        return serviceFeeTime;
    }

    public void setServiceFeeTime(Integer serviceFeeTime) {
        this.serviceFeeTime = serviceFeeTime;
    }

    public Integer getCurType() {
        return curType;
    }

    public void setCurType(Integer curType) {
        this.curType = curType;
    }

    public Integer getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Integer serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Integer getDeductFee() {
        return deductFee;
    }

    public void setDeductFee(Integer deductFee) {
        this.deductFee = deductFee;
    }

    public Integer getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(Integer discountFee) {
        this.discountFee = discountFee;
    }

    public Integer getTransportFee() {
        return transportFee;
    }

    public void setTransportFee(Integer transportFee) {
        this.transportFee = transportFee;
    }

    public Integer getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(Integer otherFee) {
        this.otherFee = otherFee;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Date getCreateTime() {
        return CREATE_TIME;
    }

    public void setCreateTime(Date createTime) {
        this.CREATE_TIME = createTime;
    }

    public String getGoparkDesc() {
        return goparkDesc;
    }

    public void setGoparkDesc(String goparkDesc) {
        this.goparkDesc = goparkDesc == null ? null : goparkDesc.trim();
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    public String getSubsystemUrl() {
        return subsystemUrl;
    }

    public void setSubsystemUrl(String subsystemUrl) {
        this.subsystemUrl = subsystemUrl == null ? null : subsystemUrl.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getRetcode() {
        return retcode;
    }

    public void setRetcode(Integer retcode) {
        this.retcode = retcode;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg == null ? null : retmsg.trim();
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach == null ? null : attach.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.STATUS
     *
     * @return the value of cs_biz_order.STATUS
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.STATUS
     *
     * @param status the value for cs_biz_order.STATUS
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.TYPE
     *
     * @return the value of cs_biz_order.TYPE
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.TYPE
     *
     * @param type the value for cs_biz_order.TYPE
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.IS_SHOW
     *
     * @return the value of cs_biz_order.IS_SHOW
     *
     * @mbggenerated
     */
    public Integer getIsShow() {
        return isShow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.IS_SHOW
     *
     * @param isShow the value for cs_biz_order.IS_SHOW
     *
     * @mbggenerated
     */
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.RECEIPT_RECEIVE_TIME
     *
     * @return the value of cs_biz_order.RECEIPT_RECEIVE_TIME
     *
     * @mbggenerated
     */
    public Date getReceiptReceiveTime() {
        return receiptReceiveTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.RECEIPT_RECEIVE_TIME
     *
     * @param receiptReceiveTime the value for cs_biz_order.RECEIPT_RECEIVE_TIME
     *
     * @mbggenerated
     */
    public void setReceiptReceiveTime(Date receiptReceiveTime) {
        this.receiptReceiveTime = receiptReceiveTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.RECEIPT_ADDR
     *
     * @return the value of cs_biz_order.RECEIPT_ADDR
     *
     * @mbggenerated
     */
    public String getReceiptAddr() {
        return receiptAddr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.RECEIPT_ADDR
     *
     * @param receiptAddr the value for cs_biz_order.RECEIPT_ADDR
     *
     * @mbggenerated
     */
    public void setReceiptAddr(String receiptAddr) {
        this.receiptAddr = receiptAddr == null ? null : receiptAddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.ACCESS_TOKEN
     *
     * @return the value of cs_biz_order.ACCESS_TOKEN
     *
     * @mbggenerated
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.ACCESS_TOKEN
     *
     * @param accessToken the value for cs_biz_order.ACCESS_TOKEN
     *
     * @mbggenerated
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.TOKEN_TIME
     *
     * @return the value of cs_biz_order.TOKEN_TIME
     *
     * @mbggenerated
     */
    public Date getTokenTime() {
        return tokenTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.TOKEN_TIME
     *
     * @param tokenTime the value for cs_biz_order.TOKEN_TIME
     *
     * @mbggenerated
     */
    public void setTokenTime(Date tokenTime) {
        this.tokenTime = tokenTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.RECEIPT_OPERATOR
     *
     * @return the value of cs_biz_order.RECEIPT_OPERATOR
     *
     * @mbggenerated
     */
    public String getReceiptOperator() {
        return receiptOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.RECEIPT_OPERATOR
     *
     * @param receiptOperator the value for cs_biz_order.RECEIPT_OPERATOR
     *
     * @mbggenerated
     */
    public void setReceiptOperator(String receiptOperator) {
        this.receiptOperator = receiptOperator == null ? null : receiptOperator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.ACCESS_SOURCE
     *
     * @return the value of cs_biz_order.ACCESS_SOURCE
     *
     * @mbggenerated
     */
    public String getAccessSource() {
        return accessSource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.ACCESS_SOURCE
     *
     * @param accessSource the value for cs_biz_order.ACCESS_SOURCE
     *
     * @mbggenerated
     */
    public void setAccessSource(String accessSource) {
        this.accessSource = accessSource == null ? null : accessSource.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.PAY_TYPE
     *
     * @return the value of cs_biz_order.PAY_TYPE
     *
     * @mbggenerated
     */
    public String getPayType() {
        return payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.PAY_TYPE
     *
     * @param payType the value for cs_biz_order.PAY_TYPE
     *
     * @mbggenerated
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.IS_GET_RECEIPT
     *
     * @return the value of cs_biz_order.IS_GET_RECEIPT
     *
     * @mbggenerated
     */
    public Integer getIsGetReceipt() {
        return isGetReceipt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.IS_GET_RECEIPT
     *
     * @param isGetReceipt the value for cs_biz_order.IS_GET_RECEIPT
     *
     * @mbggenerated
     */
    public void setIsGetReceipt(Integer isGetReceipt) {
        this.isGetReceipt = isGetReceipt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.IS_UPLOAD
     *
     * @return the value of cs_biz_order.IS_UPLOAD
     *
     * @mbggenerated
     */
    public Integer getIsUpload() {
        return isUpload;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.IS_UPLOAD
     *
     * @param isUpload the value for cs_biz_order.IS_UPLOAD
     *
     * @mbggenerated
     */
    public void setIsUpload(Integer isUpload) {
        this.isUpload = isUpload;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.UPLOAD_TIME
     *
     * @return the value of cs_biz_order.UPLOAD_TIME
     *
     * @mbggenerated
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.UPLOAD_TIME
     *
     * @param uploadTime the value for cs_biz_order.UPLOAD_TIME
     *
     * @mbggenerated
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.IS_OUT_PARK
     *
     * @return the value of cs_biz_order.IS_OUT_PARK
     *
     * @mbggenerated
     */
    public Integer getIsOutPark() {
        return isOutPark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.IS_OUT_PARK
     *
     * @param isOutPark the value for cs_biz_order.IS_OUT_PARK
     *
     * @mbggenerated
     */
    public void setIsOutPark(Integer isOutPark) {
        this.isOutPark = isOutPark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.COUPON_TYPE
     *
     * @return the value of cs_biz_order.COUPON_TYPE
     *
     * @mbggenerated
     */
    public String getCouponType() {
        return couponType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.COUPON_TYPE
     *
     * @param couponType the value for cs_biz_order.COUPON_TYPE
     *
     * @mbggenerated
     */
    public void setCouponType(String couponType) {
        this.couponType = couponType == null ? null : couponType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.COUPON_VALUE
     *
     * @return the value of cs_biz_order.COUPON_VALUE
     *
     * @mbggenerated
     */
    public String getCouponValue() {
        return couponValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.COUPON_VALUE
     *
     * @param couponValue the value for cs_biz_order.COUPON_VALUE
     *
     * @mbggenerated
     */
    public void setCouponValue(String couponValue) {
        this.couponValue = couponValue == null ? null : couponValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.IS_STAT
     *
     * @return the value of cs_biz_order.IS_STAT
     *
     * @mbggenerated
     */
    public Integer getIsStat() {
        return isStat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.IS_STAT
     *
     * @param isStat the value for cs_biz_order.IS_STAT
     *
     * @mbggenerated
     */
    public void setIsStat(Integer isStat) {
        this.isStat = isStat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.CAR_NO
     *
     * @return the value of cs_biz_order.CAR_NO
     *
     * @mbggenerated
     */
    public String getCarNo() {
        return carNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.CAR_NO
     *
     * @param carNo the value for cs_biz_order.CAR_NO
     *
     * @mbggenerated
     */
    public void setCarNo(String carNo) {
        this.carNo = carNo == null ? null : carNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.PLATE_COLOR
     *
     * @return the value of cs_biz_order.PLATE_COLOR
     *
     * @mbggenerated
     */
    public String getPlateColor() {
        return plateColor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.PLATE_COLOR
     *
     * @param plateColor the value for cs_biz_order.PLATE_COLOR
     *
     * @mbggenerated
     */
    public void setPlateColor(String plateColor) {
        this.plateColor = plateColor == null ? null : plateColor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.REFUND_TIME
     *
     * @return the value of cs_biz_order.REFUND_TIME
     *
     * @mbggenerated
     */
    public Date getRefundTime() {
        return refundTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.REFUND_TIME
     *
     * @param refundTime the value for cs_biz_order.REFUND_TIME
     *
     * @mbggenerated
     */
    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.SYNC_TIME
     *
     * @return the value of cs_biz_order.SYNC_TIME
     *
     * @mbggenerated
     */
    public Date getSyncTime() {
        return syncTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.SYNC_TIME
     *
     * @param syncTime the value for cs_biz_order.SYNC_TIME
     *
     * @mbggenerated
     */
    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.PREFERENTIAL_MODE
     *
     * @return the value of cs_biz_order.PREFERENTIAL_MODE
     *
     * @mbggenerated
     */
    public String getPreferentialMode() {
        return preferentialMode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.PREFERENTIAL_MODE
     *
     * @param preferentialMode the value for cs_biz_order.PREFERENTIAL_MODE
     *
     * @mbggenerated
     */
    public void setPreferentialMode(String preferentialMode) {
        this.preferentialMode = preferentialMode == null ? null : preferentialMode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.COUPON_THR_NO
     *
     * @return the value of cs_biz_order.COUPON_THR_NO
     *
     * @mbggenerated
     */
    public String getCouponThrNo() {
        return couponThrNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.COUPON_THR_NO
     *
     * @param couponThrNo the value for cs_biz_order.COUPON_THR_NO
     *
     * @mbggenerated
     */
    public void setCouponThrNo(String couponThrNo) {
        this.couponThrNo = couponThrNo == null ? null : couponThrNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.COUPON_THR_TYPE
     *
     * @return the value of cs_biz_order.COUPON_THR_TYPE
     *
     * @mbggenerated
     */
    public Integer getCouponThrType() {
        return couponThrType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.COUPON_THR_TYPE
     *
     * @param couponThrType the value for cs_biz_order.COUPON_THR_TYPE
     *
     * @mbggenerated
     */
    public void setCouponThrType(Integer couponThrType) {
        this.couponThrType = couponThrType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.MEMBER_NO
     *
     * @return the value of cs_biz_order.MEMBER_NO
     *
     * @mbggenerated
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.MEMBER_NO
     *
     * @param memberNo the value for cs_biz_order.MEMBER_NO
     *
     * @mbggenerated
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.DEDUCTION
     *
     * @return the value of cs_biz_order.DEDUCTION
     *
     * @mbggenerated
     */
    public BigDecimal getDeduction() {
        return deduction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.DEDUCTION
     *
     * @param deduction the value for cs_biz_order.DEDUCTION
     *
     * @mbggenerated
     */
    public void setDeduction(BigDecimal deduction) {
        this.deduction = deduction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.IS_VALID
     *
     * @return the value of cs_biz_order.IS_VALID
     *
     * @mbggenerated
     */
    public Integer getIsValid() {
        return isValid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.IS_VALID
     *
     * @param isValid the value for cs_biz_order.IS_VALID
     *
     * @mbggenerated
     */
    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.IN_ID
     *
     * @return the value of cs_biz_order.IN_ID
     *
     * @mbggenerated
     */
    public String getInId() {
        return inId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.IN_ID
     *
     * @param inId the value for cs_biz_order.IN_ID
     *
     * @mbggenerated
     */
    public void setInId(String inId) {
        this.inId = inId == null ? null : inId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.PREPAY_TIME
     *
     * @return the value of cs_biz_order.PREPAY_TIME
     *
     * @mbggenerated
     */
    public Date getPrepayTime() {
        return prepayTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.PREPAY_TIME
     *
     * @param prepayTime the value for cs_biz_order.PREPAY_TIME
     *
     * @mbggenerated
     */
    public void setPrepayTime(Date prepayTime) {
        this.prepayTime = prepayTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.CHANNEL_CODE
     *
     * @return the value of cs_biz_order.CHANNEL_CODE
     *
     * @mbggenerated
     */
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.CHANNEL_CODE
     *
     * @param channelCode the value for cs_biz_order.CHANNEL_CODE
     *
     * @mbggenerated
     */
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.CHANNEL_BUS_CODE
     *
     * @return the value of cs_biz_order.CHANNEL_BUS_CODE
     *
     * @mbggenerated
     */
    public String getChannelBusCode() {
        return channelBusCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.CHANNEL_BUS_CODE
     *
     * @param channelBusCode the value for cs_biz_order.CHANNEL_BUS_CODE
     *
     * @mbggenerated
     */
    public void setChannelBusCode(String channelBusCode) {
        this.channelBusCode = channelBusCode == null ? null : channelBusCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_biz_order.time_end
     *
     * @return the value of cs_biz_order.time_end
     *
     * @mbggenerated
     */
    public Date getTimeEnd() {
        return timeEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_biz_order.time_end
     *
     * @param timeEnd the value for cs_biz_order.time_end
     *
     * @mbggenerated
     */
    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }
}