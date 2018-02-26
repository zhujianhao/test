package com.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.dao.WardInfo;
import com.test.HttpClientUtils;
import com.yuantu.client.constant.HttpServiceName;
import com.yuantu.client.constant.ParamsKeyConstant;
import com.yuantu.client.result.bo.*;
import com.yuantu.client.result.bo.queuePatientNumber.Doct;
import com.yuantu.client.security.ParamsUtil;
import com.yuantu.common.lang.StringUtils;
import com.yuantu.common.result.Result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HisGateWay implements Serializable {



    public Map<String, String> initParam(){
        Map<String, String> sParaTemp = new HashMap<String, String>();

        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "BOX");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, String.valueOf(9999));
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf(""));
        sParaTemp.put(ParamsKeyConstant.HIS_CODE, String.valueOf(""));

        return sParaTemp;
    }
    public WardInfo getWardInfo(String wardNo){



        Map<String, String> sParaTemp = initParam();
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryInhosWardInfoItem);
        sParaTemp.put("wardNo", wardNo);
        sParaTemp.put("areaCode", "E3-ZYEK");



        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        //String sUrl = "http://localhost:8088/frontgateway/gateway.do?" ;
        //接口调用
        String sResult = PostToHis("http://121.40.253.119:8190/frontgateway/gateway.do", sPara, "病房信息查询");
        if(sResult.equals("")) {
            System.out.println("调用网关 病房信息查询接口出错，返回null,sysCorp is ");
            return null;
        }
        InhosWardInfoItemResultBO hisWardInfo ;
        try {
            hisWardInfo =   JSON.parseObject(sResult, new TypeReference<Result<InhosWardInfoItemResultBO>>() {}).getData();
        }catch(Exception e) {
            System.out.println(this.getClass() + "-JSONObject.parseObject error "+ "[sResult=" + sResult + "]"+ e);
            return null;
        }
        if(hisWardInfo == null){
            System.out.println("调用网关 病房信息查询接口 解析出错,sysCorp is ");
            return null;
        }
        WardInfo wardInfo = new WardInfo();
        wardInfo.setWardNo(hisWardInfo.getWardNo());
        wardInfo.setWardType(hisWardInfo.getWardType());
        wardInfo.setAreaNo(hisWardInfo.getAreaCode());
        wardInfo.setAreaName(hisWardInfo.getAreaName());
        wardInfo.setCorpId("9999");
        wardInfo.setCorpUnionId("29");
//        wardInfo.setDeptName();
//        wardInfo.setDeptNo();
        wardInfo.setAddress(hisWardInfo.getAddress());
        wardInfo.setBedList(hisWardInfo.getBedNoList());
        //根据his返回从排班取医生，科室信息组装好返回给前端
        List<Doct> chargeDoctList = new ArrayList<Doct>();
        List<String> chargeDoctNameList = new ArrayList<String>();
        List<String> chargeNurseNameList = new ArrayList<String>();
        List<String> patientIdList = new ArrayList<String>();
        if(hisWardInfo.getChargeDoctList()!= null && hisWardInfo.getChargeDoctList().size() > 0){
            for(DoctSimpleDO doct:hisWardInfo.getChargeDoctList()){
                if(StringUtils.isNotEmpty(doct.getDoctName())){
//                   // Doct doct1 = doctDubboService.getLatestSingleDoctByCode(Long.parseLong(deviceDO.getCorpId()),doct.getDoctCode());
//                    chargeDoctList.add(doct1);
//                    chargeDoctNameList.add(doct.getDoctName());
                }
            }
        }
        if(hisWardInfo.getChargeNurseList() != null && hisWardInfo.getChargeNurseList().size() > 0){
            for(NurseSimpleDO nurser:hisWardInfo.getChargeNurseList()){
                if(StringUtils.isNotEmpty(nurser.getNurseName())){
                    chargeNurseNameList.add(nurser.getNurseName());
                }
            }
        }
//        if(hisWardInfo.getOnDutyDoctList() != null && hisWardInfo.getOnDutyDoctList().size() > 0){
//            for(DoctSimpleDO doct:hisWardInfo.getOnDutyDoctList()){
//                if(StringUtils.isNotEmpty(doct.getDoctName())){
//                    Doct doct1 = doctDubboService.getDoctByCode(Long.parseLong(deviceDO.getCorpId()),null,doct.getDoctCode());
//                    dutyDoctList.add(doct1);
//                    dutyNameList.add(doct.getDoctName());
//                }
//            }
//        }
        if(hisWardInfo.getPatientList() != null && hisWardInfo.getPatientList().size() > 0){
            for(PatientSimpleDO patient:hisWardInfo.getPatientList()){
                if(StringUtils.isNotEmpty(patient.getPatientHosId())){
                    patientIdList.add(patient.getPatientHosId());
                }
            }
        }
        wardInfo.setPatientIdList(patientIdList);
        wardInfo.setChargeDoctList(null);
        wardInfo.setChargeDoctNames(chargeDoctNameList);
        wardInfo.setChargeNurseNames(chargeNurseNameList);
        if(hisWardInfo.getBedNoList() != null && hisWardInfo.getBedNoList().size() > 0){
            List<String> bedNos = new ArrayList<String >();
            for(BedSimpleDO bed:hisWardInfo.getBedNoList()){
                bedNos.add(bed.getBedNo());
                wardInfo.setBedPrice(bed.getBedPrice());
            }
            wardInfo.setBedNos(bedNos);
        }

        return wardInfo;
    }

    private String PostToHis(String sUrl,Map<String, String> sPara,String serviceName) {

        String sPrefix = "[网关接口]" + (StringUtils.isNotEmpty(serviceName) ? "[" + serviceName + "]":"");
        long time = System.currentTimeMillis();

        System.out.println(sPrefix + "请求报文,[sUrl=" + sUrl + ",sPara=" + sPara.toString() + "]");
        String sResult = "";
        try {
            sResult = HttpClientUtils.post(sUrl, sPara);
        } catch (Exception e) {
            System.out.println(sPrefix + "请求网关服务器异常,[sUrl=" + sUrl + ",sPara=" + sPara.toString() + "]"+e);
            return null;
        }
        System.out.println(sPrefix + "响应报文,[sUrl=" + sUrl + ",jsonResponse=" + sResult + "]");

        time = System.currentTimeMillis() - time;

        String param = "";
        if(sPara != null){
            param +=sPara;
        }

        System.out.println(sPrefix + "postToHis 请求网关,[serviceName=" + serviceName + ",param is ==> " + param  + ",time == > " + time);

        return sResult;
    }
}
