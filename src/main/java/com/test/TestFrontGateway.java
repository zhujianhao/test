package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yuantu.client.constant.HttpServiceName;
import com.yuantu.client.constant.ParamsKeyConstant;
import com.yuantu.client.security.ParamsUtil;
import com.yuantu.common.date.DateUtil;
import com.yuantu.common.result.Result;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.joda.time.DateTime;
import org.junit.Test;
import sun.java2d.pipe.SpanClipRenderer;
import sun.plugin.com.Packager;
import sun.security.krb5.internal.PAData;
import sun.util.calendar.BaseCalendar;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.SerializablePermission;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


//测试的cardNo : 0101103  cardType：2 deptCode:021607 patientId 7 hospitalCode:1000011272
public class TestFrontGateway {

    private String prodUrl="http://192.168.90.74:8980/frontgateway/gateway.do";
//    private String localUrl="http://192.168.90.65:8088/frontgateway/gateway.do";
    private String url="http://192.168.90.75:8090/frontgateway/gateway.do";
    private String localUrl="http://127.0.0.1:8080/frontgateway/gateway.do";
    private String localUrl2="http://127.0.0.1:8081/frontgateway/gateway.do";
    private String ngrok = "http://ngrok.yuantutech.com:3704/frontgateway/gateway.do";
    private String jfj = "http://ngrok.yuantutech.com:34655/frontgateway/gateway.do";
    private String lqUrl = "http://ngrok.yuantutech.com:32668/frontgateway/gateway.do";

    private String yuantutestUrl="http://121.40.253.119:8190/frontgateway/gateway.do";

    //建档8000726522
    @Test
    public void testSetPatient() throws IOException {
        Map<String,String> params = new HashMap();

        params.put("idType","1");
        params.put("operId","Z001");
        params.put("birthday", "1992-04-17");
        params.put("phone","13588888887");
        params.put("sex","男");
        params.put("sourceCode","ZZJ");
        params.put("deviceMac","00-FF-CE-BD-49-1D");
        params.put(ParamsKeyConstant.CARD_TYPE,"2");
        params.put("cardNo", "330127199402061619");
        params.put("deviceIp","192.168.2.11");
        params.put("nation","汉");
        params.put("name", "朱建浩");
        params.put("idNo", "330127199402061619");
      //  params.put("setupType","1");
        params.put("tradeTime","2017-03-03 10:10:00");
        params.put("extend", "");
        params.put("terminalNo", "001");
        params.put("accountNo", "");
        params.put("deviceInfo", "001");
        params.put("nation","汉");
        params.put("pwd", "123");
        params.put("address", "中国北京");
        params.put("service", "yuantu.wap.set.patient.info");
        params.put("patientType", "自费");
        params.put("flowId", "261ZZJ012017061612111050");
        params.put(ParamsKeyConstant.GUARDIAN_NAME,"ss");


        params.put(ParamsKeyConstant.HOSPITAL_ID,"210");
        params.put(ParamsKeyConstant.SERVICE, HttpServiceName.SetPatientInfo);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(params);
        String result = HttpClientUtils.post(lqUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }


   //查询可挂号的科室
   @Test
    public void testQueryDeptList() throws IOException {
       Map<String, String> sParaTemp = new HashMap();
       sParaTemp.put(ParamsKeyConstant.REG_MODE,"2");
       sParaTemp.put(ParamsKeyConstant.REG_TYPE,"1");
       sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
       sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
       sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
       sParaTemp.put("startDate","2018-12-21");
       sParaTemp.put("endDate","2018-20-21");
       sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryRegistrationDepList);
       Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
       String result = HttpClientUtils.post(url,sPara);
       JSONObject array= JSON.parseObject(result);
       System.out.print(result);
   }



