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

    private String prodUrl="http://192.168.90.64:8980/frontgateway/gateway.do";
    //private String localUrl="http://192.168.90.65:8088/frontgateway/gateway.do";
    private String url="http://192.168.90.65:8088/frontgateway/gateway.do";
    private String localUrl="http://127.0.0.1:8080/frontgateway/gateway.do";

    private String yuantutestUrl="http://121.40.253.119:8190/frontgateway/gateway.do";

    //建档
    @Test
    public void testSetPatient() throws IOException {
        Map<String,String> params = new HashMap();

        params.put("idType","1");
        params.put("operId","ZZ01");
        params.put("birthday", "1992-04-17");
        params.put("phone","13588888887");
        params.put("sex","女");
        params.put("sourceCode","ZZJ");
        params.put("deviceMac","00-FF-CE-BD-49-1D");
        params.put(ParamsKeyConstant.CARD_TYPE,"2");
        params.put("cardNo", "0101187");
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
//        params.put("patientType", "自费");
//        params.put("cardNo", "370283790911703");
//        params.put("patientName", "建档4");
//        params.put("sex", "男");
//        params.put("birthday", "2015-10-30");
//        params.put(ParamsKeyConstant.ID_NO, "370181198810271712");
//        params.put("nation", "汉");
//        params.put("idType", "1");
//        params.put("address", "山东千佛山");
//        params.put("phone", "13168146182");
//        params.put("flowId", "13333111133");
//        params.put("cash", "1");
//        params.put("tradeMode", "DB");
//        params.put("pwd", "123456");

//        params.put("bankNo", "34455");
//        params.put("accountNo", "33333333122");
//        params.put("hospCode", "3702010323");
//        params.put("terminalNo","ZZJ002");

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
       sParaTemp.put(ParamsKeyConstant.REG_MODE,"1");
       sParaTemp.put(ParamsKeyConstant.REG_TYPE,"1");
       sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
       sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
       sParaTemp.put(ParamsKeyConstant.OPER_ID,"ZZ01");
       sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf(""));
       sParaTemp.put(ParamsKeyConstant.HIS_CODE, String.valueOf(""));
       sParaTemp.put("startDate","2018-05-28");
       sParaTemp.put("endDate","2018-05-30");
       sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryRegistrationDepList);
       Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
       String result = HttpClientUtils.post(localUrl,sPara);
       JSONObject array= JSON.parseObject(result);
       System.out.print(result);
   }



    //根据科室ID获取科室/医生排班信息
    @Test
    public void testQueryRegistDept() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.REG_MODE,"1");
        sParaTemp.put(ParamsKeyConstant.REG_TYPE,"1");
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"ZZ01");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf(""));
        sParaTemp.put(ParamsKeyConstant.HIS_CODE, String.valueOf(""));
        sParaTemp.put(ParamsKeyConstant.DEPT_CODE,"020101");
        sParaTemp.put(ParamsKeyConstant.START_DATE,"2018-05-31");
        sParaTemp.put(ParamsKeyConstant.END_DATE,"2018-06-01");
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
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QUERYHOSPITALALLDOC);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
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
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"2");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"0101186");
        sParaTemp.put(ParamsKeyConstant.REG_TYPE,"1");
        sParaTemp.put(ParamsKeyConstant.SCHEDULE_ID,"45");
        sParaTemp.put(ParamsKeyConstant.SERVICE, "yuantu.wap.reg.pre.process");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"ZZ01");
        sParaTemp.put(ParamsKeyConstant.APPO_NO,"34");
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
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryHospitalDep);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
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
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"24");
        //  20150100065066
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"20150100019595");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryPatientInfo);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(prodUrl,sPara);
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
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "APP");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.REG_MODE,"1");
        sParaTemp.put(ParamsKeyConstant.DEPT_CODE,"020417");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf("1000011274"));
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryRegistrationScheduleInfoList);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(prodUrl,sPara);
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
        sParaTemp.put(ParamsKeyConstant.BILL_NO,"20180604Z0010004");
