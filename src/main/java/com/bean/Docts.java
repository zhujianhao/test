package com.bean;

import java.util.Date;
import javax.persistence.*;

public class Docts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doct_code")
    private String doctCode;

    @Column(name = "doct_name")
    private String doctName;

    @Column(name = "doct_py")
    private String doctPy;

    @Column(name = "doct_simple_py")
    private String doctSimplePy;

    private String sex;

    @Column(name = "serial_num")
    private Integer serialNum;

    @Column(name = "doct_logo")
    private String doctLogo;

    @Column(name = "doct_level")
    private String doctLevel;

    @Column(name = "doct_profe")
    private String doctProfe;

    @Column(name = "doct_spec")
    private String doctSpec;

    @Column(name = "doct_intro")
    private String doctIntro;

    @Column(name = "corp_id")
    private Long corpId;

    @Column(name = "corp_code")
    private String corpCode;

    @Column(name = "dept_code")
    private String deptCode;

    @Column(name = "dept_name")
    private String deptName;

    private Integer status;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modify")
    private Date gmtModify;

    @Column(name = "doct_phone_num")
    private String doctPhoneNum;

    @Column(name = "doct_no")
    private String doctNo;

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
     * @return doct_code
     */
    public String getDoctCode() {
        return doctCode;
    }

    /**
     * @param doctCode
     */
    public void setDoctCode(String doctCode) {
        this.doctCode = doctCode;
    }

    /**
     * @return doct_name
     */
    public String getDoctName() {
        return doctName;
    }

    /**
     * @param doctName
     */
    public void setDoctName(String doctName) {
        this.doctName = doctName;
    }

    /**
     * @return doct_py
     */
    public String getDoctPy() {
        return doctPy;
    }

    /**
     * @param doctPy
     */
    public void setDoctPy(String doctPy) {
        this.doctPy = doctPy;
    }

    /**
     * @return doct_simple_py
     */
    public String getDoctSimplePy() {
        return doctSimplePy;
    }

    /**
     * @param doctSimplePy
     */
    public void setDoctSimplePy(String doctSimplePy) {
        this.doctSimplePy = doctSimplePy;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
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
     * @return doct_logo
     */
    public String getDoctLogo() {
        return doctLogo;
    }

    /**
     * @param doctLogo
     */
    public void setDoctLogo(String doctLogo) {
        this.doctLogo = doctLogo;
    }

    /**
     * @return doct_level
     */
    public String getDoctLevel() {
        return doctLevel;
    }

    /**
     * @param doctLevel
     */
    public void setDoctLevel(String doctLevel) {
        this.doctLevel = doctLevel;
    }

    /**
     * @return doct_profe
     */
    public String getDoctProfe() {
        return doctProfe;
    }

    /**
     * @param doctProfe
     */
    public void setDoctProfe(String doctProfe) {
        this.doctProfe = doctProfe;
    }

    /**
     * @return doct_spec
     */
    public String getDoctSpec() {
        return doctSpec;
    }

    /**
     * @param doctSpec
     */
    public void setDoctSpec(String doctSpec) {
        this.doctSpec = doctSpec;
    }

    /**
     * @return doct_intro
     */
    public String getDoctIntro() {
        return doctIntro;
    }

    /**
     * @param doctIntro
     */
    public void setDoctIntro(String doctIntro) {
        this.doctIntro = doctIntro;
    }

    /**
     * @return corp_id
     */
    public Long getCorpId() {
        return corpId;
    }

    /**
     * @param corpId
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
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
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
     * @return doct_phone_num
     */
    public String getDoctPhoneNum() {
        return doctPhoneNum;
    }

    /**
     * @param doctPhoneNum
     */
    public void setDoctPhoneNum(String doctPhoneNum) {
        this.doctPhoneNum = doctPhoneNum;
    }

    /**
     * @return doct_no
     */
    public String getDoctNo() {
        return doctNo;
    }

    /**
     * @param doctNo
     */
    public void setDoctNo(String doctNo) {
        this.doctNo = doctNo;
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