    //根据科室ID获取科室/医生排班信息
    @Test
    public void testQueryRegistDept() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.REG_MODE,"2");
        sParaTemp.put(ParamsKeyConstant.REG_TYPE,"1");
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z016");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf(""));
        sParaTemp.put(ParamsKeyConstant.HIS_CODE, String.valueOf(""));
        sParaTemp.put(ParamsKeyConstant.DEPT_CODE,"2030");
        sParaTemp.put(ParamsKeyConstant.START_DATE,"2018-12-20");
        sParaTemp.put(ParamsKeyConstant.MED_DATE,"2018-12-20");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryRegistrationScheduleInfoList);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(url,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    //查询预约号源明细
    @Test
    public void queryRegistrationSources() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.REG_MODE,"1");
        sParaTemp.put(ParamsKeyConstant.SCHEDULE_ID,"64");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"ZZ01");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryRegistrationSources);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }



    //pass
    @Test
    public void testQueryDoct() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.DOCT_CODE,"0150");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QUERYHOSPITALALLDOC);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(prodUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }


    //pass
    @Test
    public void testPreReg() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"156");
        sParaTemp.put(ParamsKeyConstant.PATIENT_NAME,"测试账号20");
        sParaTemp.put(ParamsKeyConstant.DEPT_CODE,"020101");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"24");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"20150100113408");
        sParaTemp.put(ParamsKeyConstant.REG_TYPE,"1");
        sParaTemp.put(ParamsKeyConstant.SCHEDULE_ID,"69");
        sParaTemp.put(ParamsKeyConstant.SERVICE, "yuantu.wap.reg.pre.process");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
//        sParaTemp.put(ParamsKeyConstant.APPO_NO,"34");
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }


    //pass
    //查询所有科室

    @Test
    public void testQueryAllDept() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf(""));
        sParaTemp.put(ParamsKeyConstant.HIS_CODE, String.valueOf(""));
        sParaTemp.put(ParamsKeyConstant.DEPT_CODE,"020507");
        sParaTemp.put(ParamsKeyConstant.DEPT_TYPE,"1");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryHospitalDep);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(url,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    //pass
    //病人信息查询
    @Test
    public void testQueryPatient() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "210");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"ZZJ028");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"2");
        sParaTemp.put(ParamsKeyConstant.NAME,"童国联");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"330127199402061619");
        sParaTemp.put(ParamsKeyConstant.DEVICE_IP,"132.147.183.42");//  20150100065066
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryPatientInfo);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl2,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }



    @Test
    public void testOutpatientReadingCard() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "182");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"10");
        sParaTemp.put(ParamsKeyConstant.NAME,"童国联");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"");
        sParaTemp.put(ParamsKeyConstant.DEVICE_IP,"132.147.183.42");
        //  20150100065066
        sParaTemp.put(ParamsKeyConstant.SERVICE,"yuantu.wap.outpatient.reading.card");
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(jfj,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    //pass
    //查询收费条目
    @Test
    public void testQueryItemFee() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "9999");

        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryScheduleItemFee);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    //预交金充值
    @Test
    public void testChargeVirtSettlement() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "210");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE,"1000011272");
//        sParaTemp.put(ParamsKeyConstant.CARD_NO,"330127199402061619");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"21854");
        sParaTemp.put("sFlowId","00000000001");
//        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"2");
        sParaTemp.put(ParamsKeyConstant.TRADE_MODE,"CA");
        sParaTemp.put(ParamsKeyConstant.CASH,"1000");
        sParaTemp.put(ParamsKeyConstant.In_Hos,"1");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"ZZJ001");
        sParaTemp.put(ParamsKeyConstant.FLOW_ID,"1000000001");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.RechargeVirtualSettlement);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl2,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }


    //住院患者信息查询
    @Test
    public void testQueryInhosPatient() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "210");
//        sParaTemp.put(ParamsKeyConstant.CARD_NO,"330127199402061619");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"1900465");

//        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"2");
        sParaTemp.put(ParamsKeyConstant.In_Hos,"1");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"ZZJ001");
        sParaTemp.put(ParamsKeyConstant.FLOW_ID,"1000000001");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryInhosPatientInfo);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl2,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    //住院预交金充值
    @Test
    public void testChargeInhosVS() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "210");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE,"1000011272");
//        sParaTemp.put(ParamsKeyConstant.CARD_NO,"330127199402061619");
        sParaTemp.put(ParamsKeyConstant.PATIENT_HOS_NO,"21854");
        sParaTemp.put("sFlowId","00000000001");
//        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"2");
        sParaTemp.put(ParamsKeyConstant.TRADE_MODE,"CA");
        sParaTemp.put(ParamsKeyConstant.CASH,"1000");
        sParaTemp.put(ParamsKeyConstant.In_Hos,"1");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"ZZJ001");
        sParaTemp.put(ParamsKeyConstant.FLOW_ID,"1000000001");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.RechargeInhosVirtualSettlement);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl2,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }



    //pass
    //查询排班
    @Test
    public void testPlan() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZJJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.REG_MODE,"2");
        sParaTemp.put(ParamsKeyConstant.REG_TYPE,"1");
        sParaTemp.put(ParamsKeyConstant.START_DATE,"2018-07-19");
        sParaTemp.put(ParamsKeyConstant.END_DATE,"2018-07-19");
