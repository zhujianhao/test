package com.bean;

import java.util.Date;
import javax.persistence.*;

public class Patient {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 分诊的区域 编号
     */
    private String area;

    /**
     * 队列code
     */
    @Column(name = "queue_code")
    private String queueCode;

    /**
     * 患者序号
     */
    @Column(name = "order_no")
    private Integer orderNo;

    /**
     * 队列类型
     */
    @Column(name = "order_type")
    private String orderType;

    /**
     * 叫号顺序权重
     */
    private Integer weight;

    /**
     * 性别 女 男
     */
    private String sex;

    /**
     * 门诊号
     */
    @Column(name = "patient_no")
    private String patientNo;

    /**
     * 医生名
     */
    @Column(name = "doctor_name")
    private String doctorName;

    /**
     * 呼叫次数
     */
    @Column(name = "call_times")
    private Integer callTimes;

    /**
     * 0:就诊中
1:候诊中
2:已过号
3:已结束

7:弃号
8：退号
9：未签到
10:过期

     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 年龄
     */
    private String age;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 是否为回诊患者
     */
    @Column(name = "is_back")
    private Boolean isBack;

    /**
     * 医院编码
     */
    @Column(name = "corp_id")
    private String corpId;

    /**
     * 医院名称
     */
    @Column(name = "corp_name")
    private String corpName;

    /**
     * 就诊卡
     */
    @Column(name = "card_no")
    private String cardNo;

    /**
     * 证件类型: 1 身份证, 2 军人证, 3 护照, 4 学生证, 5 回乡证, 6 驾驶证, 7 台胞证, 9 其它，10 就诊卡,11 医保卡
     */
    @Column(name = "card_type")
    private Integer cardType;

    /**
     * 患者名字
     */
    private String username;

    /**
     * 身份证
     */
    @Column(name = "id_no")
    private String idNo;

    /**
     * 监护人
     */
    @Column(name = "guard_no")
    private String guardNo;

    /**
     * 诊室名
     */
    @Column(name = "diag_room")
    private String diagRoom;

    /**
     * 小科室code
     */
    @Column(name = "small_dept_code")
    private String smallDeptCode;

    /**
     * 科室名
     */
    @Column(name = "small_dept_name")
    private String smallDeptName;

    /**
     * 大科室code
     */
    @Column(name = "big_dept_code")
    private String bigDeptCode;

    /**
     * 小科室名
     */
    @Column(name = "big_dept_name")
    private String bigDeptName;

    /**
     * 开始候诊时间，对应状态1
     */
    @Column(name = "waiting_time")
    private Date waitingTime;

    /**
     * 等待就诊时间，对应状态4
     */
    @Column(name = "pre_time")
    private Date preTime;

    /**
     * 被叫号时间，对应状态0
     */
    @Column(name = "calling_time")
    private Date callingTime;

    /**
     * 就诊完成时间，对应状态3
     */
    @Column(name = "complete_time")
    private Date completeTime;

    /**
     * 医生工号
     */
    @Column(name = "doctor_no")
    private String doctorNo;

    /**
     * 医生his code
     */
    @Column(name = "doctor_code")
    private String doctorCode;

    /**
     * 过号时间
     */
    @Column(name = "pass_time")
    private Date passTime;

    /**
     * 选择医生
     */
    @Column(name = "doctor_choose")
    private Byte doctorChoose;

    /**
     * 挂号流水账号
     */
    @Column(name = "reg_id")
    private String regId;

    /**
     * 上下午标志
     */
    @Column(name = "interval_flag")
    private Byte intervalFlag;

    /**
     * 挂号时间
     */
    @Column(name = "reg_time")
    private Date regTime;

    /**
     * 挂号类型，1：普通 2：急诊  3：名医  4：专家  5：便民  6：视频问诊  7：医技 8：取药 9：住院
     */
    @Column(name = "reg_type")
    private Byte regType;

    /**
     * 队列名字
     */
    @Column(name = "queue_name")
    private String queueName;

    /**
     * 医生所在具体地址
     */
    @Column(name = "doctor_address")
    private String doctorAddress;

