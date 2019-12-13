package com.random.generate_random.entity;

import java.util.Date;

//@Table(name = "ma_coupon_code")
public class MaCouponCode {
    /**
     * 主键id
     */
    private String id;

    /**
     * 优惠券code
     */
    private String couponCode;

    /**
     * 优惠券id
     */
    private String couponId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 领取时间
     */
    private Date receiveTime;

    /**
     * 券码状态
     */
    private Integer codeStatus;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 是否已删除(0：未删除  1：已删除)
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;


    public MaCouponCode() {
    }

    public MaCouponCode(String id, String userId, String userPhone, Integer codeStatus, Date receiveTime) {
        this.id = id;
        this.userId = userId;
        this.userPhone = userPhone;
        this.codeStatus = codeStatus;
        this.receiveTime = receiveTime;
    }

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取优惠券code
     *
     * @return coupon_code - 优惠券code
     */
    public String getCouponCode() {
        return couponCode;
    }

    /**
     * 设置优惠券code
     *
     * @param couponCode 优惠券code
     */
    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode == null ? null : couponCode.trim();
    }

    /**
     * 获取优惠券id
     *
     * @return coupon_id - 优惠券id
     */
    public String getCouponId() {
        return couponId;
    }

    /**
     * 设置优惠券id
     *
     * @param couponId 优惠券id
     */
    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取用户手机号
     *
     * @return user_phone - 用户手机号
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置用户手机号
     *
     * @param userPhone 用户手机号
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * 获取领取时间
     *
     * @return receive_time - 领取时间
     */
    public Date getReceiveTime() {
        return receiveTime;
    }

    /**
     * 设置领取时间
     *
     * @param receiveTime 领取时间
     */
    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    /**
     * 获取券码状态
     *
     * @return code_status - 券码状态
     */
    public Integer getCodeStatus() {
        return codeStatus;
    }

    /**
     * 设置券码状态
     *
     * @param codeStatus 券码状态
     */
    public void setCodeStatus(Integer codeStatus) {
        this.codeStatus = codeStatus;
    }

    /**
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", couponCode=").append(couponCode);
        sb.append(", couponId=").append(couponId);
        sb.append(", userId=").append(userId);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", receiveTime=").append(receiveTime);
        sb.append(", codeStatus=").append(codeStatus);
        sb.append(", orderId=").append(orderId);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}