//        sParaTemp.put(ParamsKeyConstant.DEPT_CODE,"020801");
//        sParaTemp.put(ParamsKeyConstant.DOCT_CODE,"1127");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf("1000011274"));
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryRegistrationScheduleInfoList);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

   // {terminalNo=Z001, corpId=2001, endDate=, channel=2, operId=Z001, corpCode=1000011272, deviceInfo=Z001, branchCode=1000011272, doctCode=, schResultId=12, intervalFlag=1, regMode=2, regType=OT00124, flowId=Z0012017122501689000026, deptCode=021607, startDate=}
    //挂号/预约
    @Test
    public void testAppoinmentOrRegistration() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
//0101103
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"0101186");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"2");

        sParaTemp.put(ParamsKeyConstant.REG_MODE,"1");
        sParaTemp.put(ParamsKeyConstant.REG_TYPE,"1");
        //就诊日期
        sParaTemp.put(ParamsKeyConstant.MED_DATE,"2018-01-16");

        //就诊时间
        sParaTemp.put(ParamsKeyConstant.MED_TIME,"17:00");
        sParaTemp.put(ParamsKeyConstant.SCHEDULE_ID,"64");
        sParaTemp.put(ParamsKeyConstant.MED_AMPM,"2");
        sParaTemp.put(ParamsKeyConstant.APPO_NO,"474");

        //支付方式CA:现金 MIC：医保 ZFB：支付宝 WX：微信 OC：卡内账户/结算账户
        sParaTemp.put(ParamsKeyConstant.TRADE_MODE,"WX");
        sParaTemp.put(ParamsKeyConstant.ACCOUNT_NO,"33333333122");
        sParaTemp.put(ParamsKeyConstant.VERSION,"2");
        sParaTemp.put(ParamsKeyConstant.CASH,"5000");
        sParaTemp.put(ParamsKeyConstant.DIS_COUNT_FEE,"10");
        sParaTemp.put(ParamsKeyConstant.OUT_TRADE_NO,"Z0001test");
        sParaTemp.put("discountFlag","0");
        sParaTemp.put("discountDesc","残疾人");
        sParaTemp.put("operId","ZZ01");
        sParaTemp.put(ParamsKeyConstant.FLOW_ID,"1000127");
        sParaTemp.put("regFlowId","20180528ZZ010005 ");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.AppointmentOrRegistration);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    //预约取号
    @Test
    public void testTakeRegistNo() throws IOException {
        Map<String, String> sParaTemp = JSON.parseObject("{\"patientId\":\"1712255585\",\"cardType\":\"2\",\"cardNo\":\"15959899\",\"appoNo\":null,\"medDate\":\"2017-12-26\",\"scheduleId\":\"17\",\"medAmPm\":\"2\",\"tradeMode\":\"DB\",\"tradeModeList\":null,\"accountNo\":\"1712255585\",\"cash\":\"50\",\"posTransNo\":null,\"bankTransNo\":null,\"bankDate\":null,\"bankTime\":null,\"bankSettlementTime\":null,\"bankCardNo\":null,\"posIndexNo\":null,\"sellerAccountNo\":null,\"searchType\":null,\"transNo\":null,\"invoice\":null,\"clinicres\":null,\"orderNo\":\"112276\",\"ybInfo\":null,\"payAccountNo\":null,\"outTradeNo\":null,\"service\":\"yuantu.wap.take.registration.no" +

                "\",\"hospitalId\":\"2001\",\"operId\":\"Z001\",\"tradeTime\":\"2017-12-26 19:01:34\",\"flowId\":\"Z0012017122601689000348\",\"hospCode\":\"\",\"sourceCode\":\"ZZJ\",\"deviceInfo\":\"Z001\",\"terminalNo\":\"Z001\",\"extend\":\"{\\\"version\\\":\\\"1\\\",\\\"payStatus\\\":\\\"200\\\"}\",\"deviceMac\":\"00-0E-C4-D3-99-06\",\"deviceIp\":\"10.8.10.147" +

                "\",\"deviceVersion\":\"YT-550\",\"fundCustodian\":\"\"}",Map.class);

        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    //取消预约
    @Test
    public void testCancelRegistration() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE,"1000011272");
