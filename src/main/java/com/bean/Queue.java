package com.bean;

import java.util.Date;
import javax.persistence.*;

public class Queue {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 队列编号,emp 专家队列
     */
    @Column(name = "queue_code")
    private String queueCode;

    /**
     * 队列名称
     */
    @Column(name = "queue_name")
    private String queueName;

    /**
     * 队列日期
     */
    @Column(name = "queue_date")
    private Date queueDate;

    /**
     * 区域,分诊的区域
     */
    private String area;

    /**
     * 是否关闭,0正常，1已关闭
     */
    private Boolean closed;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 队列类型，比如普通 队列为0，专家队列1 
     */
    @Column(name = "queue_type")
    private Byte queueType;

    /**
     * 大科室名称
     */
    @Column(name = "big_dept_name")
    private String bigDeptName;

    /**
     * 大科室编码
     */
    @Column(name = "big_dept_code")
    private String bigDeptCode;

    /**
     * 预就诊人数
     */
    @Column(name = "pre_count")
    private Integer preCount;

    /**
     * 患者是否可以选择医生,0不可选，1可选
     */
    @Column(name = "doctor_sel")
    private Boolean doctorSel;

    /**
     * 回诊患者处理方式
0: 不处理
1: 优先处理
2: 普通处理
     */
    @Column(name = "back_type")
    private Integer backType;

    /**
     * 医院编码
     */
    @Column(name = "corp_id")
    private String corpId;

    /**
     * 就诊地址
     */
    @Column(name = "dept_address")
    private String deptAddress;

    /**
     * 小科室名称
     */
    @Column(name = "small_dept_name")
    private String smallDeptName;

    /**
     * 小科室编码
     */
    @Column(name = "small_dept_code")
    private String smallDeptCode;

    /**
     * 服务方式，0一次分诊出队列，1二次分诊出队列、3单个服务、4批量服务。。。
     */
    @Column(name = "service_mode")
    private Byte serviceMode;

    /**
     * 队列报警上限人数
     */
    @Column(name = "queue_limit_num")
    private Byte queueLimitNum;

    /**
     * 医生报警上限人数
     */
    @Column(name = "doctor_limit_num")
    private Byte doctorLimitNum;

    /**
     * 队列删除标志
     */
    @Column(name = "del_flag")
    private Byte delFlag;

    /**
     * 队列tag ,如果是科室则是 科室code ，如果是医生则是医生code
     */
    @Column(name = "queue_tag")
    private String queueTag;

    /**
     * 队列别名
     */
    @Column(name = "queue_alias")
    private String queueAlias;

    /**
     * 队列在护士台的排序
     */
    private Integer sort;

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
     * 获取队列编号,emp 专家队列
     *
     * @return queue_code - 队列编号,emp 专家队列
     */
    public String getQueueCode() {
        return queueCode;
    }

    /**
     * 设置队列编号,emp 专家队列
     *
     * @param queueCode 队列编号,emp 专家队列
     */
    public void setQueueCode(String queueCode) {
        this.queueCode = queueCode;
    }

    /**
     * 获取队列名称
     *
     * @return queue_name - 队列名称
     */
    public String getQueueName() {
        return queueName;
    }

    /**
     * 设置队列名称
     *
     * @param queueName 队列名称
     */
    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    /**
     * 获取队列日期
     *
     * @return queue_date - 队列日期
     */
    public Date getQueueDate() {
        return queueDate;
    }

    /**
     * 设置队列日期
     *
     * @param queueDate 队列日期
     */
    public void setQueueDate(Date queueDate) {
        this.queueDate = queueDate;
    }

    /**
     * 获取区域,分诊的区域
     *
     * @return area - 区域,分诊的区域
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置区域,分诊的区域
     *
     * @param area 区域,分诊的区域
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取是否关闭,0正常，1已关闭
     *
     * @return closed - 是否关闭,0正常，1已关闭
     */
    public Boolean getClosed() {
        return closed;
    }

    /**
     * 设置是否关闭,0正常，1已关闭
     *
     * @param closed 是否关闭,0正常，1已关闭
     */
    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取队列类型，比如普通 队列为0，专家队列1 
     *
     * @return queue_type - 队列类型，比如普通 队列为0，专家队列1 
     */
    public Byte getQueueType() {
        return queueType;
    }

    /**
     * 设置队列类型，比如普通 队列为0，专家队列1 
     *
     * @param queueType 队列类型，比如普通 队列为0，专家队列1 
     */
    public void setQueueType(Byte queueType) {
        this.queueType = queueType;
    }

    /**
     * 获取大科室名称
     *
     * @return big_dept_name - 大科室名称
     */
    public String getBigDeptName() {
        return bigDeptName;
    }

    /**
     * 设置大科室名称
     *
     * @param bigDeptName 大科室名称
     */
    public void setBigDeptName(String bigDeptName) {
        this.bigDeptName = bigDeptName;
    }

    /**
     * 获取大科室编码
     *
     * @return big_dept_code - 大科室编码
     */
    public String getBigDeptCode() {
        return bigDeptCode;
    }

    /**
     * 设置大科室编码
     *
     * @param bigDeptCode 大科室编码
     */
    public void setBigDeptCode(String bigDeptCode) {
        this.bigDeptCode = bigDeptCode;
    }

