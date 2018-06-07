package com.bean;

import javax.persistence.*;

@Table(name = "doctor_queue_scope")
public class DoctorQueueScope {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 分诊区域位置编码
     */
    private String area;

    /**
     * 队列code
     */
    @Column(name = "queue_code")
    private String queueCode;

    /**
     * 医生名字
     */
    @Column(name = "doctor_name")
    private String doctorName;

    /**
     * 医生his code

     */
    @Column(name = "doctor_code")
    private String doctorCode;

    /**
     * 医生工号
     */
    @Column(name = "doctor_no")
    private String doctorNo;

    /**
     * 医生职称
     */
    private String level;

    /**
     * 医院编码
     */
    @Column(name = "corp_id")
    private String corpId;

    /**
     * 科室名字
     */
    @Column(name = "small_dept_name")
    private String smallDeptName;

    /**
     * 小科室code

     */
    @Column(name = "small_dept_code")
    private String smallDeptCode;

    /**
     * 医生logo
     */
    @Column(name = "doct_logo")
    private String doctLogo;

    /**
     * 医生介绍
     */
    private String description;

    /**
     * 医生类型：普通/专家
默认 0 普通，1专家
     */
    @Column(name = "doctor_type")
    private Byte doctorType;

    /**
     * 医生所在地址（一号台）
     */
    @Column(name = "doctor_address")
    private String doctorAddress;

    /**
     * 医生可选标志
     */
    @Column(name = "doctor_sel")
    private Byte doctorSel;

    /**
     * 队列优先级标志
     */
    private Byte priority;

    /**
     * 队列名
     */
    @Column(name = "queue_name")
    private String queueName;

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
     * 获取分诊区域位置编码
     *
     * @return area - 分诊区域位置编码
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置分诊区域位置编码
     *
     * @param area 分诊区域位置编码
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取队列code
     *
     * @return queue_code - 队列code
     */
    public String getQueueCode() {
        return queueCode;
    }

    /**
     * 设置队列code
     *
     * @param queueCode 队列code
     */
    public void setQueueCode(String queueCode) {
        this.queueCode = queueCode;
    }

    /**
     * 获取医生名字
     *
     * @return doctor_name - 医生名字
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * 设置医生名字
     *
     * @param doctorName 医生名字
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    /**
     * 获取医生his code

     *
     * @return doctor_code - 医生his code

     */
    public String getDoctorCode() {
        return doctorCode;
    }

    /**
     * 设置医生his code

     *
     * @param doctorCode 医生his code

     */
    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    /**
     * 获取医生工号
     *
     * @return doctor_no - 医生工号
     */
    public String getDoctorNo() {
        return doctorNo;
    }

    /**
     * 设置医生工号
     *
     * @param doctorNo 医生工号
     */
    public void setDoctorNo(String doctorNo) {
        this.doctorNo = doctorNo;
    }

    /**
     * 获取医生职称
     *
     * @return level - 医生职称
     */
    public String getLevel() {
        return level;
    }

    /**
     * 设置医生职称
     *
     * @param level 医生职称
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * 获取医院编码
     *
     * @return corp_id - 医院编码
     */
    public String getCorpId() {
        return corpId;
    }

    /**
     * 设置医院编码
     *
     * @param corpId 医院编码
     */
    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    /**
     * 获取科室名字
     *
     * @return small_dept_name - 科室名字
     */
    public String getSmallDeptName() {
        return smallDeptName;
    }

    /**
     * 设置科室名字
     *
     * @param smallDeptName 科室名字
     */
    public void setSmallDeptName(String smallDeptName) {
        this.smallDeptName = smallDeptName;
    }

    /**
     * 获取小科室code

     *
     * @return small_dept_code - 小科室code

     */
    public String getSmallDeptCode() {
        return smallDeptCode;
    }

    /**
     * 设置小科室code

     *
     * @param smallDeptCode 小科室code

     */
    public void setSmallDeptCode(String smallDeptCode) {
        this.smallDeptCode = smallDeptCode;
    }

    /**
     * 获取医生logo
     *
     * @return doct_logo - 医生logo
     */
    public String getDoctLogo() {
        return doctLogo;
    }

    /**
     * 设置医生logo
     *
     * @param doctLogo 医生logo
     */
    public void setDoctLogo(String doctLogo) {
        this.doctLogo = doctLogo;
    }

    /**
     * 获取医生介绍
     *
     * @return description - 医生介绍
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置医生介绍
     *
     * @param description 医生介绍
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取医生类型：普通/专家
默认 0 普通，1专家
     *
     * @return doctor_type - 医生类型：普通/专家
默认 0 普通，1专家
     */
    public Byte getDoctorType() {
        return doctorType;
    }

    /**
     * 设置医生类型：普通/专家
默认 0 普通，1专家
     *
     * @param doctorType 医生类型：普通/专家
默认 0 普通，1专家
     */
    public void setDoctorType(Byte doctorType) {
        this.doctorType = doctorType;
    }

    /**
     * 获取医生所在地址（一号台）
     *
     * @return doctor_address - 医生所在地址（一号台）
     */
    public String getDoctorAddress() {
        return doctorAddress;
    }

    /**
     * 设置医生所在地址（一号台）
     *
     * @param doctorAddress 医生所在地址（一号台）
     */
    public void setDoctorAddress(String doctorAddress) {
        this.doctorAddress = doctorAddress;
    }

    /**
     * 获取医生可选标志
     *
     * @return doctor_sel - 医生可选标志
     */
    public Byte getDoctorSel() {
        return doctorSel;
    }

    /**
     * 设置医生可选标志
     *
     * @param doctorSel 医生可选标志
     */
    public void setDoctorSel(Byte doctorSel) {
        this.doctorSel = doctorSel;
    }

    /**
     * 获取队列优先级标志
     *
     * @return priority - 队列优先级标志
     */
    public Byte getPriority() {
        return priority;
    }

    /**
     * 设置队列优先级标志
     *
     * @param priority 队列优先级标志
     */
    public void setPriority(Byte priority) {
        this.priority = priority;
    }

    /**
     * 获取队列名
     *
     * @return queue_name - 队列名
     */
    public String getQueueName() {
        return queueName;
    }

    /**
     * 设置队列名
     *
     * @param queueName 队列名
     */
    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }
}