//        sParaTemp.put(ParamsKeyConstant.REG_TYPE,"1");
        sParaTemp.put(ParamsKeyConstant.REG_MODE,"1");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"0101185");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"ZZ01");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"2");
        sParaTemp.put(ParamsKeyConstant.ORDER_NO,"18187");
        sParaTemp.put("regFlowId","32");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.CancelAppointmentOrRegistration);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }


    //查询挂号预约记录18187
    @Test
    public void testQueryRegistrationRecord() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE,"1000011272");
       //sParaTemp.put(ParamsKeyConstant.SEARCH_TYPE,"2");
        sParaTemp.put(ParamsKeyConstant.SEARCH_TYPE,"1");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"0101186");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"2");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"ZZ01");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryAppointmentAndRegistrationRecord);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    //获取待缴费概要信息
    @Test
    public void testQueryWaitBalanceInfo() throws IOException, ParseException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "210");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE,"1000011272");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"100296");
        sParaTemp.put(ParamsKeyConstant.TRADE_TIME, DateUtil.yyyy_MM_dd_HH_mm_ss_Format.format(new Date()));
        sParaTemp.put(ParamsKeyConstant.BILL_TYPE,"");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"330127199402061619");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"2");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"ZZJ001");
        sParaTemp.put(ParamsKeyConstant.START_DATE,"2019-01-14");
        sParaTemp.put(ParamsKeyConstant.END_DATE,"2019-01-14");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryWaitBalanceBillList);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl2,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }



    //缴费预结算
    @Test
    public void testPrePayBill() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "210");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"ZZJ001");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE,"1000011272");
//        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"20180602003");
        sParaTemp.put(ParamsKeyConstant.BILL_NO,"1133654|1133663|0408259");
//        sParaTemp.put(ParamsKeyConstant.BILL_TYPE,"");
        sParaTemp.put(ParamsKeyConstant.REG_ID,"f1a473c1-f6a4-46a0-b595-a9c30159b061");
        sParaTemp.put(ParamsKeyConstant.TRADE_MODE,"WX");
        sParaTemp.put(ParamsKeyConstant.BILL_ITEM,"");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"330127199402061619");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"100296");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"2");
        sParaTemp.put(ParamsKeyConstant.FLOW_ID,"10000000000010");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.PreBalanceBill);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl2,sPara);
        JSONObject array= JSON.parseObject(result);

        System.out.print(result);
    }


    //缴费预结算解锁
    @Test
    public void testUnlockPrePayBill() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE,"1000011272");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"8000726542");
        sParaTemp.put(ParamsKeyConstant.RECEIPT_NO,"20180628Z0010003");
        sParaTemp.put(ParamsKeyConstant.ACCOUNT_NO,"20180628Z0010003");
//        sParaTemp.put(ParamsKeyConstant.BILL_TYPE,"");
        sParaTemp.put(ParamsKeyConstant.TRADE_MODE,"CA");
//        sParaTemp.put("hzinputdata", "20181231135836-1012-5053^1^1012|13528074|T20181231-4709|T20181231-4709|1|20181231135700080327|20181231135836-1012-5053|86.2|0.0|86.2|86.2|86.2|0.0|0.0|0.0|0.0|0.0|0.0|2394.65|0|0.0|0.0|0.0|711.42|20181231135722|20181230214420-1012-00009000-8075|201812311358368599|0.0|0.0|0.0|0.0|0.0|0.0|0.0|86.2||0.0|0.0|0.0|0.0|86.2|0.0|0.0|0.0|0.0|0.0|0.0|0.0|^");
        sParaTemp.put(ParamsKeyConstant.BILL_ITEM,"");
        sParaTemp.put(ParamsKeyConstant.CASH,"23051");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"330127199402061619");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"2");
        sParaTemp.put(ParamsKeyConstant.FLOW_ID,"10000000000010");
        sParaTemp.put(ParamsKeyConstant.SERVICE, "yuantu.wap.unlock.balance.bill");
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(url,sPara);
        JSONObject array= JSON.parseObject(result);

        System.out.print(result);
    }
    //缴费结算
    @Test
    public void testPayBill() throws IOException {
        Map<String, String> sParaTemp = new HashMap();

//        sParaTemp.put(ParamsKeyConstant.OPER_ID,"810001");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"ZZJ001");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "210");

        sParaTemp.put(ParamsKeyConstant.HOSP_CODE,"1000011272");
        sParaTemp.put(ParamsKeyConstant.CASH,"23051");
        sParaTemp.put(ParamsKeyConstant.SELF_FEE,"23051");

        sParaTemp.put(ParamsKeyConstant.ALL_SELF,"1");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"330127199402061619");

        sParaTemp.put(ParamsKeyConstant.ACCOUNT_NO,"20180628Z0010003");
        sParaTemp.put(ParamsKeyConstant.BILL_NO,"1133654|1133663|0408259" );
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"100296");
//        sParaTemp.put(ParamsKeyConstant.BILL_TYPE,"");
        sParaTemp.put(ParamsKeyConstant.REG_ID,"f1a473c1-f6a4-46a0-b595-a9c30159b061");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"2");
        sParaTemp.put(ParamsKeyConstant.TRADE_TIME,DateUtil.yyyy_MM_dd_HH_mm_ss_Format.format(new Date()));
