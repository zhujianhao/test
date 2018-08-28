package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.utils.XmlUtils;
import com.yuantu.client.constant.HttpServiceName;
import com.yuantu.client.constant.ParamsKeyConstant;
import com.yuantu.client.security.ParamsUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.joda.time.DateTime;
import org.junit.Test;
import sun.java2d.pipe.SpanClipRenderer;
import sun.util.calendar.BaseCalendar;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.SerializablePermission;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


//测试的cardNo : 0101103  cardType：2 deptCode:021607 patientId 7 hospitalCode:1000011272
public class TestFrontGateway {

    private String prodUrl="http://192.168.90.74:8980/frontgateway/gateway.do";
    //private String localUrl="http://192.168.90.65:8088/frontgateway/gateway.do";
    private String url="http://192.168.90.75:8090/frontgateway/gateway.do";
    private String localUrl="http://127.0.0.1:8081/frontgateway/gateway.do";

    private String yuantutestUrl="http://121.40.253.119:8190/frontgateway/gateway.do";

    //建档
    @Test
    public void testSetPatient() throws IOException {
        Map<String,String> params = new HashMap();

        params.put("idType","1");
        params.put("operId","Z001");
        params.put("birthday", "1992-04-17");
        params.put("phone","13588888887");
        params.put("sex","女");
        params.put("sourceCode","ZZJ");
        params.put("deviceMac","00-FF-CE-BD-49-1D");
        params.put(ParamsKeyConstant.CARD_TYPE,"24");
        params.put("cardNo", "1234567806");
        params.put("deviceIp","192.168.2.11");
        params.put("name", "测试账号20");
        params.put("tradeMode", "OC");
        params.put("idNo", "12");
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


        params.put(ParamsKeyConstant.HOSPITAL_ID,"2001");
        params.put(ParamsKeyConstant.SERVICE, HttpServiceName.SetPatientInfo);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(params);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }


   //查询可挂号的科室
   @Test
    public void testQueryDeptList() throws IOException {
       Map<String, String> sParaTemp = new HashMap();
       sParaTemp.put(ParamsKeyConstant.REG_MODE,"2");
       sParaTemp.put(ParamsKeyConstant.REG_TYPE,"1");
       sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZJJ");
       sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
       sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");

       sParaTemp.put("startDate","2018-08-13");
       sParaTemp.put("endDate","2018-08-13");
       sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryRegistrationDepList);
       Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
       String result = HttpClientUtils.post(prodUrl,sPara);
       JSONObject array= JSON.parseObject(result);
       System.out.print(result);
   }



    //根据科室ID获取科室/医生排班信息
    @Test
    public void testQueryRegistDept() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.REG_MODE,"2");
        sParaTemp.put(ParamsKeyConstant.REG_TYPE,"5");
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z016");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf(""));
        sParaTemp.put(ParamsKeyConstant.HIS_CODE, String.valueOf(""));
        sParaTemp.put(ParamsKeyConstant.DEPT_CODE,"020801");
        sParaTemp.put(ParamsKeyConstant.START_DATE,"2018-08-15");
        sParaTemp.put(ParamsKeyConstant.END_DATE,"2018-08-15");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryRegistrationScheduleInfoList);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
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
        //sParaTemp.put(ParamsKeyConstant.DEPT_CODE,"020101");
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
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"24");
        //  20150100065066
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"20150100142175");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryPatientInfo);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(url,sPara);
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
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE,"1000011272");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"20150100053699");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"24");
        sParaTemp.put(ParamsKeyConstant.TRADE_MODE,"CA");
        sParaTemp.put(ParamsKeyConstant.CASH,"1000");
        sParaTemp.put(ParamsKeyConstant.In_Hos,"1");
        sParaTemp.put(ParamsKeyConstant.ORDER_NO,"10000000002");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.RechargeVirtualSettlement);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
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
    public void testQueryWaitBalanceInfo() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE,"1000011272");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"20180602003");
        sParaTemp.put(ParamsKeyConstant.BILL_TYPE,"");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"20180602003");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"24");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryWaitBalanceBillList);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }



    //缴费预结算
    @Test
    public void testPrePayBill() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE,"1000011272");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"20180602003");
        sParaTemp.put(ParamsKeyConstant.BILL_NO,"107,108,109");
//        sParaTemp.put(ParamsKeyConstant.BILL_TYPE,"");
        sParaTemp.put(ParamsKeyConstant.TRADE_MODE,"ZFB");
        sParaTemp.put(ParamsKeyConstant.BILL_ITEM,"");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"20180602003");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"24");
        sParaTemp.put(ParamsKeyConstant.FLOW_ID,"10000000000010");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.PreBalanceBill);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
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
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"20180602003");
        sParaTemp.put(ParamsKeyConstant.RECEIPT_NO,"20180628Z0010003");
