package com.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "doctor_diag_room")
public class DoctorDiagRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 医院编码
     */
    @Column(name = "corp_id")
    private Long corpId;

    /**
     * 区域编码
     */
    private String area;

    /**
     * 区域编码名称
     */
    @Column(name = "area_name")
    private String areaName;

    /**
     * 科室编码
     */
    @Column(name = "small_dept_code")
    private String smallDeptCode;

    /**
     * 医生工号
     */
    @Column(name = "doctor_no")
    private String doctorNo;

    /**
     * 医生编码
     */
    @Column(name = "doctor_code")
    private String doctorCode;

    /**
     * 医生姓名
     */
    @Column(name = "doctor_name")
    private String doctorName;

    /**
     * 诊室名
     */
    @Column(name = "diag_room")
    private String diagRoom;

    /**
     * 排班时间
     */
    @Column(name = "sch_date")
    private Date schDate;

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
     * 上午下午 0 上午 1 下午
     */
    @Column(name = "am_pm")
    private Integer amPm;

    /**
     * 诊室code
     */
    @Column(name = "diag_room_code")
    private String diagRoomCode;

    /**
     * 队列名
     */
    @Column(name = "queue_name")
    private String queueName;

    /**
     * 队列code
     */
    @Column(name = "queue_code")
    private String queueCode;

    /**
     * 星期标志，星期一 1
     */
    private Byte week;

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
     * 获取区域编码
     *
     * @return area - 区域编码
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置区域编码
     *
     * @param area 区域编码
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取区域编码名称
     *
     * @return area_name - 区域编码名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置区域编码名称
     *
     * @param areaName 区域编码名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 获取科室编码
     *
     * @return small_dept_code - 科室编码
     */
    public String getSmallDeptCode() {
        return smallDeptCode;
    }

    /**
     * 设置科室编码
     *
     * @param smallDeptCode 科室编码
     */
    public void setSmallDeptCode(String smallDeptCode) {
        this.smallDeptCode = smallDeptCode;
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
     * 获取医生编码
     *
     * @return doctor_code - 医生编码
     */
    public String getDoctorCode() {
        return doctorCode;
    }

    /**
     * 设置医生编码
     *
     * @param doctorCode 医生编码
     */
    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    /**
     * 获取医生姓名
     *
     * @return doctor_name - 医生姓名
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * 设置医生姓名
     *
     * @param doctorName 医生姓名
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    /**
     * 获取诊室名
     *
     * @return diag_room - 诊室名
     */
    public String getDiagRoom() {
        return diagRoom;
    }

    /**
     * 设置诊室名
     *
     * @param diagRoom 诊室名
     */
    public void setDiagRoom(String diagRoom) {
        this.diagRoom = diagRoom;
    }

    /**
     * 获取排班时间
     *
     * @return sch_date - 排班时间
     */
    public Date getSchDate() {
        return schDate;
    }

    /**
     * 设置排班时间
     *
     * @param schDate 排班时间
     */
    public void setSchDate(Date schDate) {
        this.schDate = schDate;
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
     * 获取上午下午 0 上午 1 下午
     *
     * @return am_pm - 上午下午 0 上午 1 下午
     */
    public Integer getAmPm() {
        return amPm;
    }

    /**
     * 设置上午下午 0 上午 1 下午
     *
     * @param amPm 上午下午 0 上午 1 下午
     */
    public void setAmPm(Integer amPm) {
        this.amPm = amPm;
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
     * 获取星期标志，星期一 1
     *
     * @return week - 星期标志，星期一 1
     */
    public Byte getWeek() {
        return week;
    }

    /**
     * 设置星期标志，星期一 1
     *
     * @param week 星期标志，星期一 1
     */
    public void setWeek(Byte week) {
        this.week = week;
    }
}