//        sParaTemp.put("payAcount","705342");
        sParaTemp.put(ParamsKeyConstant.TRADE_MODE,"CA");
        sParaTemp.put("hzinputdata","20181231135836-1012-5053^1^1012|13528074|T20181231-4709|T20181231-4709|1|20181231135700080327|20181231135836-1012-5053|86.2|0.0|86.2|86.2|86.2|0.0|0.0|0.0|0.0|0.0|0.0|2394.65|0|0.0|0.0|0.0|711.42|20181231135722|20181230214420-1012-00009000-8075|201812311358368599|0.0|0.0|0.0|0.0|0.0|0.0|0.0|86.2||0.0|0.0|0.0|0.0|86.2|0.0|0.0|0.0|0.0|0.0|0.0|0.0|^");
        sParaTemp.put(ParamsKeyConstant.TRANS_NO,"210803151659001");
        sParaTemp.put(ParamsKeyConstant.BILL_ITEM,"");

        sParaTemp.put(ParamsKeyConstant.FLOW_ID,"10000000000013");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.BalanceAndPayBill);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl2,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }
    //缴费记录查询
    @Test
    public void testBalanceBillRecord() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "204");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"001342590");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"2");
        sParaTemp.put(ParamsKeyConstant.START_DATE,"2019-01-01");
        sParaTemp.put(ParamsKeyConstant.END_DATE,"2019-01-19");
        sParaTemp.put(ParamsKeyConstant.ORDER_ID,"ZZJ001");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryBillBalanceAndPaySummaryRecord);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl2,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    @Test
    public void testLocal() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "9999");
//        sParaTemp.put(ParamsKeyConstant.OPER_ID,"0006");
//        sParaTemp.put(ParamsKeyConstant.HOSP_CODE,"1000011272");
//        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"1712165544");
////        sParaTemp.put(ParamsKeyConstant.BILL_NO,"");
////        sParaTemp.put(ParamsKeyConstant.BILL_TYPE,"");
//        sParaTemp.put(ParamsKeyConstant.CASH,"114.86");
//        sParaTemp.put(ParamsKeyConstant.TRADE_MODE,"WX");
//        sParaTemp.put(ParamsKeyConstant.BILL_ITEM,"");
//        sParaTemp.put(ParamsKeyConstant.CARD_NO,"0101104");
//        sParaTemp.put(ParamsKeyConstant.ACCOUNT_NO,"0101104");
//        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"2");
//        sParaTemp.put(ParamsKeyConstant.FLOW_ID,"10000000000009");
//        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.BalanceAndPayBill);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(yuantutestUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }


    @Test
    public void testWard() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.AREA_CODE,"030102");
        sParaTemp.put(ParamsKeyConstant.SERVICE,HttpServiceName.QueryInhosWardInfo);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(prodUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    @Test
    public void testWardItem() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.AREA_CODE,"030107");
        sParaTemp.put(ParamsKeyConstant.WARD_NO,"702");
        sParaTemp.put(ParamsKeyConstant.SERVICE,HttpServiceName.QueryInhosWardInfoItem);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(url,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    //pass
    //查询排班
    @Test
    public void testQueryAllPlan() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.REG_MODE,"1");
//        sParaTemp.put(ParamsKeyConstant.SCHEDULE_ID,"1");
        sParaTemp.put("startDate","2017-04-17");
        sParaTemp.put("endDate","2018-04-19");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf("1000011274"));
        sParaTemp.put(ParamsKeyConstant.SERVICE,"yuantu.wap.query.all.schedule.list");
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(url,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }



    //pass
    //创建扫码订单
    @Test
    public void testCreatOrder() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "182");
        sParaTemp.put("optType","1");
        sParaTemp.put("subject","挂号");
        sParaTemp.put("feeChannel","20");
        sParaTemp.put("fee","10");
        sParaTemp.put("outId","1000111111");
        sParaTemp.put("patientId","100296");
        sParaTemp.put("patientName","sss");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
        sParaTemp.put(ParamsKeyConstant.DEVICE_INFO,"ss");
