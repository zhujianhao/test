package com.bean;

import java.util.Date;
import javax.persistence.*;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    /**
     * 医院Id
     */
    @Column(name = "corp_id")
    private String corpId;

    /**
     * 医院名称
     */
    @Column(name = "corp_name")
    private String corpName;

    @Column(name = "gmt_modify")
    private Date gmtModify;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "is_deleted")
    private Integer isDeleted;

    /**
     * 诊区(可能有多个)
     */
    @Column(name = "corp_area_id")
    private String corpAreaId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取医院Id
     *
     * @return corp_id - 医院Id
     */
    public String getCorpId() {
        return corpId;
    }

    /**
     * 设置医院Id
     *
     * @param corpId 医院Id
     */
    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    /**
     * 获取医院名称
     *
     * @return corp_name - 医院名称
     */
    public String getCorpName() {
        return corpName;
    }

    /**
     * 设置医院名称
     *
     * @param corpName 医院名称
     */
    public void setCorpName(String corpName) {
        this.corpName = corpName;
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
     * @return is_deleted
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 获取诊区(可能有多个)
     *
     * @return corp_area_id - 诊区(可能有多个)
     */
    public String getCorpAreaId() {
        return corpAreaId;
    }

    /**
     * 设置诊区(可能有多个)
     *
     * @param corpAreaId 诊区(可能有多个)
     */
    public void setCorpAreaId(String corpAreaId) {
        this.corpAreaId = corpAreaId;
    }
}