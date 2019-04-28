package com.random.generate_random.entity;

import java.util.Date;

public class VerificationCodePool {
    private Long id;

    private Long customerId;

    private String code;

    private String mobile;

    private Integer bizType;

    private Integer status;

    private Long checkUser;

    private Date verificationTime;

    private Long clinicId;

    private Long tenantId;

    private Date receiveTime;

    public VerificationCodePool() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(Long checkUser) {
        this.checkUser = checkUser;
    }

    public Date getVerificationTime() {
        return verificationTime;
    }

    public void setVerificationTime(Date verificationTime) {
        this.verificationTime = verificationTime;
    }

    public Long getClinicId() {
        return clinicId;
    }

    public void setClinicId(Long clinicId) {
        this.clinicId = clinicId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }
}