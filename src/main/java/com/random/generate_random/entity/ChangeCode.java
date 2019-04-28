package com.random.generate_random.entity;

import java.util.Date;

public class ChangeCode {
    private String changeCodeId;

    private String changeCode;

    private String channelCode;

    private Date changeStartTime;

    private Date changeEndTime;

    private Byte changeCodeStatus;

    public ChangeCode() {
    }

    public String getChangeCodeId() {
        return changeCodeId;
    }

    public void setChangeCodeId(String changeCodeId) {
        this.changeCodeId = changeCodeId == null ? null : changeCodeId.trim();
    }

    public String getChangeCode() {
        return changeCode;
    }

    public void setChangeCode(String changeCode) {
        this.changeCode = changeCode == null ? null : changeCode.trim();
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public Date getChangeStartTime() {
        return changeStartTime;
    }

    public void setChangeStartTime(Date changeStartTime) {
        this.changeStartTime = changeStartTime;
    }

    public Date getChangeEndTime() {
        return changeEndTime;
    }

    public void setChangeEndTime(Date changeEndTime) {
        this.changeEndTime = changeEndTime;
    }

    public Byte getChangeCodeStatus() {
        return changeCodeStatus;
    }

    public void setChangeCodeStatus(Byte changeCodeStatus) {
        this.changeCodeStatus = changeCodeStatus;
    }
}