//        sParaTemp.put(ParamsKeyConstant.SCHEDULE_ID,"1");
        sParaTemp.put(ParamsKeyConstant.SERVICE,"yuantu.wap.sao.ma.create.order");

        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(jfj,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }


    //订单状态查询
    @Test
    public void testQueryOrderStatus() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "210");
        sParaTemp.put(ParamsKeyConstant.OUT_TRADE_NO,"2019011111440000013");

        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
//        sParaTemp.put(ParamsKeyConstant.SCHEDULE_ID,"1");
        sParaTemp.put(ParamsKeyConstant.SERVICE,"yuantu.wap.sao.ma.query.order");

        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl2,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }


    //订单状态上传
    @Test
    public void testUploadOrderStatus() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "210");
        sParaTemp.put(ParamsKeyConstant.OUT_TRADE_NO,"2019011111320400012");

        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
//        sParaTemp.put(ParamsKeyConstant.SCHEDULE_ID,"1");
        sParaTemp.put(ParamsKeyConstant.STATUS,"101");
        sParaTemp.put(ParamsKeyConstant.SERVICE,"yuantu.wap.sao.ma.success.order");

        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl2,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }
    //pass
    //查询结算记录
    @Test
    public void testBalanceRecorde() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, "1000011272");
        sParaTemp.put("startDate","2018-06-03");
        sParaTemp.put("endDate","2018-06-05");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"20180602003");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"41");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
        sParaTemp.put(ParamsKeyConstant.SERVICE,HttpServiceName.QueryBillBalanceAndPaySummaryRecord);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    //pass
    //查询医生
    @Test
    public void testAllDoc() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf("1000011272"));
        sParaTemp.put(ParamsKeyConstant.DEPT_CODE,"021101");
        sParaTemp.put(ParamsKeyConstant.DOCT_CODE,"1127");
        sParaTemp.put(ParamsKeyConstant.SERVICE,HttpServiceName.QUERYHOSPITALALLDOC);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

