package com.random.generate_random.entity;

public class CardCode {
    private Integer id;

    private Integer weid;

    private Integer cardid;

    private String code;

    private Integer status;

    private String createtime;

    public CardCode() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWeid() {
        return weid;
    }

    public void setWeid(Integer weid) {
        this.weid = weid;
    }

    public Integer getCardid() {
        return cardid;
    }

    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    @Override
    public String toString() {
        return "CardCode{" +
                "id=" + id +
                ", weid=" + weid +
                ", cardid=" + cardid +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}