package com.bean;

import java.util.Date;
import javax.persistence.*;

public class Doctor {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
     * 诊室名字
     */
    @Column(name = "diag_room")
    private String diagRoom;

    /**
     * 登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 登出时间
     */
    @Column(name = "logout_time")
    private Date logoutTime;

    /**
     * 是否在线
     */
    @Column(name = "is_online")
    private Byte isOnline;

    /**
     * 医院编码
     */
    @Column(name = "corp_id")
    private String corpId;

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
     * 队列名
     */
    @Column(name = "queue_name")
    private String queueName;

    /**
     * 医生可选标志
     */
    @Column(name = "doctor_sel")
    private Byte doctorSel;

    /**
     * 诊室code
     */
    @Column(name = "diag_room_code")
    private String diagRoomCode;

    /**
     * 队列优先级标志
     */
    private Byte priority;

    @Column(name = "back_flag")
    private Integer backFlag;

    /**
     * 是否党徽，0非党员，1 党员
     */
    @Column(name = "muti_poly_char")
    private String mutiPolyChar;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    private String area;

    @Column(name = "small_dept_code")
    private String smallDeptCode;

    @Column(name = "small_dept_name")
    private String smallDeptName;

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
     * 获取诊室名字
     *
     * @return diag_room - 诊室名字
     */
    public String getDiagRoom() {
        return diagRoom;
    }

    /**
     * 设置诊室名字
     *
     * @param diagRoom 诊室名字
     */
    public void setDiagRoom(String diagRoom) {
        this.diagRoom = diagRoom;
    }

    /**
     * 获取登录时间
     *
     * @return login_time - 登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置登录时间
     *
     * @param loginTime 登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取登出时间
     *
     * @return logout_time - 登出时间
     */
    public Date getLogoutTime() {
        return logoutTime;
    }

    /**
     * 设置登出时间
     *
     * @param logoutTime 登出时间
     */
    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    /**
     * 获取是否在线
     *
     * @return is_online - 是否在线
     */
    public Byte getIsOnline() {
        return isOnline;
    }

    /**
     * 设置是否在线
     *
     * @param isOnline 是否在线
     */
    public void setIsOnline(Byte isOnline) {
        this.isOnline = isOnline;
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
     * 获取诊室code
     *
     * @return diag_room_code - 诊室code
     */
    public String getDiagRoomCode() {
        return diagRoomCode;
    }

    /**
     * 设置诊室code
     *
     * @param diagRoomCode 诊室code
     */
    public void setDiagRoomCode(String diagRoomCode) {
        this.diagRoomCode = diagRoomCode;
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
     * @return back_flag
     */
    public Integer getBackFlag() {
        return backFlag;
    }

    /**
     * @param backFlag
     */
    public void setBackFlag(Integer backFlag) {
        this.backFlag = backFlag;
    }

    /**
     * 获取是否党徽，0非党员，1 党员
     *
     * @return muti_poly_char - 是否党徽，0非党员，1 党员
     */
    public String getMutiPolyChar() {
        return mutiPolyChar;
    }

    /**
     * 设置是否党徽，0非党员，1 党员
     *
     * @param mutiPolyChar 是否党徽，0非党员，1 党员
     */
    public void setMutiPolyChar(String mutiPolyChar) {
        this.mutiPolyChar = mutiPolyChar;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    /**
     * @return small_dept_code
     */
    public String getSmallDeptCode() {
        return smallDeptCode;
    }

    /**
     * @param smallDeptCode
     */
    public void setSmallDeptCode(String smallDeptCode) {
        this.smallDeptCode = smallDeptCode;
    }

    /**
     * @return small_dept_name
     */
    public String getSmallDeptName() {
        return smallDeptName;
    }

    /**
     * @param smallDeptName
     */
    public void setSmallDeptName(String smallDeptName) {
        this.smallDeptName = smallDeptName;
    }
}