//根据卡面号获取用户信息；
    @Test
    public void setGetUserAccountBycard() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.UNION_ID,"3001");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf("1000011272"));
       sParaTemp.put(ParamsKeyConstant.CARD_NO,"20170100462448");
       sParaTemp.put(ParamsKeyConstant.PHONE,"18653230613");
       sParaTemp.put(ParamsKeyConstant.ID_NO,"120000199909234561");
       sParaTemp.put(ParamsKeyConstant.PATIENT_NAME,"五二儿");
        sParaTemp.put(ParamsKeyConstant.SERVICE,HttpServiceName.BingingPatientCard);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }


    //根据卡面号获取用户信息；
    @Test
    public void QueryPatientInfoVSCash() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.UNION_ID,"3001");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf("1000011272"));
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"20170100462489");
        sParaTemp.put(ParamsKeyConstant.PHONE,"18653230613");
        sParaTemp.put(ParamsKeyConstant.ID_NO,"120000201010102341");
        sParaTemp.put(ParamsKeyConstant.PATIENT_NAME,"王三");
        sParaTemp.put(ParamsKeyConstant.SERVICE,HttpServiceName.QueryPatientInfoVSCash);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(url,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }



    //对账查询
    @Test
    public void QueryTradeRecordOrder() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID,"2001");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf("1000011272"));
        sParaTemp.put(ParamsKeyConstant.START_TIME,"2018-12-12 00:00:00");
        sParaTemp.put(ParamsKeyConstant.END_TIME,"2018-12-12 23:59:59");
        sParaTemp.put(ParamsKeyConstant.CURRENTPAGE,"1");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z016");
        sParaTemp.put(ParamsKeyConstant.SERVICE,HttpServiceName.QueryHisTradeRecord);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.println(result);
    }

  

    //退费；
    @Test
    public void foundBack() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "HIS");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID,"2001");
        sParaTemp.put(ParamsKeyConstant.DEVICE_INFO,"ZZJ001");
        sParaTemp.put(ParamsKeyConstant.TERMINAL_NO,"ZZJ001");

        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
        sParaTemp.put(ParamsKeyConstant.DEVICE_MAC,"00-FF-CE-BD-49-1D");
        sParaTemp.put(ParamsKeyConstant.DEVICE_IP,"192.168.2.11");
        sParaTemp.put(ParamsKeyConstant.TRADE_TIME,"2018-03-18 10:10:00");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf("1000011274"));
        sParaTemp.put(ParamsKeyConstant.FLOW_ID,"1111111111111116");


        sParaTemp.put(ParamsKeyConstant.OUT_TRADE_NO,"01020010120190118114749938948964");
        sParaTemp.put("outRefundNo","T00000000000000111176");
        sParaTemp.put("fee","50");
        sParaTemp.put("reason","50元");

        sParaTemp.put(ParamsKeyConstant.SERVICE,HttpServiceName.BackFeeUserCash);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        System.out.println(JSON.toJSONString(sPara));
        String result = HttpClientUtils.post(url,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }


    @Test
    public void testUpdatePatient() throws IOException {
        String s="{\"patientId\":\"1802020011\",\"cardNo\":\"20170100462522\",\"type\":\"\",\"startDate\":\"2018-02-22\",\"endDate\":\"2018-03-02\",\"service\":\"yuantu.wap.query.receipt.log.list\",\"hospitalId\":\"2001\",\"operId\":\"Z001\",\"tradeTime\":\"2018-03-01 17:23:10\",\"flowId\":\"Z0012018030101689000042\",\"hospCode\":\"\",\"sourceCode\":\"ZZJ\",\"deviceInfo\":\"Z001\",\"terminalNo\":\"Z001\",\"extend\":null,\"deviceMac\":\"00-0E-C4-D3-99-06\",\"deviceIp\":\"10.8.10.147 \n" +
                "\n" +
                "\",\"deviceVersion\":\"YT-550\",\"fundCustodian\":\"\"}";
        Map map=JSON.parseObject(s,Map.class);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(map);
        String result = HttpClientUtils.post(url,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);

    }

    @Test
    public void test() throws IOException {
        String s = "{\n" +
                "    \"operId\": \"YT-550\",\n" +
                "    \"sourceCode\": \"ZZJ\",\n" +
                "    \"tradeTime\": \"2017-04-21 10:37:14\",\n" +
                "    \"sign_type\": \"RSA\",\n" +
                "    \"terminalNo\": \"YT-550\",\n" +
                "    \"hospitalId\": \"150\",\n" +
                "    \"deviceMac\": \"00-50-C2-29-26-C6\",\n" +
                "    \"deviceInfo\": \"ZZJ001\",\n" +
                "    \"sign\": \"YeZUOosZwTceuM6xcEiYeaQP/Hx3zxHdXBTS5hnT4lUW6R/on5SQ7N/ROgH9Y2vFkWcfHsGQQJ2aUN164KtF9dndVv6++LDFbrTRoQOiNajFiIIF5NhtGYb75bikL15iS2p02K5nwyOMwgOfQWk6aiMM3a3dOTgg1sE5rqWdoWU=\",\n" +
                "    \"deviceIp\": \"172.18.4.221\",\n" +
                "    \"deviceNo\": \"YT-550\",\n" +
                "    \"deviceType\": \"YT-550\",\n" +
                "    \"service\": \"yuantu.wap.monitor.service\",\n" +
                "    \"hospCode\": \"3702011121\",\n" +
                "    \"deviceVersion\": \"YT-550\",\n" +
                "    \"method\": \"heart\",\n" +
                "    \"flowId\": \"ZZJ0012017042150726001870\"\n" +
                "}";

        Map map= JSON.parseObject(s,Map.class);
//        Document document = DocumentHelper.parseText(s);
//        Map map = XmlUtils.dom2Map(document.getRootElement());
////        JSONObject jsonObject = (JSONObject) JSON.toJSON(map);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(map);
        String result = HttpClientUtils.post("http://localhost:8084/InpatientServer/device/heart",map);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    @Test
    public void testQueryHisRegRecord() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.REG_MODE,"2");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf("1000011274"));
        sParaTemp.put("startTime","2018-05-04 00:00:00");
        sParaTemp.put("endTime","2018-06-24 00:00:00");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryJhRegRecord);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    @Test
    public void testReport() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "209");
        sParaTemp.put(ParamsKeyConstant.TYPE,"1");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"2");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"001342590");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"ZZJ001");
        sParaTemp.put(ParamsKeyConstant.TRADE_TIME,"2019-01-19 11:11:11");
        sParaTemp.put("startDate","2019-01-10");
        sParaTemp.put("endDate","2019-01-19");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf("1000011272"));
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryLisReport);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl2,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }
    @Test
    public void testQueryInhosPatientInfo() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "210");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"1900274");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"1");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"ZZJ001");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryInhosPatientInfo);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl2,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);

    }


    @Test
    public void testQueryInhosBillItem() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"19330");
        sParaTemp.put("startDate","2018-07-01");
        sParaTemp.put("endDate","2018-08-08");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryInhosBillItemList);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(prodUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    @Test
    public void testRechargeInhos() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"1726839");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
        sParaTemp.put(ParamsKeyConstant.CASH,"10000");
        sParaTemp.put("syxh","16");
        sParaTemp.put("jsxh","16");
        sParaTemp.put(ParamsKeyConstant.FLOW_ID,"ZZ0111111111111112");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.RechargeInhosVirtualSettlement);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    @Test
    public void tes() throws IOException, ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = simpleDateFormat.parse("20181212182521");
        String parseTime = DateUtil.fomart(date,"yyyy-MM-dd HH:mm:ss");
        System.out.println(parseTime);
    }

    @Test
    public void testQueryMedicine() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put("pinyinCode","");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryMedicinesInfo);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(url,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    @Test
    public void testBindingCard() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put("pinyinCode","AM");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.BingingPatientCard);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }



    //一日清单
    @Test
    public void testQueryInhosBillItemList() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "210");
        sParaTemp.put(ParamsKeyConstant.ID_NO,"0669");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"1900274");
        sParaTemp.put(ParamsKeyConstant.START_DATE,"2019-01-10");
        sParaTemp.put(ParamsKeyConstant.END_DATE,"2019-01-17");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"ZZJ001");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryInhosBillItemList);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl2,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }



    @Test
    public void regPreCharge() throws IOException {
        String s = "{\"cardType\":\"24\",\"cardNo\":\"20150100113408\",\"regDate\":null,\"regType\":\"1\",\"medAmPm\":\"3\",\"deptCode\":\"020101\",\"doctCode\":null,\"appoNo\":null,\"patientId\":\"100\",\"scheduleId\":\"69\",\"service\":\"yuantu.wap.reg.pre.process\",\"hospitalId\":\"2001\",\"operId\":\"Z001\",\"tradeTime\":\"2018-06-19 09:46:08\",\"flowId\":\"Z0012018061901689000007\",\"hospCode\":\"\",\"sourceCode\":\"ZZJ\",\"deviceInfo\":\"Z001\",\"terminalNo\":\"Z001\",\"extend\":null,\"deviceMac\":\"00-0E-C4-D3-99-06\",\"deviceIp\":\"10.8.10.147\",\"deviceVersion\":\"YT-550\",\"fundCustodian\":\"\"}";
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp = JSON.parseObject(s,Map.class);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    @Test
    public void testQueryPayAccount() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "9999");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
        sParaTemp.put(ParamsKeyConstant.DEVICE_INFO,"1111");
        sParaTemp.put(ParamsKeyConstant.SERVICE,"yuantu.wap.query.pay.account");
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    @Test
    public void testMedicine() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
        sParaTemp.put("takeWins","04");
        sParaTemp.put(ParamsKeyConstant.SERVICE,"yuantu.wap.query.take.medicine.patient");
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(url,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    @Test
    public void testTradeService() throws IOException {

        String s = "{\"sourceCode\":\"APP\",\"hospCode\":\"1000011274\",\"patientId\":\"19443\",\"endDate\":\"2018-12-27\",\"hospitalId\":\"2001\",\"service\":\"yuantu.wap.query.lis.report\",\"sign\":\"j0XhfyU71KXiltdh/jkKE9oiFCU9q09JHNPEqF9aLwHiIZfU2UBzQab+vY7Xl31k0MEm7aOxfQSATq1WXTk+5BexH5Wvy32u3eYjeN4Zd8sp364w2Q+h56Di49STxsn91frjVGFppc6DChUJu9r/hGp4JFW01853JK/F2cjE/Sc=\",\"operId\":\"Z016\",\"HisCode\":\"1000011274\",\"sign_type\":\"RSA\",\"startDate\":\"2018-12-20\"}";

        Map map = JSON.parseObject(s,Map.class);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(map);
        String result = HttpClientUtils.post(prodUrl,sPara);
        System.out.println(result);
        JSON.parseObject(s,Result.class);
    }



    @Test
    public void testaddExpess() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "9999");
        sParaTemp.put("pinyinCode","");
        sParaTemp.put(ParamsKeyConstant.SERVICE, "yuantu.wap.add.express.info");
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post("http://localhost:8081/frontgateway/gateway.do",sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

}
