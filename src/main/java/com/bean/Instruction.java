package com.bean;

import java.util.Date;
import javax.persistence.*;

public class Instruction {
    /**
     * 宣教表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 设备mac地址
     */
    @Column(name = "device_mac")
    private String deviceMac;

    /**
     * 宣(wen)教(jian)类型,
     */
    private Integer type;

    /**
     * 宣(wen)教(jian)主题
     */
    private String title;

    /**
     * 宣(wen)教(jian)地址
     */
    private String value;

    /**
     * 医院id
     */
    @Column(name = "corp_id")
    private String corpId;

    /**
     * 滚动的时间间隔(秒)
     */
    @Column(name = "gap_time")
    private Integer gapTime;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modify")
    private Date gmtModify;

    /**
     * 是否上下线,1在线，2下线
     */
    private Integer status;

    /**
     * 获取宣教表
     *
     * @return id - 宣教表
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置宣教表
     *
     * @param id 宣教表
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取设备mac地址
     *
     * @return device_mac - 设备mac地址
     */
    public String getDeviceMac() {
        return deviceMac;
    }

    /**
     * 设置设备mac地址
     *
     * @param deviceMac 设备mac地址
     */
    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    /**
     * 获取宣(wen)教(jian)类型,
     *
     * @return type - 宣(wen)教(jian)类型,
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置宣(wen)教(jian)类型,
     *
     * @param type 宣(wen)教(jian)类型,
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取宣(wen)教(jian)主题
     *
     * @return title - 宣(wen)教(jian)主题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置宣(wen)教(jian)主题
     *
     * @param title 宣(wen)教(jian)主题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取宣(wen)教(jian)地址
     *
     * @return value - 宣(wen)教(jian)地址
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置宣(wen)教(jian)地址
     *
     * @param value 宣(wen)教(jian)地址
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取医院id
     *
     * @return corp_id - 医院id
     */
    public String getCorpId() {
        return corpId;
    }

    /**
     * 设置医院id
     *
     * @param corpId 医院id
     */
    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    /**
     * 获取滚动的时间间隔(秒)
     *
     * @return gap_time - 滚动的时间间隔(秒)
     */
    public Integer getGapTime() {
        return gapTime;
    }

    /**
     * 设置滚动的时间间隔(秒)
     *
     * @param gapTime 滚动的时间间隔(秒)
     */
    public void setGapTime(Integer gapTime) {
        this.gapTime = gapTime;
    }

    /**
     * @return gmt_create
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * @param gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * @return gmt_modify
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * @param gmtModify
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * 获取是否上下线,1在线，2下线
     *
     * @return status - 是否上下线,1在线，2下线
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置是否上下线,1在线，2下线
     *
     * @param status 是否上下线,1在线，2下线
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}