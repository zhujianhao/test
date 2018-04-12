package com.dao;

import com.yuantu.client.result.bo.BedSimpleDO;
import com.yuantu.client.result.bo.queuePatientNumber.Doct;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class WardInfo implements Serializable{

    private static final long serialVersionUID = 1L;
    private Long ID;
    private String wardNo;//病房编号
    private String areaNo;//病区编号
    private String areaName;//病区名称
    private String deptNo;//科室编号
    private String deptName;//科室名称
    private String corpId;//医院编号
    private String corpUnionId;//医联体编号
    private String wardType;//病房类型 普通
    private String bedPrice;// 100元/天
    private String address;// 住院部1栋7F
    private List<String> chargeDoctNames;//主治医师11,12
    private List<String> chargeNurseNames;//责任护士21,22
    //    private List<String> onDutyDoctNames;//值班医师31,32
//    private List<String> onDutyNurseNames;//41,42
    private List<String> bedNos;//床位编号 10,11,12,13
    private List<Doct> chargeDoctList;//主治医师列表
    //    private List<Doct> onDutyDoctList;//值班医师列表
    private List<String> patientIdList;//住院患者id列表
    private List<BedSimpleDO> bedList;//床位列表
}
