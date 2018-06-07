package com.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "device_info")
public class DeviceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 分诊的区域编码
     */
    private String area;

    @Column(name = "device_nick")
    private String deviceNick;

    /**
     * 设备类型
     */
    @Column(name = "device_type")
    private String deviceType;

    /**
     * 设备的显示类型
     */
    @Column(name = "device_view_type")
    private String deviceViewType;

    /**
     * 设备对应队列编码，可能有多个
     */
    @Column(name = "queue_code")
    private String queueCode;

    /**
     * 设备对应队列名称 可能有多个
     */
    @Column(name = "queue_name")
    private String queueName;

    /**
     * 设备对应地址
     */
    @Column(name = "diag_room")
    private String diagRoom;

    /**
     * 医院编码
     */
    @Column(name = "corp_id")
    private String corpId;

    /**
     * 屏对应的密码
     */
    @Column(name = "device_secret")
    private String deviceSecret;

    /**
     * 屏幕对应的mac 地址
     */
    @Column(name = "device_mac")
    private String deviceMac;

    /**
     * 照片地址
     */
    @Column(name = "device_img")
    private String deviceImg;

    /**
     * 屏幕状态,默认未启动
     */
    private Integer status;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modify")
    private Date gmtModify;

    /**
     * 设备上次心跳时间
     */
    @Column(name = "last_heartbeat_time")
    private Date lastHeartbeatTime;

    private String token;

    /**
     * 同批设备序号
     */
    private Byte serial;

    /**
     * 是否默认科室的设备
     */
    @Column(name = "is_default")
    private Boolean isDefault;

    /**
     * 版本号
     */
    @Column(name = "version_num")
    private Long versionNum;

    /**
     * 设备编号
     */
    @Column(name = "device_no")
    private String deviceNo;

    /**
     * 设备语音播放速率
     */
    private Integer rate;

    /**
     * 大屏展示行数
     */
    private Integer rows;

    /**
     * 大屏提示语
     */
    private String advertise;

    /**
     * 医联体编号
     */
    @Column(name = "union_id")
    private String unionId;

    /**
     * 床位编号
     */
    @Column(name = "bed_no")
    private String bedNo;

    /**
     * 友盟推送token
     */
    @Column(name = "push_token")
    private String pushToken;

    /**
     * 设备配置信息  json
     */
    @Column(name = "config_json")
    private String configJson;

    /**
     * 分诊区域名称
     */
    @Column(name = "area_name")
    private String areaName;

    /**
     * 大屏展示起始行
     */
    @Column(name = "row_start")
    private Byte rowStart;

    /**
     * 大屏展示结束行
     */
    @Column(name = "row_end")
    private Byte rowEnd;

    /**
     * 护士站语音播放
     */
    private String voice;

    /**
     * 护士站语音播放次数
     */
    @Column(name = "voice_times")
    private Byte voiceTimes;

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
     * 获取分诊的区域编码
     *
     * @return area - 分诊的区域编码
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置分诊的区域编码
     *
     * @param area 分诊的区域编码
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return device_nick
     */
    public String getDeviceNick() {
        return deviceNick;
    }

    /**
     * @param deviceNick
     */
    public void setDeviceNick(String deviceNick) {
        this.deviceNick = deviceNick;
    }

    /**
     * 获取设备类型
     *
     * @return device_type - 设备类型
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * 设置设备类型
     *
     * @param deviceType 设备类型
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * 获取设备的显示类型
     *
     * @return device_view_type - 设备的显示类型
     */
    public String getDeviceViewType() {
        return deviceViewType;
    }

    /**
     * 设置设备的显示类型
     *
     * @param deviceViewType 设备的显示类型
     */
    public void setDeviceViewType(String deviceViewType) {
        this.deviceViewType = deviceViewType;
    }

    /**
     * 获取设备对应队列编码，可能有多个
     *
     * @return queue_code - 设备对应队列编码，可能有多个
     */
    public String getQueueCode() {
        return queueCode;
    }

    /**
     * 设置设备对应队列编码，可能有多个
     *
     * @param queueCode 设备对应队列编码，可能有多个
     */
    public void setQueueCode(String queueCode) {
        this.queueCode = queueCode;
    }

    /**
     * 获取设备对应队列名称 可能有多个
     *
     * @return queue_name - 设备对应队列名称 可能有多个
     */
    public String getQueueName() {
        return queueName;
    }

    /**
     * 设置设备对应队列名称 可能有多个
     *
     * @param queueName 设备对应队列名称 可能有多个
     */
    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    /**
     * 获取设备对应地址
     *
     * @return diag_room - 设备对应地址
     */
    public String getDiagRoom() {
        return diagRoom;
    }

    /**
     * 设置设备对应地址
     *
     * @param diagRoom 设备对应地址
     */
    public void setDiagRoom(String diagRoom) {
        this.diagRoom = diagRoom;
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
     * 获取屏对应的密码
     *
     * @return device_secret - 屏对应的密码
     */
    public String getDeviceSecret() {
        return deviceSecret;
    }

    /**
     * 设置屏对应的密码
     *
     * @param deviceSecret 屏对应的密码
     */
    public void setDeviceSecret(String deviceSecret) {
        this.deviceSecret = deviceSecret;
    }

    /**
     * 获取屏幕对应的mac 地址
     *
     * @return device_mac - 屏幕对应的mac 地址
     */
    public String getDeviceMac() {
        return deviceMac;
    }

    /**
     * 设置屏幕对应的mac 地址
     *
     * @param deviceMac 屏幕对应的mac 地址
     */
    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    /**
     * 获取照片地址
     *
     * @return device_img - 照片地址
     */
    public String getDeviceImg() {
        return deviceImg;
    }

    /**
     * 设置照片地址
     *
     * @param deviceImg 照片地址
     */
    public void setDeviceImg(String deviceImg) {
        this.deviceImg = deviceImg;
    }

    /**
     * 获取屏幕状态,默认未启动
     *
     * @return status - 屏幕状态,默认未启动
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置屏幕状态,默认未启动
     *
     * @param status 屏幕状态,默认未启动
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
     * 获取设备上次心跳时间
     *
     * @return last_heartbeat_time - 设备上次心跳时间
     */
    public Date getLastHeartbeatTime() {
        return lastHeartbeatTime;
    }

    /**
     * 设置设备上次心跳时间
     *
     * @param lastHeartbeatTime 设备上次心跳时间
     */
    public void setLastHeartbeatTime(Date lastHeartbeatTime) {
        this.lastHeartbeatTime = lastHeartbeatTime;
    }

    /**
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取同批设备序号
     *
     * @return serial - 同批设备序号
     */
    public Byte getSerial() {
        return serial;
    }

    /**
     * 设置同批设备序号
     *
     * @param serial 同批设备序号
     */
    public void setSerial(Byte serial) {
        this.serial = serial;
    }

    /**
     * 获取是否默认科室的设备
     *
     * @return is_default - 是否默认科室的设备
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     * 设置是否默认科室的设备
     *
     * @param isDefault 是否默认科室的设备
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 获取版本号
     *
     * @return version_num - 版本号
     */
    public Long getVersionNum() {
        return versionNum;
    }

    /**
     * 设置版本号
     *
     * @param versionNum 版本号
     */
    public void setVersionNum(Long versionNum) {
        this.versionNum = versionNum;
    }

    /**
     * 获取设备编号
     *
     * @return device_no - 设备编号
     */
    public String getDeviceNo() {
        return deviceNo;
    }

    /**
     * 设置设备编号
     *
     * @param deviceNo 设备编号
     */
    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    /**
     * 获取设备语音播放速率
     *
     * @return rate - 设备语音播放速率
     */
    public Integer getRate() {
        return rate;
    }

    /**
     * 设置设备语音播放速率
     *
     * @param rate 设备语音播放速率
     */
    public void setRate(Integer rate) {
        this.rate = rate;
    }

    /**
     * 获取大屏展示行数
     *
     * @return rows - 大屏展示行数
     */
    public Integer getRows() {
        return rows;
    }

    /**
     * 设置大屏展示行数
     *
     * @param rows 大屏展示行数
     */
    public void setRows(Integer rows) {
        this.rows = rows;
    }

    /**
     * 获取大屏提示语
     *
     * @return advertise - 大屏提示语
     */
    public String getAdvertise() {
        return advertise;
    }

    /**
     * 设置大屏提示语
     *
     * @param advertise 大屏提示语
     */
    public void setAdvertise(String advertise) {
        this.advertise = advertise;
    }

    /**
     * 获取医联体编号
     *
     * @return union_id - 医联体编号
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * 设置医联体编号
     *
     * @param unionId 医联体编号
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    /**
     * 获取床位编号
     *
     * @return bed_no - 床位编号
     */
    public String getBedNo() {
        return bedNo;
    }

    /**
     * 设置床位编号
     *
     * @param bedNo 床位编号
     */
    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }

    /**
     * 获取友盟推送token
     *
     * @return push_token - 友盟推送token
     */
    public String getPushToken() {
        return pushToken;
    }

    /**
     * 设置友盟推送token
     *
     * @param pushToken 友盟推送token
     */
    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    /**
     * 获取设备配置信息  json
     *
     * @return config_json - 设备配置信息  json
     */
    public String getConfigJson() {
        return configJson;
    }

    /**
     * 设置设备配置信息  json
     *
     * @param configJson 设备配置信息  json
     */
    public void setConfigJson(String configJson) {
        this.configJson = configJson;
    }

    /**
     * 获取分诊区域名称
     *
     * @return area_name - 分诊区域名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置分诊区域名称
     *
     * @param areaName 分诊区域名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 获取大屏展示起始行
     *
     * @return row_start - 大屏展示起始行
     */
    public Byte getRowStart() {
        return rowStart;
    }

    /**
     * 设置大屏展示起始行
     *
     * @param rowStart 大屏展示起始行
     */
    public void setRowStart(Byte rowStart) {
        this.rowStart = rowStart;
    }

    /**
     * 获取大屏展示结束行
     *
     * @return row_end - 大屏展示结束行
     */
    public Byte getRowEnd() {
        return rowEnd;
    }

    /**
     * 设置大屏展示结束行
     *
     * @param rowEnd 大屏展示结束行
     */
    public void setRowEnd(Byte rowEnd) {
        this.rowEnd = rowEnd;
    }

    /**
     * 获取护士站语音播放
     *
     * @return voice - 护士站语音播放
     */
    public String getVoice() {
        return voice;
    }

    /**
     * 设置护士站语音播放
     *
     * @param voice 护士站语音播放
     */
    public void setVoice(String voice) {
        this.voice = voice;
    }

    /**
     * 获取护士站语音播放次数
     *
     * @return voice_times - 护士站语音播放次数
     */
    public Byte getVoiceTimes() {
        return voiceTimes;
    }

    /**
     * 设置护士站语音播放次数
     *
     * @param voiceTimes 护士站语音播放次数
     */
    public void setVoiceTimes(Byte voiceTimes) {
        this.voiceTimes = voiceTimes;
    }
}