//        sParaTemp.put(ParamsKeyConstant.BILL_TYPE,"");
        sParaTemp.put(ParamsKeyConstant.TRADE_MODE,"ZFB");
        sParaTemp.put(ParamsKeyConstant.BILL_ITEM,"");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"20180602003");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"24");
        sParaTemp.put(ParamsKeyConstant.FLOW_ID,"10000000000010");
        sParaTemp.put(ParamsKeyConstant.SERVICE, "yuantu.wap.unlock.balance.bill");
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
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
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "9999");
        sParaTemp.put(ParamsKeyConstant.SERVICE,HttpServiceName.QueryInhosWardInfo);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(yuantutestUrl,sPara);
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
        sParaTemp.put(ParamsKeyConstant.REG_MODE,"2");
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
        sParaTemp.put(ParamsKeyConstant.FLOW_ID,"1111111111111114");


        sParaTemp.put(ParamsKeyConstant.OUT_TRADE_NO,"01020010120180530094658103526460");
        sParaTemp.put("outRefundNo","01020010120180601094658103526460");
        sParaTemp.put("fee","210");
        sParaTemp.put("reason","何天予缴费人工退费");

        sParaTemp.put(ParamsKeyConstant.SERVICE,HttpServiceName.BackFeeUserCash);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
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
    public void test() throws DocumentException {
        String s ="<zzxt>\n" +
                "<result>\n" +
                "<retcode>0</retcode>\n" +
                "<retmsg>交易成功</retmsg>\n" +
                "</result>\n" +
                "<table>\n" +
                "<brzt>T</brzt>\n" +
                "<patid>25854</patid>\n" +
                "<cardno>8115</cardno>\n" +
                "<cardtype>1</cardtype>\n" +
                "<pzlx>0</pzlx>\n" +
                "<hzxm>8115测试</hzxm>\n" +
                "<ybdm>1</ybdm>\n" +
                "<sex>男</sex>\n" +
                "<sfzh>320381198405235779</sfzh>\n" +
                "<lxdz></lxdz>\n" +
                "<ghbz>1</ghbz>\n" +
                "<lxdh>1234509876133</lxdh>\n" +
                "<zhye>1469.24</zhye>\n" +
                "<ispwd></ispwd>\n" +
                "<djrq>20120625151004</djrq>\n" +
                "<lrrq>20120303</lrrq>\n" +
                "<gsbz>0</gsbz>\n" +
                "<birth>19860303 </birth>\n" +
                "<blh>20160601000001</blh>\n" +
                "</table>\n" +
                "</zzxt>";

        Document document = DocumentHelper.parseText(s);
        Map map = XmlUtils.dom2Map(document.getRootElement());
        JSONObject jsonObject = (JSONObject) JSON.toJSON(map);
        System.out.print(jsonObject.toJSONString());
    }

    @Test
    public void testQueryHisRegRecord() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.REG_MODE,"2");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf("1000011274"));
        sParaTemp.put("startTime","2018-05-04 13:30:00");
        sParaTemp.put("endTime","2018-05-04 14:00:00");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryJhRegRecord);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(prodUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    @Test
    public void testReport() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.TYPE,"1");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"24");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"20150100114315");
        sParaTemp.put("startDate","2018-02-25");
        sParaTemp.put("endDate","2018-03-16");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"1502202020");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf("1000011272"));
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryLisReport);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(prodUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }
    @Test
    public void testQueryInhosPatientInfo() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"1726839");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"-1");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"Z001");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryInhosPatientInfo);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);

    }


    @Test
    public void testQueryInhosBillItem() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"1726919");
        sParaTemp.put("startDate","2017-12-24");
        sParaTemp.put("endDate","2017-12-25");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryInhosBillItemList);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(url,sPara);
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
        sParaTemp.put(ParamsKeyConstant.CASH,"100");
        sParaTemp.put("syxh","16");
        sParaTemp.put("jsxh","16");
        sParaTemp.put(ParamsKeyConstant.FLOW_ID,"ZZ0111111111111111");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.RechargeInhosVirtualSettlement);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    @Test
    public void tes(){
        String s = JSON.toJSONString("{\"outMainPage\": [{ \"itemType\": 1, \"tittle\": \"住院须知\", \"style\": 0, \"imageUrl\": \"http://10.8.100.57:8084/file/picture/zhuyuanxuzhi.png\", \"tag\": \"hospitalIntro\", \"url\": \"http://inpatient.app/outAdmission\" },{ \"itemType\": 1, \"tittle\": \"家属订餐\", \"style\": 1, \"imageUrl\": \"http://10.8.100.57:8084/file/picture/jiashudingcan.png\", \"tag\": \"hospitalIntro\", \"url\": \"http://inpatient.app/orderWeb\" },{ \"itemType\": 1, \"tittle\": \"满意度调查\", \"style\": 3, \"imageUrl\": \"http://10.8.100.57:8084/file/picture/manyidudiaocha.png\", \"tag\": \"hospitalIntro\", \"url\": \"http://inpatient.app/outInvestagate\" } ], \"outAdmissionPage\": [ { \"itemType\": 2, \"tittle\": \"入院须知\", \"style\": 2, \"imageUrl\": \"https://front-images.oss-cn-hangzhou.aliyuncs.com/i4/74c9aec929f787aae7cb03ee8db3da28-238-198.png\", \"tag\": \"hospitalIntro\", \"url\": \"http://inpatient.app/outAdmissionDetail?sourceCode=1\" }, { \"itemType\": 2, \"tittle\": \"出院须知\", \"style\": 0, \"imageUrl\": \"https://front-images.oss-cn-hangzhou.aliyuncs.com/i4/6639d93c5090a81bb147d4baae5e4407-240-200.png\", \"tag\": \"hospitalIntro\", \"url\": \"http://inpatient.app/outAdmissionDetail?sourceCode=2\" }, { \"itemType\": 2, \"tittle\": \"患者须知\", \"style\": 4, \"imageUrl\": \"https://front-images.oss-cn-hangzhou.aliyuncs.com/i4/f970f678b0da6257b13b7863aaf5f49b-204-200.png\", \"tag\": \"hospitalIntro\", \"url\": \"http://inpatient.app/outAdmissionDetail?sourceCode=3\" }, { \"itemType\": 2, \"tittle\": \"医保须知\", \"style\": 3, \"imageUrl\": \"https://front-images.oss-cn-hangzhou.aliyuncs.com/i4/117125cf909a1d9b1a7b7060b48725a0-200-200.png\", \"tag\": \"hospitalIntro\", \"url\": \"http://inpatient.app/outAdmissionDetail?sourceCode=4\" }], \"outSettingPage\": [ { \"itemType\": 2, \"tittle\": \"输入编号\", \"style\": 0, \"imageUrl\": \"https://front-images.oss-cn-hangzhou.aliyuncs.com/i4/dca1fef5ba2e615a1d4cb7932a3188cc-182-200.png\", \"tag\": \"hospitalIntro\", \"url\": \"http: //inpatient.app/initBox\" }, { \"itemType\": 2, \"tittle\": \"网络\", \"style\": 4, \"imageUrl\": \"https://front-images.oss-cn-hangzhou.aliyuncs.com/i4/7641222786c4207f3f4e1ebf3d75fe80-270-200.png\", \"tag\": \"hospitalIntro\", \"url\": \"http: //inpatient.app/network\" }, { \"itemType\": 2, \"tittle\": \"升级\", \"style\": 2, \"imageUrl\": \"https://front-images.oss-cn-hangzhou.aliyuncs.com/i4/7ca2c497e255ee9745a7efb3e8e88edf-198-198.png\", \"tag\": \"hospitalIntro\", \"url\": \"http: //inpatient.app/update\" } ]}");
        System.out.println(s);
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
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryMedicinesInfo);
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




}