//        sParaTemp.put(ParamsKeyConstant.BILL_TYPE,"");
        sParaTemp.put(ParamsKeyConstant.TRADE_MODE,"ZFB");
        sParaTemp.put(ParamsKeyConstant.BILL_ITEM,"");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"20180602003");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"24");
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
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "APP");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE,"1000011272");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"4");
//        sParaTemp.put(ParamsKeyConstant.BILL_NO,"");
//        sParaTemp.put(ParamsKeyConstant.BILL_TYPE,"");
        sParaTemp.put(ParamsKeyConstant.CASH,"705342");
        sParaTemp.put("payAcount","705342");
        sParaTemp.put(ParamsKeyConstant.TRADE_MODE,"ZFB");
        sParaTemp.put(ParamsKeyConstant.TRANS_NO,"10000000000010");
        sParaTemp.put(ParamsKeyConstant.BILL_ITEM,"");
        sParaTemp.put(ParamsKeyConstant.BILL_NO,"20180604Z0010005");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"20180602003");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"24");
        sParaTemp.put(ParamsKeyConstant.FLOW_ID,"10000000000010");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.BalanceAndPayBill);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
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
        sParaTemp.put(ParamsKeyConstant.AREA_CODE,"030102");
        sParaTemp.put(ParamsKeyConstant.WARD_NO,"214");
        sParaTemp.put(ParamsKeyConstant.SERVICE,HttpServiceName.QueryInhosWardInfoItem);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(prodUrl,sPara);
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
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"24");
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


        sParaTemp.put(ParamsKeyConstant.OUT_TRADE_NO,"01020010120180824103052578538189");
        sParaTemp.put("outRefundNo","T00000000000000111133");
        sParaTemp.put("fee","50");
        sParaTemp.put("reason","温迪退挂号费50元");

        sParaTemp.put(ParamsKeyConstant.SERVICE,HttpServiceName.BackFeeUserCash);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        System.out.println(JSON.toJSONString(sPara));
        String result = HttpClientUtils.post(prodUrl,sPara);
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
        String s ="{\"deviceIp\":\"10.8.10.147\",\"deptName\":\"\",\"patientId\":\"227\",\"posTransNo\":\"\",\"sign\":\"beVLB2sqVp1kLQnvERf/gzwKu/OEqgi6C8m2JQcZVFXlsRnyuQj/JLM9P9SpfOeb0QLsyjHmq+rf4u66lUfg5/bxMyVMukM8AkaCjFW1rHAU4autWzBVbFce78HIbZpMlhb26RSQKGdeMlcmvz3IBZregYfndRQyRMWr17vrJSE=\",\"cardNo\":\"000006322021\",\"idNo\":\"\",\"sourceCode\":\"ZZJ\",\"regFlowId\":\"20180702Z0010005\",\"medDate\":\"\",\"deviceMac\":\"00-0E-C4-D3-99-06\",\"bankTime\":\"\",\"cash\":\"5000\",\"sign_type\":\"RSA\",\"scheduleId\":\"130\",\"terminalNo\":\"Z001\",\"bankDate\":\"\",\"payAccountNo\":\"\",\"bankCardNo\":\"\",\"doctName\":\"\",\"bankTransNo\":\"\",\"guarderId\":\"\",\"appoNo\":\"429\",\"deviceInfo\":\"Z001\",\"extend\":\"{\\\"version\\\":\\\"1\\\",\\\"isPayNow\\\":\\\"0\\\",\\\"regTypeYT\\\":\\\"1\\\",\\\"GetPersonInfo\\\":\\\"<?xml version=\\\\\\\"1.0\\\\\\\" encoding=\\\\\\\"UTF-16\\\\\\\" standalone=\\\\\\\"yes\\\\\\\"?>\\\\r\\\\n<root version=\\\\\\\"1.00.0408\\\\\\\"><state success=\\\\\\\"true\\\\\\\"></state><output><ic><card_no>000006322021</card_no><ic_no>00000632202S</ic_no><id_no>999999198102163121</id_no><personname>测试6322B</personname><sex>2</sex><birthday>19810216</birthday><fromhosp></fromhosp><fromhospdate>18991230</fromhospdate><fundtype>3</fundtype><isyt>0</isyt><jclevel>0</jclevel><hospflag>0</hospflag></ic><net><persontype>11</persontype><isinredlist>true</isinredlist><isspecifiedhosp>1</isspecifiedhosp><ischronichosp>false</ischronichosp><personcount>200.00</personcount><chroniccode></chroniccode></net></output></root>\\\\r\\\\n\\\",\\\"Divide\\\":\\\"<?xml version=\\\\\\\"1.0\\\\\\\" encoding=\\\\\\\"UTF-16\\\\\\\" standalone=\\\\\\\"yes\\\\\\\"?>\\\\r\\\\n<root version=\\\\\\\"1.00.0408\\\\\\\"><state success=\\\\\\\"true\\\\\\\"></state><output><tradeinfo><tradeno>999000030C180702000001</tradeno><feeno>00120180702000058</feeno><tradedate>20180702171444</tradedate></tradeinfo><feeitemarray><feeitem itemno=\\\\\\\"429\\\\\\\" recipeno=\\\\\\\"429\\\\\\\" hiscode=\\\\\\\"OT00114\\\\\\\" itemcode=\\\\\\\"W0101020010\\\\\\\" itemname=\\\\\\\"医事服务费【三级医院】【普通门诊】\\\\\\\" itemtype=\\\\\\\"2\\\\\\\" unitprice=\\\\\\\"50.0000\\\\\\\" count=\\\\\\\"1\\\\\\\" fee=\\\\\\\"50.0000\\\\\\\" feein=\\\\\\\"40.0000\\\\\\\" feeout=\\\\\\\"10.0000\\\\\\\" selfpay2=\\\\\\\"10.0000\\\\\\\" state=\\\\\\\"0\\\\\\\" fee_type=\\\\\\\"0601\\\\\\\" preferentialfee=\\\\\\\"0.0000\\\\\\\" preferentialscale=\\\\\\\"0\\\\\\\"></feeitem></feeitemarray><sumpay><feeall>50.00</feeall><fund>40.00</fund><cash>0.00</cash><personcountpay>10.00</personcountpay></sumpay><payinfo><mzfee>50.00</mzfee><mzfeein>40.00</mzfeein><mzfeeout>10.00</mzfeeout><mzpayfirst>0.00</mzpayfirst><mzselfpay2>10.00</mzselfpay2><mzbigpay>40.00</mzbigpay><mzbigselfpay>0.00</mzbigselfpay><mzoutofbig>0.00</mzoutofbig><bcpay>0.00</bcpay><jcbz>0.00</jcbz></payinfo><medicatalog><medicine>0.00</medicine><tmedicine>0.00</tmedicine><therb>0.00</therb><examine>0.00</examine><ct>0.00</ct><mri>0.00</mri><ultrasonic>0.00</ultrasonic><oxygen>0.00</oxygen><operation>0.00</operation><treatment>0.00</treatment><xray>0.00</xray><labexam>0.00</labexam><bloodt>0.00</bloodt><orthodontics>0.00</orthodontics><prosthesis>0.00</prosthesis><forensic_expertise>0.00</forensic_expertise><material>0.00</material><other>50.00</other></medicatalog><medicatalog2><diagnosis>50.00</diagnosis><examine>0.00</examine><labexam>0.00</labexam><treatment>0.00</treatment><operation>0.00</operation><material>0.00</material><medicine>0.00</medicine><therb>0.00</therb><tmedicine>0.00</tmedicine><medicalservice>0.00</medicalservice><commonservice>0.00</commonservice><registfee>0.00</registfee><otheropfee>0.00</otheropfee></medicatalog2></output></root>\\\\r\\\\n\\\",\\\"Trade\\\":\\\"<?xml version=\\\\\\\"1.0\\\\\\\" encoding=\\\\\\\"UTF-16\\\\\\\" standalone=\\\\\\\"yes\\\\\\\"?>\\\\r\\\\n<root version=\\\\\\\"1.00.0408\\\\\\\"><state success=\\\\\\\"true\\\\\\\"></state><output><personcountaftersub>190.00</personcountaftersub><certid>000000000243f6db</certid><sign>G5QvJLdEhUHo4l+DSoOCpvUScS7HSaKOXmyr25YSioabItbstIqsl3M4I/dTBh4s4dD2zmFr0seCe8vhx+O5uETdsgcaBceqqboAgn1iYn1i/76ESnHn0q59xnHuCcpZUqwHesBVlhwqiacc8cuaoBIX8A8NSEKy5qpo2Go7K1I=</sign></output></root>\\\\r\\\\n\\\"}\",\"medTime\":\"\",\"bankSettlementTime\":\"\",\"lockId\":\"\",\"tradeTime\":\"2018-07-02 17:14:49\",\"medAmPm\":\"0\",\"phone\":\"\",\"clinicres\":\"\",\"deptCode\":\"020417\",\"posIndexNo\":\"\",\"operId\":\"Z001\",\"sellerAccountNo\":\"\",\"hospitalId\":\"2001\",\"ybInfo\":\"\",\"accountNo\":\"227\",\"outTradeNo\":\"\",\"flowId\":\"Z0012018070201689000059\",\"regType\":\"w0101020010\",\"tradeModeList\":\"[{\\\"tradeMode\\\":\\\"MIC\\\",\\\"accountNo\\\":\\\"227\\\",\\\"cash\\\":\\\"4000.00\\\",\\\"posTransNo\\\":\\\"00120180702000058\\\",\\\"bankTransNo\\\":null,\\\"bankDate\\\":null,\\\"bankTime\\\":null,\\\"bankSettlementTime\\\":null,\\\"bankCardNo\\\":null,\\\"posIndexNo\\\":\\\"Z001\\\",\\\"sellerAccountNo\\\":null,\\\"transNo\\\":\\\"999000030C180702000001\\\",\\\"payAccountNo\\\":\\\"00000632202S\\\",\\\"outTradeNo\\\":null,\\\"extend\\\":null},{\\\"tradeMode\\\":\\\"MIC\\\",\\\"accountNo\\\":\\\"227\\\",\\\"cash\\\":\\\"1000.00\\\",\\\"posTransNo\\\":\\\"00120180702000058\\\",\\\"bankTransNo\\\":null,\\\"bankDate\\\":null,\\\"bankTime\\\":null,\\\"bankSettlementTime\\\":null,\\\"bankCardNo\\\":null,\\\"posIndexNo\\\":\\\"Z001\\\",\\\"sellerAccountNo\\\":null,\\\"transNo\\\":\\\"999000030C180702000001\\\",\\\"payAccountNo\\\":\\\"00000632202S\\\",\\\"outTradeNo\\\":null,\\\"extend\\\":null},{\\\"tradeMode\\\":\\\"\\\",\\\"accountNo\\\":null,\\\"cash\\\":null,\\\"posTransNo\\\":null,\\\"bankTransNo\\\":null,\\\"bankDate\\\":null,\\\"bankTime\\\":null,\\\"bankSettlementTime\\\":null,\\\"bankCardNo\\\":null,\\\"posIndexNo\\\":null,\\\"sellerAccountNo\\\":null,\\\"transNo\\\":null,\\\"payAccountNo\\\":null,\\\"outTradeNo\\\":null,\\\"extend\\\":null}]\",\"patientName\":\"测试6322B\",\"hospCode\":\"\",\"cardType\":\"10\",\"deviceVersion\":\"YT-550\",\"transNo\":\"\",\"doctCode\":\"\",\"service\":\"yuantu.wap.appointment.or.registration\",\"regMode\":\"2\",\"tradeMode\":\"MIX\",\"invoice\":\"\",\"fundCustodian\":\"\"}";
        Map map= JSON.parseObject(s,Map.class);
