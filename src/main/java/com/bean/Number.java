package com.bean;

import java.util.Date;
import javax.persistence.*;

public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 排队序号，1001开始
     */
    private Integer orderno;

    /**
     * 排队日期
     */
    private Date queuedate;

    /**
     * 排队状态，0等候，1办理中，2已完成，3过号
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date modifytime;

    /**
     * 呼叫次数
     */
    private Integer calltime;

    /**
     * 对应窗口号
     */
    private Integer windowno;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取排队序号，1001开始
     *
     * @return orderno - 排队序号，1001开始
     */
    public Integer getOrderno() {
        return orderno;
    }

    /**
     * 设置排队序号，1001开始
     *
     * @param orderno 排队序号，1001开始
     */
    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    /**
     * 获取排队日期
     *
     * @return queuedate - 排队日期
     */
    public Date getQueuedate() {
        return queuedate;
    }

    /**
     * 设置排队日期
     *
     * @param queuedate 排队日期
     */
    public void setQueuedate(Date queuedate) {
        this.queuedate = queuedate;
    }

    /**
     * 获取排队状态，0等候，1办理中，2已完成，3过号
     *
     * @return status - 排队状态，0等候，1办理中，2已完成，3过号
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置排队状态，0等候，1办理中，2已完成，3过号
     *
     * @param status 排队状态，0等候，1办理中，2已完成，3过号
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取更新时间
     *
     * @return modifytime - 更新时间
     */
    public Date getModifytime() {
        return modifytime;
    }

    /**
     * 设置更新时间
     *
     * @param modifytime 更新时间
     */
    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    /**
     * 获取呼叫次数
     *
     * @return calltime - 呼叫次数
     */
    public Integer getCalltime() {
        return calltime;
    }

    /**
     * 设置呼叫次数
     *
     * @param calltime 呼叫次数
     */
    public void setCalltime(Integer calltime) {
        this.calltime = calltime;
    }

    /**
     * 获取对应窗口号
     *
     * @return windowno - 对应窗口号
     */
    public Integer getWindowno() {
        return windowno;
    }

    /**
     * 设置对应窗口号
     *
     * @param windowno 对应窗口号
     */
    public void setWindowno(Integer windowno) {
        this.windowno = windowno;
    }
}