    /**
     * 获取预就诊人数
     *
     * @return pre_count - 预就诊人数
     */
    public Integer getPreCount() {
        return preCount;
    }

    /**
     * 设置预就诊人数
     *
     * @param preCount 预就诊人数
     */
    public void setPreCount(Integer preCount) {
        this.preCount = preCount;
    }

    /**
     * 获取患者是否可以选择医生,0不可选，1可选
     *
     * @return doctor_sel - 患者是否可以选择医生,0不可选，1可选
     */
    public Boolean getDoctorSel() {
        return doctorSel;
    }

    /**
     * 设置患者是否可以选择医生,0不可选，1可选
     *
     * @param doctorSel 患者是否可以选择医生,0不可选，1可选
     */
    public void setDoctorSel(Boolean doctorSel) {
        this.doctorSel = doctorSel;
    }

    /**
     * 获取回诊患者处理方式
0: 不处理
1: 优先处理
2: 普通处理
     *
     * @return back_type - 回诊患者处理方式
0: 不处理
1: 优先处理
2: 普通处理
     */
    public Integer getBackType() {
        return backType;
    }

    /**
     * 设置回诊患者处理方式
0: 不处理
1: 优先处理
2: 普通处理
     *
     * @param backType 回诊患者处理方式
0: 不处理
1: 优先处理
2: 普通处理
     */
    public void setBackType(Integer backType) {
        this.backType = backType;
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
     * 获取就诊地址
     *
     * @return dept_address - 就诊地址
     */
    public String getDeptAddress() {
        return deptAddress;
    }

    /**
     * 设置就诊地址
     *
     * @param deptAddress 就诊地址
     */
    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress;
    }

    /**
     * 获取小科室名称
     *
     * @return small_dept_name - 小科室名称
     */
    public String getSmallDeptName() {
        return smallDeptName;
    }

    /**
     * 设置小科室名称
     *
     * @param smallDeptName 小科室名称
     */
    public void setSmallDeptName(String smallDeptName) {
        this.smallDeptName = smallDeptName;
    }

    /**
     * 获取小科室编码
     *
     * @return small_dept_code - 小科室编码
     */
    public String getSmallDeptCode() {
        return smallDeptCode;
    }

    /**
     * 设置小科室编码
     *
     * @param smallDeptCode 小科室编码
     */
    public void setSmallDeptCode(String smallDeptCode) {
        this.smallDeptCode = smallDeptCode;
    }

    /**
     * 获取服务方式，0一次分诊出队列，1二次分诊出队列、3单个服务、4批量服务。。。
     *
     * @return service_mode - 服务方式，0一次分诊出队列，1二次分诊出队列、3单个服务、4批量服务。。。
     */
    public Byte getServiceMode() {
        return serviceMode;
    }

    /**
     * 设置服务方式，0一次分诊出队列，1二次分诊出队列、3单个服务、4批量服务。。。
     *
     * @param serviceMode 服务方式，0一次分诊出队列，1二次分诊出队列、3单个服务、4批量服务。。。
     */
    public void setServiceMode(Byte serviceMode) {
        this.serviceMode = serviceMode;
    }

    /**
     * 获取队列报警上限人数
     *
     * @return queue_limit_num - 队列报警上限人数
     */
    public Byte getQueueLimitNum() {
        return queueLimitNum;
    }

    /**
     * 设置队列报警上限人数
     *
     * @param queueLimitNum 队列报警上限人数
     */
    public void setQueueLimitNum(Byte queueLimitNum) {
        this.queueLimitNum = queueLimitNum;
    }

    /**
     * 获取医生报警上限人数
     *
     * @return doctor_limit_num - 医生报警上限人数
     */
    public Byte getDoctorLimitNum() {
        return doctorLimitNum;
    }

    /**
     * 设置医生报警上限人数
     *
     * @param doctorLimitNum 医生报警上限人数
     */
    public void setDoctorLimitNum(Byte doctorLimitNum) {
        this.doctorLimitNum = doctorLimitNum;
    }

    /**
     * 获取队列删除标志
     *
     * @return del_flag - 队列删除标志
     */
    public Byte getDelFlag() {
        return delFlag;
    }

    /**
     * 设置队列删除标志
     *
     * @param delFlag 队列删除标志
     */
    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取队列tag ,如果是科室则是 科室code ，如果是医生则是医生code
     *
     * @return queue_tag - 队列tag ,如果是科室则是 科室code ，如果是医生则是医生code
     */
    public String getQueueTag() {
        return queueTag;
    }

    /**
     * 设置队列tag ,如果是科室则是 科室code ，如果是医生则是医生code
     *
     * @param queueTag 队列tag ,如果是科室则是 科室code ，如果是医生则是医生code
     */
    public void setQueueTag(String queueTag) {
        this.queueTag = queueTag;
    }

    /**
     * 获取队列别名
     *
     * @return queue_alias - 队列别名
     */
    public String getQueueAlias() {
        return queueAlias;
    }

    /**
     * 设置队列别名
     *
     * @param queueAlias 队列别名
     */
    public void setQueueAlias(String queueAlias) {
        this.queueAlias = queueAlias;
    }

    /**
     * 获取队列在护士台的排序
     *
     * @return sort - 队列在护士台的排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置队列在护士台的排序
     *
     * @param sort 队列在护士台的排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}