//        Document document = DocumentHelper.parseText(s);
//        Map map = XmlUtils.dom2Map(document.getRootElement());
//        JSONObject jsonObject = (JSONObject) JSON.toJSON(map);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(map);
        String result = HttpClientUtils.post(localUrl,sPara);
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
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.TYPE,"1");
//        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"24");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"111111551");
        sParaTemp.put("startDate","2018-07-01");
        sParaTemp.put("endDate","2018-08-12");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf("1000011272"));
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryLisReport);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(url,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }
    @Test
    public void testQueryInhosPatientInfo() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"19330");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"-1");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryInhosPatientInfo);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(prodUrl,sPara);
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
    public void tes() throws IOException {
        String s = "{\"terminalNo\":\"Z003\",\"deviceIp\":\"10.8.70.3\",\"patientName\":\"\",\"hospCode\":\"\",\"searchType\":\"\",\"cardType\":\"24\",\"operId\":\"Z003\",\"secrityNo\":\"\",\"deviceVersion\":\"YT-550\",\"cardNo\":\"20150100170523\",\"deviceInfo\":\"Z003\",\"extend\":\"hisOnly\",\"tradeTime\":\"2018-07-19 11:04:44\",\"sourceCode\":\"ZZJ\",\"hospitalId\":\"2001\",\"service\":\"yuantu.wap.query.patient.info\",\"deviceMac\":\"00-0E-C4-D3-98-F2\",\"flowId\":\"Z0032018071962104000274\",\"fundCustodian\":\"\"}";
        Map map  = JSON.parseObject(s,Map.class);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(map);
        String result = HttpClientUtils.post(localUrl,sPara);
        System.out.println(result);
    }

    @Test
    public void testQueryMedicine() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"ZZ01");
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put("pinyinCode","AM");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryCostInfo);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
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
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"1726839");
        sParaTemp.put(ParamsKeyConstant.START_DATE,"2018-01-23");
        sParaTemp.put(ParamsKeyConstant.END_DATE,"2018-12-26");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
        sParaTemp.put("syxh","16");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryInhosBillItemList);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
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



}
