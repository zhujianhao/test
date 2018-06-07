package com.bean;

import java.util.Date;
import javax.persistence.*;

public class Doorplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 医院id
     */
    @Column(name = "corp_id")
    private String corpId;

    /**
     * 区域code
     */
    private String area;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modify")
    private Date gmtModify;

    /**
     * 门牌
     */
    private String doorplate;

    /**
     * 门牌code
     */
    @Column(name = "doorplate_code")
    private String doorplateCode;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
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
     * 获取区域code
     *
     * @return area - 区域code
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置区域code
     *
     * @param area 区域code
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取创建时间
     *
     * @return gmt_create - 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取修改时间
     *
     * @return gmt_modify - 修改时间
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * 设置修改时间
     *
     * @param gmtModify 修改时间
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * 获取门牌
     *
     * @return doorplate - 门牌
     */
    public String getDoorplate() {
        return doorplate;
    }

    /**
     * 设置门牌
     *
     * @param doorplate 门牌
     */
    public void setDoorplate(String doorplate) {
        this.doorplate = doorplate;
    }

    /**
     * 获取门牌code
     *
     * @return doorplate_code - 门牌code
     */
    public String getDoorplateCode() {
        return doorplateCode;
    }

    /**
     * 设置门牌code
     *
     * @param doorplateCode 门牌code
     */
    public void setDoorplateCode(String doorplateCode) {
        this.doorplateCode = doorplateCode;
    }
}