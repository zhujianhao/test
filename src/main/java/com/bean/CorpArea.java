package com.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "corp_area")
public class CorpArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 医院编码
     */
    @Column(name = "corp_id")
    private String corpId;

    /**
     * 医院名
     */
    @Column(name = "corp_name")
    private String corpName;

    /**
     * 区域名
     */
    private String area;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改
     */
    @Column(name = "gmt_modify")
    private Date gmtModify;

    /**
     * 区域名
     */
    @Column(name = "area_name")
    private String areaName;

    /**
     * 是否发布 1发布 0 未发布
     */
    private Integer status;

    /**
     * 该诊区支持的分诊模式 1 一次分诊 2 二次分诊
     */
    @Column(name = "service_mode")
    private Byte serviceMode;

    /**
     * 该区域是否先签到进入队列 0签到进队列 1不签到进队列
     */
    @Column(name = "whether_confirm")
    private Byte whetherConfirm;

    /**
     * 该区域是否生成号源 0分诊生成号源，1排班生成号源
     */
    @Column(name = "create_num_source")
    private Byte createNumSource;

    /**
     * 是否使用诊室排班 0 不使用，1使用
     */
    @Column(name = "use_diag_room_scheduling")
    private Byte useDiagRoomScheduling;

    /**
     * 候诊区地址
     */
    private String address;

    /**
     * 院区详情
     */
    private String detail;

    /**
     * 区域类型 0：门诊 1：急诊
     */
    @Column(name = "corp_area_type")
    private Byte corpAreaType;

    /**
     * 诊区媒体资源
     */
    private String media;

    /**
     * 护士台预检呼叫功能 0 无，1有
     */
    @Column(name = "is_nurse_call")
    private Integer isNurseCall;

    /**
     * 是否有叫号到诊台功能，0 没有，1有
     */
    @Column(name = "is_table_call")
    private Integer isTableCall;

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
     * 获取医院名
     *
     * @return corp_name - 医院名
     */
    public String getCorpName() {
        return corpName;
    }

    /**
     * 设置医院名
     *
     * @param corpName 医院名
     */
    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    /**
     * 获取区域名
     *
     * @return area - 区域名
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置区域名
     *
     * @param area 区域名
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
     * 获取修改
     *
     * @return gmt_modify - 修改
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * 设置修改
     *
     * @param gmtModify 修改
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * 获取区域名
     *
     * @return area_name - 区域名
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置区域名
     *
     * @param areaName 区域名
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 获取是否发布 1发布 0 未发布
     *
     * @return status - 是否发布 1发布 0 未发布
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置是否发布 1发布 0 未发布
     *
     * @param status 是否发布 1发布 0 未发布
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取该诊区支持的分诊模式 1 一次分诊 2 二次分诊
     *
     * @return service_mode - 该诊区支持的分诊模式 1 一次分诊 2 二次分诊
     */
    public Byte getServiceMode() {
        return serviceMode;
    }

    /**
     * 设置该诊区支持的分诊模式 1 一次分诊 2 二次分诊
     *
     * @param serviceMode 该诊区支持的分诊模式 1 一次分诊 2 二次分诊
     */
    public void setServiceMode(Byte serviceMode) {
        this.serviceMode = serviceMode;
    }

    /**
     * 获取该区域是否先签到进入队列 0签到进队列 1不签到进队列
     *
     * @return whether_confirm - 该区域是否先签到进入队列 0签到进队列 1不签到进队列
     */
    public Byte getWhetherConfirm() {
        return whetherConfirm;
    }

    /**
     * 设置该区域是否先签到进入队列 0签到进队列 1不签到进队列
     *
     * @param whetherConfirm 该区域是否先签到进入队列 0签到进队列 1不签到进队列
     */
    public void setWhetherConfirm(Byte whetherConfirm) {
        this.whetherConfirm = whetherConfirm;
    }

    /**
     * 获取该区域是否生成号源 0分诊生成号源，1排班生成号源
     *
     * @return create_num_source - 该区域是否生成号源 0分诊生成号源，1排班生成号源
     */
    public Byte getCreateNumSource() {
        return createNumSource;
    }

    /**
     * 设置该区域是否生成号源 0分诊生成号源，1排班生成号源
     *
     * @param createNumSource 该区域是否生成号源 0分诊生成号源，1排班生成号源
     */
    public void setCreateNumSource(Byte createNumSource) {
        this.createNumSource = createNumSource;
    }

    /**
     * 获取是否使用诊室排班 0 不使用，1使用
     *
     * @return use_diag_room_scheduling - 是否使用诊室排班 0 不使用，1使用
     */
    public Byte getUseDiagRoomScheduling() {
        return useDiagRoomScheduling;
    }

    /**
     * 设置是否使用诊室排班 0 不使用，1使用
     *
     * @param useDiagRoomScheduling 是否使用诊室排班 0 不使用，1使用
     */
    public void setUseDiagRoomScheduling(Byte useDiagRoomScheduling) {
        this.useDiagRoomScheduling = useDiagRoomScheduling;
    }

    /**
     * 获取候诊区地址
     *
     * @return address - 候诊区地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置候诊区地址
     *
     * @param address 候诊区地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取院区详情
     *
     * @return detail - 院区详情
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置院区详情
     *
     * @param detail 院区详情
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * 获取区域类型 0：门诊 1：急诊
     *
     * @return corp_area_type - 区域类型 0：门诊 1：急诊
     */
    public Byte getCorpAreaType() {
        return corpAreaType;
    }

    /**
     * 设置区域类型 0：门诊 1：急诊
     *
     * @param corpAreaType 区域类型 0：门诊 1：急诊
     */
    public void setCorpAreaType(Byte corpAreaType) {
        this.corpAreaType = corpAreaType;
    }

    /**
     * 获取诊区媒体资源
     *
     * @return media - 诊区媒体资源
     */
    public String getMedia() {
        return media;
    }

    /**
     * 设置诊区媒体资源
     *
     * @param media 诊区媒体资源
     */
    public void setMedia(String media) {
        this.media = media;
    }

    /**
     * 获取护士台预检呼叫功能 0 无，1有
     *
     * @return is_nurse_call - 护士台预检呼叫功能 0 无，1有
     */
    public Integer getIsNurseCall() {
        return isNurseCall;
    }

    /**
     * 设置护士台预检呼叫功能 0 无，1有
     *
     * @param isNurseCall 护士台预检呼叫功能 0 无，1有
     */
    public void setIsNurseCall(Integer isNurseCall) {
        this.isNurseCall = isNurseCall;
    }

    /**
     * 获取是否有叫号到诊台功能，0 没有，1有
     *
     * @return is_table_call - 是否有叫号到诊台功能，0 没有，1有
     */
    public Integer getIsTableCall() {
        return isTableCall;
    }

    /**
     * 设置是否有叫号到诊台功能，0 没有，1有
     *
     * @param isTableCall 是否有叫号到诊台功能，0 没有，1有
     */
    public void setIsTableCall(Integer isTableCall) {
        this.isTableCall = isTableCall;
    }
}