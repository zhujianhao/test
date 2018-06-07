package com.bean;

import java.util.Date;
import javax.persistence.*;

public class Corp {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 组织编号
     */
    @Column(name = "corp_id")
    private String corpId;

    @Column(name = "corp_name")
    private String corpName;

    /**
     * 城市
     */
    private String city;

    /**
     * 省份
     */
    private String province;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modify")
    private Date gmtModify;

    /**
     * 网关机内网IP
     */
    @Column(name = "gateway_ip")
    private String gatewayIp;

    @Column(name = "is_deleted")
    private Byte isDeleted;

    private String description;

    @Column(name = "corp_no")
    private String corpNo;

    @Column(name = "reg_not_sign")
    private Integer regNotSign;

    @Column(name = "sys_reg_time")
    private Integer sysRegTime;

    /**
     * 同步的时候需要科室id
     */
    @Column(name = "docts_by_dept_code")
    private Integer doctsByDeptCode;

    @Column(name = "reflush_rule")
    private String reflushRule;

    @Column(name = "corp_logo")
    private String corpLogo;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取组织编号
     *
     * @return corp_id - 组织编号
     */
    public String getCorpId() {
        return corpId;
    }

    /**
     * 设置组织编号
     *
     * @param corpId 组织编号
     */
    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    /**
     * @return corp_name
     */
    public String getCorpName() {
        return corpName;
    }

    /**
     * @param corpName
     */
    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取省份
     *
     * @return province - 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     *
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province;
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
     * 获取网关机内网IP
     *
     * @return gateway_ip - 网关机内网IP
     */
    public String getGatewayIp() {
        return gatewayIp;
    }

    /**
     * 设置网关机内网IP
     *
     * @param gatewayIp 网关机内网IP
     */
    public void setGatewayIp(String gatewayIp) {
        this.gatewayIp = gatewayIp;
    }

    /**
     * @return is_deleted
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return corp_no
     */
    public String getCorpNo() {
        return corpNo;
    }

    /**
     * @param corpNo
     */
    public void setCorpNo(String corpNo) {
        this.corpNo = corpNo;
    }

    /**
     * @return reg_not_sign
     */
    public Integer getRegNotSign() {
        return regNotSign;
    }

    /**
     * @param regNotSign
     */
    public void setRegNotSign(Integer regNotSign) {
        this.regNotSign = regNotSign;
    }

    /**
     * @return sys_reg_time
     */
    public Integer getSysRegTime() {
        return sysRegTime;
    }

    /**
     * @param sysRegTime
     */
    public void setSysRegTime(Integer sysRegTime) {
        this.sysRegTime = sysRegTime;
    }

    /**
     * 获取同步的时候需要科室id
     *
     * @return docts_by_dept_code - 同步的时候需要科室id
     */
    public Integer getDoctsByDeptCode() {
        return doctsByDeptCode;
    }

    /**
     * 设置同步的时候需要科室id
     *
     * @param doctsByDeptCode 同步的时候需要科室id
     */
    public void setDoctsByDeptCode(Integer doctsByDeptCode) {
        this.doctsByDeptCode = doctsByDeptCode;
    }

    /**
     * @return reflush_rule
     */
    public String getReflushRule() {
        return reflushRule;
    }

    /**
     * @param reflushRule
     */
    public void setReflushRule(String reflushRule) {
        this.reflushRule = reflushRule;
    }

    /**
     * @return corp_logo
     */
    public String getCorpLogo() {
        return corpLogo;
    }

    /**
     * @param corpLogo
     */
    public void setCorpLogo(String corpLogo) {
        this.corpLogo = corpLogo;
    }
}