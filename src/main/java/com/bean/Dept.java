package com.bean;

import java.util.Date;
import javax.persistence.*;

public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 医院编码
     */
    @Column(name = "corp_id")
    private Long corpId;

    @Column(name = "corp_code")
    private String corpCode;

    @Column(name = "parent_dept_code")
    private String parentDeptCode;

    @Column(name = "parent_dept_name")
    private String parentDeptName;

    @Column(name = "parent_dept_py")
    private String parentDeptPy;

    @Column(name = "parent_dept_simple_py")
    private String parentDeptSimplePy;

    @Column(name = "dept_code")
    private String deptCode;

    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "dept_py")
    private String deptPy;

    @Column(name = "dept_simple_py")
    private String deptSimplePy;

    private String phone;

    private String address;

    @Column(name = "dept_intro")
    private String deptIntro;

    @Column(name = "serial_num")
    private Integer serialNum;

    private Boolean status;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modify")
    private Date gmtModify;

    @Column(name = "gender_limit")
    private Integer genderLimit;

    @Column(name = "age_limit")
    private String ageLimit;

    @Column(name = "dept_type")
    private Integer deptType;

    private String area;

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
     * 获取医院编码
     *
     * @return corp_id - 医院编码
     */
    public Long getCorpId() {
        return corpId;
    }

    /**
     * 设置医院编码
     *
     * @param corpId 医院编码
     */
    public void setCorpId(Long corpId) {
        this.corpId = corpId;
    }

    /**
     * @return corp_code
     */
    public String getCorpCode() {
        return corpCode;
    }

    /**
     * @param corpCode
     */
    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode;
    }

    /**
     * @return parent_dept_code
     */
    public String getParentDeptCode() {
        return parentDeptCode;
    }

    /**
     * @param parentDeptCode
     */
    public void setParentDeptCode(String parentDeptCode) {
        this.parentDeptCode = parentDeptCode;
    }

    /**
     * @return parent_dept_name
     */
    public String getParentDeptName() {
        return parentDeptName;
    }

    /**
     * @param parentDeptName
     */
    public void setParentDeptName(String parentDeptName) {
        this.parentDeptName = parentDeptName;
    }

    /**
     * @return parent_dept_py
     */
    public String getParentDeptPy() {
        return parentDeptPy;
    }

    /**
     * @param parentDeptPy
     */
    public void setParentDeptPy(String parentDeptPy) {
        this.parentDeptPy = parentDeptPy;
    }

    /**
     * @return parent_dept_simple_py
     */
    public String getParentDeptSimplePy() {
        return parentDeptSimplePy;
    }

    /**
     * @param parentDeptSimplePy
     */
    public void setParentDeptSimplePy(String parentDeptSimplePy) {
        this.parentDeptSimplePy = parentDeptSimplePy;
    }

    /**
     * @return dept_code
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * @param deptCode
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * @return dept_name
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * @return dept_py
     */
    public String getDeptPy() {
        return deptPy;
    }

    /**
     * @param deptPy
     */
    public void setDeptPy(String deptPy) {
        this.deptPy = deptPy;
    }

    /**
     * @return dept_simple_py
     */
    public String getDeptSimplePy() {
        return deptSimplePy;
    }

    /**
     * @param deptSimplePy
     */
    public void setDeptSimplePy(String deptSimplePy) {
        this.deptSimplePy = deptSimplePy;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return dept_intro
     */
    public String getDeptIntro() {
        return deptIntro;
    }

    /**
     * @param deptIntro
     */
    public void setDeptIntro(String deptIntro) {
        this.deptIntro = deptIntro;
    }

    /**
     * @return serial_num
     */
    public Integer getSerialNum() {
        return serialNum;
    }

    /**
     * @param serialNum
     */
    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    /**
     * @return status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Boolean status) {
        this.status = status;
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
     * @return gender_limit
     */
    public Integer getGenderLimit() {
        return genderLimit;
    }

    /**
     * @param genderLimit
     */
    public void setGenderLimit(Integer genderLimit) {
        this.genderLimit = genderLimit;
    }

    /**
     * @return age_limit
     */
    public String getAgeLimit() {
        return ageLimit;
    }

    /**
     * @param ageLimit
     */
    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    /**
     * @return dept_type
     */
    public Integer getDeptType() {
        return deptType;
    }

    /**
     * @param deptType
     */
    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }

    /**
     * @return area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area
     */
    public void setArea(String area) {
        this.area = area;
    }
}