    /**
     * 诊室code
     */
    @Column(name = "diag_room_code")
    private String diagRoomCode;

    /**
     * 0 通知失败或者需要通知his  1 通知his成功或者不需要通知his
     */
    @Column(name = "whether_notice_his")
    private Byte whetherNoticeHis;

    /**
     * 1:预约  2：挂号
     */
    @Column(name = "reg_mode")
    private Byte regMode;

    /**
     * 开诊时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 闭诊时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 前端显示的序号字段
     */
    @Column(name = "order_no_tag")
    private String orderNoTag;

    /**
     * 最终医生工号
     */
    @Column(name = "dest_doctor_no")
    private String destDoctorNo;

    /**
     * 最终医生his code
     */
    @Column(name = "dest_doctor_code")
    private String destDoctorCode;

    /**
     * 最终队列code
     */
    @Column(name = "dest_queue_code")
    private String destQueueCode;

    /**
     * 最终看病医生name
     */
    @Column(name = "dest_doctor_name")
    private String destDoctorName;

    /**
     * 叫号权重
     */
    @Column(name = "call_priority")
    private Integer callPriority;

    /**
     * 护士叫号次数
     */
    @Column(name = "nurse_call_times")
    private Integer nurseCallTimes;

    /**
     * 最近一次预检呼叫时间
     */
    @Column(name = "pre_nurse_call_time")
    private Date preNurseCallTime;

    /**
     * 急诊等级  分为3级和4级
     */
    @Column(name = "med_level")
    private String medLevel;

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
     * 获取分诊的区域 编号
     *
     * @return area - 分诊的区域 编号
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置分诊的区域 编号
     *
     * @param area 分诊的区域 编号
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
     * 获取患者序号
     *
     * @return order_no - 患者序号
     */
    public Integer getOrderNo() {
        return orderNo;
    }

    /**
     * 设置患者序号
     *
     * @param orderNo 患者序号
     */
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取队列类型
     *
     * @return order_type - 队列类型
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * 设置队列类型
     *
     * @param orderType 队列类型
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * 获取叫号顺序权重
     *
     * @return weight - 叫号顺序权重
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置叫号顺序权重
     *
     * @param weight 叫号顺序权重
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 获取性别 女 男
     *
     * @return sex - 性别 女 男
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别 女 男
     *
     * @param sex 性别 女 男
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取门诊号
     *
     * @return patient_no - 门诊号
     */
    public String getPatientNo() {
        return patientNo;
    }

    /**
     * 设置门诊号
     *
     * @param patientNo 门诊号
     */
    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    /**
     * 获取医生名
     *
     * @return doctor_name - 医生名
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * 设置医生名
     *
     * @param doctorName 医生名
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    /**
     * 获取呼叫次数
     *
     * @return call_times - 呼叫次数
     */
    public Integer getCallTimes() {
        return callTimes;
    }

    /**
     * 设置呼叫次数
     *
     * @param callTimes 呼叫次数
     */
    public void setCallTimes(Integer callTimes) {
        this.callTimes = callTimes;
    }

    /**
     * 获取0:就诊中
1:候诊中
2:已过号
3:已结束

7:弃号
8：退号
9：未签到
10:过期

     *
     * @return status - 0:就诊中
1:候诊中
2:已过号
3:已结束

7:弃号
8：退号
9：未签到
10:过期

     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0:就诊中
1:候诊中
2:已过号
3:已结束

7:弃号
8：退号
9：未签到
10:过期

     *
     * @param status 0:就诊中
1:候诊中
2:已过号
3:已结束

7:弃号
8：退号
9：未签到
10:过期

     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public String getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取是否为回诊患者
     *
     * @return is_back - 是否为回诊患者
     */
    public Boolean getIsBack() {
        return isBack;
    }

