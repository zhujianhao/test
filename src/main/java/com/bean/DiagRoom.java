package com.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "diag_room")
public class DiagRoom {
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
     * 诊室名
     */
    @Column(name = "diag_room")
    private String diagRoom;

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
     * 诊室code
     */
    @Column(name = "diag_room_code")
    private String diagRoomCode;

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
     * 诊室别名
     */
    @Column(name = "diag_room_alias")
    private String diagRoomAlias;

    /**
     * 所属大屏nick
     */
    @Column(name = "device_nick")
    private String deviceNick;

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

    /**
     * 获取诊室别名
     *
     * @return diag_room_alias - 诊室别名
     */
    public String getDiagRoomAlias() {
        return diagRoomAlias;
    }

    /**
     * 设置诊室别名
     *
     * @param diagRoomAlias 诊室别名
     */
    public void setDiagRoomAlias(String diagRoomAlias) {
        this.diagRoomAlias = diagRoomAlias;
    }

    /**
     * 获取所属大屏nick
     *
     * @return device_nick - 所属大屏nick
     */
    public String getDeviceNick() {
        return deviceNick;
    }

    /**
     * 设置所属大屏nick
     *
     * @param deviceNick 所属大屏nick
     */
    public void setDeviceNick(String deviceNick) {
        this.deviceNick = deviceNick;
    }
}