    /**
     * 设置是否为回诊患者
     *
     * @param isBack 是否为回诊患者
     */
    public void setIsBack(Boolean isBack) {
        this.isBack = isBack;
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
     * 获取就诊卡
     *
     * @return card_no - 就诊卡
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置就诊卡
     *
     * @param cardNo 就诊卡
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * 获取证件类型: 1 身份证, 2 军人证, 3 护照, 4 学生证, 5 回乡证, 6 驾驶证, 7 台胞证, 9 其它，10 就诊卡,11 医保卡
     *
     * @return card_type - 证件类型: 1 身份证, 2 军人证, 3 护照, 4 学生证, 5 回乡证, 6 驾驶证, 7 台胞证, 9 其它，10 就诊卡,11 医保卡
     */
    public Integer getCardType() {
        return cardType;
    }

    /**
     * 设置证件类型: 1 身份证, 2 军人证, 3 护照, 4 学生证, 5 回乡证, 6 驾驶证, 7 台胞证, 9 其它，10 就诊卡,11 医保卡
     *
     * @param cardType 证件类型: 1 身份证, 2 军人证, 3 护照, 4 学生证, 5 回乡证, 6 驾驶证, 7 台胞证, 9 其它，10 就诊卡,11 医保卡
     */
    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    /**
     * 获取患者名字
     *
     * @return username - 患者名字
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置患者名字
     *
     * @param username 患者名字
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取身份证
     *
     * @return id_no - 身份证
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * 设置身份证
     *
     * @param idNo 身份证
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    /**
     * 获取监护人
     *
     * @return guard_no - 监护人
     */
    public String getGuardNo() {
        return guardNo;
    }

    /**
     * 设置监护人
     *
     * @param guardNo 监护人
     */
    public void setGuardNo(String guardNo) {
        this.guardNo = guardNo;
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
     * 获取科室名
     *
     * @return small_dept_name - 科室名
     */
    public String getSmallDeptName() {
        return smallDeptName;
    }

    /**
     * 设置科室名
     *
     * @param smallDeptName 科室名
     */
    public void setSmallDeptName(String smallDeptName) {
        this.smallDeptName = smallDeptName;
    }

    /**
     * 获取大科室code
     *
     * @return big_dept_code - 大科室code
     */
    public String getBigDeptCode() {
        return bigDeptCode;
    }

    /**
     * 设置大科室code
     *
     * @param bigDeptCode 大科室code
     */
    public void setBigDeptCode(String bigDeptCode) {
        this.bigDeptCode = bigDeptCode;
    }

    /**
     * 获取小科室名
     *
     * @return big_dept_name - 小科室名
     */
    public String getBigDeptName() {
        return bigDeptName;
    }

    /**
     * 设置小科室名
     *
     * @param bigDeptName 小科室名
     */
    public void setBigDeptName(String bigDeptName) {
        this.bigDeptName = bigDeptName;
    }

    /**
     * 获取开始候诊时间，对应状态1
     *
     * @return waiting_time - 开始候诊时间，对应状态1
     */
    public Date getWaitingTime() {
        return waitingTime;
    }

    /**
     * 设置开始候诊时间，对应状态1
     *
     * @param waitingTime 开始候诊时间，对应状态1
     */
    public void setWaitingTime(Date waitingTime) {
        this.waitingTime = waitingTime;
    }

    /**
     * 获取等待就诊时间，对应状态4
     *
     * @return pre_time - 等待就诊时间，对应状态4
     */
    public Date getPreTime() {
        return preTime;
    }

    /**
     * 设置等待就诊时间，对应状态4
     *
     * @param preTime 等待就诊时间，对应状态4
     */
    public void setPreTime(Date preTime) {
        this.preTime = preTime;
    }

    /**
     * 获取被叫号时间，对应状态0
     *
     * @return calling_time - 被叫号时间，对应状态0
     */
    public Date getCallingTime() {
        return callingTime;
    }

    /**
     * 设置被叫号时间，对应状态0
     *
     * @param callingTime 被叫号时间，对应状态0
     */
    public void setCallingTime(Date callingTime) {
        this.callingTime = callingTime;
    }

    /**
     * 获取就诊完成时间，对应状态3
     *
     * @return complete_time - 就诊完成时间，对应状态3
     */
    public Date getCompleteTime() {
        return completeTime;
    }

    /**
     * 设置就诊完成时间，对应状态3
     *
     * @param completeTime 就诊完成时间，对应状态3
     */
    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
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
     * 获取过号时间
     *
     * @return pass_time - 过号时间
     */
    public Date getPassTime() {
        return passTime;
    }

    /**
     * 设置过号时间
     *
     * @param passTime 过号时间
     */
    public void setPassTime(Date passTime) {
        this.passTime = passTime;
    }

    /**
     * 获取选择医生
     *
     * @return doctor_choose - 选择医生
     */
    public Byte getDoctorChoose() {
        return doctorChoose;
    }

    /**
     * 设置选择医生
     *
     * @param doctorChoose 选择医生
     */
    public void setDoctorChoose(Byte doctorChoose) {
        this.doctorChoose = doctorChoose;
    }

    /**
     * 获取挂号流水账号
     *
     * @return reg_id - 挂号流水账号
     */
    public String getRegId() {
        return regId;
    }

    /**
     * 设置挂号流水账号
     *
     * @param regId 挂号流水账号
     */
    public void setRegId(String regId) {
        this.regId = regId;
    }

    /**
     * 获取上下午标志
     *
     * @return interval_flag - 上下午标志
     */
    public Byte getIntervalFlag() {
        return intervalFlag;
    }

    /**
     * 设置上下午标志
     *
     * @param intervalFlag 上下午标志
     */
    public void setIntervalFlag(Byte intervalFlag) {
        this.intervalFlag = intervalFlag;
    }

    /**
     * 获取挂号时间
     *
     * @return reg_time - 挂号时间
     */
    public Date getRegTime() {
        return regTime;
    }

    /**
     * 设置挂号时间
     *
     * @param regTime 挂号时间
     */
    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    /**
     * 获取挂号类型，1：普通 2：急诊  3：名医  4：专家  5：便民  6：视频问诊  7：医技 8：取药 9：住院
     *
     * @return reg_type - 挂号类型，1：普通 2：急诊  3：名医  4：专家  5：便民  6：视频问诊  7：医技 8：取药 9：住院
     */
    public Byte getRegType() {
        return regType;
    }

    /**
     * 设置挂号类型，1：普通 2：急诊  3：名医  4：专家  5：便民  6：视频问诊  7：医技 8：取药 9：住院
     *
     * @param regType 挂号类型，1：普通 2：急诊  3：名医  4：专家  5：便民  6：视频问诊  7：医技 8：取药 9：住院
     */
    public void setRegType(Byte regType) {
        this.regType = regType;
    }

    /**
     * 获取队列名字
     *
     * @return queue_name - 队列名字
     */
    public String getQueueName() {
        return queueName;
    }

    /**
     * 设置队列名字
     *
     * @param queueName 队列名字
     */
    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    /**
     * 获取医生所在具体地址
     *
     * @return doctor_address - 医生所在具体地址
     */
    public String getDoctorAddress() {
        return doctorAddress;
    }

    /**
     * 设置医生所在具体地址
     *
     * @param doctorAddress 医生所在具体地址
     */
    public void setDoctorAddress(String doctorAddress) {
        this.doctorAddress = doctorAddress;
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
     * 获取0 通知失败或者需要通知his  1 通知his成功或者不需要通知his
     *
     * @return whether_notice_his - 0 通知失败或者需要通知his  1 通知his成功或者不需要通知his
     */
    public Byte getWhetherNoticeHis() {
        return whetherNoticeHis;
    }

    /**
     * 设置0 通知失败或者需要通知his  1 通知his成功或者不需要通知his
     *
     * @param whetherNoticeHis 0 通知失败或者需要通知his  1 通知his成功或者不需要通知his
     */
    public void setWhetherNoticeHis(Byte whetherNoticeHis) {
        this.whetherNoticeHis = whetherNoticeHis;
    }

    /**
     * 获取1:预约  2：挂号
     *
     * @return reg_mode - 1:预约  2：挂号
     */
    public Byte getRegMode() {
        return regMode;
    }

    /**
     * 设置1:预约  2：挂号
     *
     * @param regMode 1:预约  2：挂号
     */
    public void setRegMode(Byte regMode) {
        this.regMode = regMode;
    }

    /**
     * 获取开诊时间
     *
     * @return start_time - 开诊时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置开诊时间
     *
     * @param startTime 开诊时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取闭诊时间
     *
     * @return end_time - 闭诊时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置闭诊时间
     *
     * @param endTime 闭诊时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取前端显示的序号字段
     *
     * @return order_no_tag - 前端显示的序号字段
     */
    public String getOrderNoTag() {
        return orderNoTag;
    }

    /**
     * 设置前端显示的序号字段
     *
     * @param orderNoTag 前端显示的序号字段
     */
    public void setOrderNoTag(String orderNoTag) {
        this.orderNoTag = orderNoTag;
    }

    /**
     * 获取最终医生工号
     *
     * @return dest_doctor_no - 最终医生工号
     */
    public String getDestDoctorNo() {
        return destDoctorNo;
    }

    /**
     * 设置最终医生工号
     *
     * @param destDoctorNo 最终医生工号
     */
    public void setDestDoctorNo(String destDoctorNo) {
        this.destDoctorNo = destDoctorNo;
    }

    /**
     * 获取最终医生his code
     *
     * @return dest_doctor_code - 最终医生his code
     */
    public String getDestDoctorCode() {
        return destDoctorCode;
    }

    /**
     * 设置最终医生his code
     *
     * @param destDoctorCode 最终医生his code
     */
    public void setDestDoctorCode(String destDoctorCode) {
        this.destDoctorCode = destDoctorCode;
    }

    /**
     * 获取最终队列code
     *
     * @return dest_queue_code - 最终队列code
     */
    public String getDestQueueCode() {
        return destQueueCode;
    }

    /**
     * 设置最终队列code
     *
     * @param destQueueCode 最终队列code
     */
    public void setDestQueueCode(String destQueueCode) {
        this.destQueueCode = destQueueCode;
    }

    /**
     * 获取最终看病医生name
     *
     * @return dest_doctor_name - 最终看病医生name
     */
    public String getDestDoctorName() {
        return destDoctorName;
    }

    /**
     * 设置最终看病医生name
     *
     * @param destDoctorName 最终看病医生name
     */
    public void setDestDoctorName(String destDoctorName) {
        this.destDoctorName = destDoctorName;
    }

    /**
     * 获取叫号权重
     *
     * @return call_priority - 叫号权重
     */
    public Integer getCallPriority() {
        return callPriority;
    }

    /**
     * 设置叫号权重
     *
     * @param callPriority 叫号权重
     */
    public void setCallPriority(Integer callPriority) {
        this.callPriority = callPriority;
    }

    /**
     * 获取护士叫号次数
     *
     * @return nurse_call_times - 护士叫号次数
     */
    public Integer getNurseCallTimes() {
        return nurseCallTimes;
    }

    /**
     * 设置护士叫号次数
     *
     * @param nurseCallTimes 护士叫号次数
     */
    public void setNurseCallTimes(Integer nurseCallTimes) {
        this.nurseCallTimes = nurseCallTimes;
    }

    /**
     * 获取最近一次预检呼叫时间
     *
     * @return pre_nurse_call_time - 最近一次预检呼叫时间
     */
    public Date getPreNurseCallTime() {
        return preNurseCallTime;
    }

    /**
     * 设置最近一次预检呼叫时间
     *
     * @param preNurseCallTime 最近一次预检呼叫时间
     */
    public void setPreNurseCallTime(Date preNurseCallTime) {
        this.preNurseCallTime = preNurseCallTime;
    }

    /**
     * 获取急诊等级  分为3级和4级
     *
     * @return med_level - 急诊等级  分为3级和4级
     */
    public String getMedLevel() {
        return medLevel;
    }

    /**
     * 设置急诊等级  分为3级和4级
     *
     * @param medLevel 急诊等级  分为3级和4级
     */
    public void setMedLevel(String medLevel) {
        this.medLevel = medLevel;
    }
}