package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yuantu.client.constant.HttpServiceName;
import com.yuantu.client.constant.ParamsKeyConstant;
import com.yuantu.client.security.ParamsUtil;
import org.junit.Test;
import sun.java2d.pipe.SpanClipRenderer;

import java.io.IOException;
import java.io.SerializablePermission;
import java.util.HashMap;
import java.util.Map;


//测试的cardNo : 0101103  cardType：2 deptCode:021607 patientId 7 hospitalCode:1000011272
public class TestFrontGateway {

    private String prodUrl="http://192.168.90.64:8980/frontgateway/gateway.do";
    private String url="http://192.168.90.65:8090/frontgateway/gateway.do";
    private String localUrl="http://localhost:8080/frontgateway/gateway.do";

    private String yuantutestUrl="http://121.40.253.119:8190/frontgateway/gateway.do";

    //建档
    @Test
    public void testSetPatient() throws IOException {
        Map<String,String> params = new HashMap();

        params.put("idType","1");
        params.put("operId","z001");
        params.put("birthday", "1992-04-17");
        params.put("phone","13588888888");
        params.put("sex","女");
        params.put("sourceCode","ZZJ");
        params.put("deviceMac","00-FF-CE-BD-49-1D");
        params.put(ParamsKeyConstant.CARD_TYPE,"2");
        params.put("cardNo", "0101128");
        params.put("deviceIp","192.168.2.11");
        params.put("guardianName", "测试账号5");
        params.put("guardianNo","123445");
        params.put("name", "测试账号20");
        params.put("tradeMode", "OC");
        params.put("idNo", "140902197909224394");
      //  params.put("setupType","1");
        params.put("tradeTime","2017-03-03 10:10:00");
        params.put("extend", "");
        params.put("terminalNo", "001");
        params.put("accountNo", "");
        params.put("deviceInfo", "001");
        params.put("nation","汉");
        params.put("platformId", "44346547567");

        params.put("pwd", "123");
        params.put("address", "中国北京");
        params.put("service", "yuantu.wap.set.patient.info");
        params.put("patientType", "自费");
        params.put("flowId", "261ZZJ012017061612111049");
//        params.put("cardType", "2");
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
//        params.put("operId", "888899");
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
       sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
       sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
       sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf(""));
       sParaTemp.put(ParamsKeyConstant.HIS_CODE, String.valueOf(""));
       sParaTemp.put("startDate","2017-12-10");
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
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf(""));
        sParaTemp.put(ParamsKeyConstant.HIS_CODE, String.valueOf(""));
        sParaTemp.put("startDate","2017-12-10");
        sParaTemp.put("endDate","2017-12-17");
        sParaTemp.put(ParamsKeyConstant.DEPT_CODE,"021607");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryRegistrationScheduleInfoList);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(url,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }


    //pass
    @Test
    public void testQueryDoct() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryHospitalDoc);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(prodUrl,sPara);
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
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"20150100156141");
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
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.REG_MODE,"2");
        sParaTemp.put(ParamsKeyConstant.DEPT_CODE,"021001");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf("1000011272"));
        sParaTemp.put("startDate","2018-01-23");
        sParaTemp.put("endDate","2018-02-01");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryRegistrationScheduleInfoList);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(url,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

   // {terminalNo=Z001, corpId=2001, endDate=, channel=2, operId=Z001, corpCode=1000011272, deviceInfo=Z001, branchCode=1000011272, doctCode=, schResultId=12, intervalFlag=1, regMode=2, regType=OT00124, flowId=Z0012017122501689000026, deptCode=021607, startDate=}
    //挂号/预约
    @Test
    public void testAppoinmentOrRegistration() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "HIS");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
//0101103
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"20150100053699");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"24");

        sParaTemp.put(ParamsKeyConstant.REG_MODE,"2");
        sParaTemp.put(ParamsKeyConstant.REG_TYPE,"1");
        //就诊日期
        sParaTemp.put(ParamsKeyConstant.MED_DATE,"2018-01-16");

        //就诊时间
        sParaTemp.put(ParamsKeyConstant.MED_TIME,"17:00");
        sParaTemp.put(ParamsKeyConstant.SCHEDULE_ID,"20");
        sParaTemp.put(ParamsKeyConstant.DEPT_CODE,"021607");
        sParaTemp.put(ParamsKeyConstant.MED_AMPM,"2");
        sParaTemp.put(ParamsKeyConstant.APPO_NO,"1");
        sParaTemp.put(ParamsKeyConstant.EXTEND,"{\"version\":\"1\",\"toHisReg\":\"2\"}");
        //支付方式CA:现金 MIC：医保 ZFB：支付宝 WX：微信 OC：卡内账户/结算账户
        sParaTemp.put(ParamsKeyConstant.TRADE_MODE,"CA");
        sParaTemp.put(ParamsKeyConstant.ACCOUNT_NO,"33333333122");
        sParaTemp.put(ParamsKeyConstant.VERSION,"2");
        sParaTemp.put(ParamsKeyConstant.CASH,"100");
        sParaTemp.put(ParamsKeyConstant.DIS_COUNT_FEE,"10");
        sParaTemp.put("discountFlag","0");
        sParaTemp.put("discountDesc","残疾人");
        sParaTemp.put("operId","0006");
        sParaTemp.put(ParamsKeyConstant.FLOW_ID,"1000127");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.AppointmentOrRegistration);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(url,sPara);
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
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"0101106");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"2");
        sParaTemp.put(ParamsKeyConstant.ORDER_NO,"18187");
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
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"1712165544");
        sParaTemp.put(ParamsKeyConstant.START_DATE,"2017-01-01");
        sParaTemp.put(ParamsKeyConstant.END_DATE,"2018-12-12");
        //sParaTemp.put(ParamsKeyConstant.SEARCH_TYPE,"1");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"16185573");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"2");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryAppointmentAndRegistrationRecord);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(url,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }

    //获取待缴费概要信息
    @Test
    public void testQueryWaitBalanceInfo() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZJJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE,"1000011272");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"1801053116");
        sParaTemp.put(ParamsKeyConstant.BILL_TYPE,"");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"20150100156141");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"2");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.QueryWaitBalanceBillList);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(url,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }



    //缴费结算
    @Test
    public void testPayBill() throws IOException {
        Map<String, String> sParaTemp = new HashMap();
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID, "2001");
        sParaTemp.put(ParamsKeyConstant.OPER_ID,"0006");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE,"1000011272");
        sParaTemp.put(ParamsKeyConstant.PATIENT_ID,"1712165544");
//        sParaTemp.put(ParamsKeyConstant.BILL_NO,"");
//        sParaTemp.put(ParamsKeyConstant.BILL_TYPE,"");
        sParaTemp.put(ParamsKeyConstant.CASH,"114.86");
        sParaTemp.put(ParamsKeyConstant.TRADE_MODE,"WX");
        sParaTemp.put(ParamsKeyConstant.BILL_ITEM,"");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"0101104");
        sParaTemp.put(ParamsKeyConstant.ACCOUNT_NO,"0101104");
        sParaTemp.put(ParamsKeyConstant.CARD_TYPE,"2");
        sParaTemp.put(ParamsKeyConstant.FLOW_ID,"10000000000009");
        sParaTemp.put(ParamsKeyConstant.SERVICE, HttpServiceName.BalanceAndPayBill);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(localUrl,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }


    //缴费结算
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
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf("1000011272"));
        sParaTemp.put("startDate","2018-01-18");
        sParaTemp.put("endDate","2018-01-27");
        sParaTemp.put(ParamsKeyConstant.SERVICE,"yuantu.wap.query.all.schedule.list");
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(prodUrl,sPara);
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
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf("1000011272"));
        sParaTemp.put("startDate","2017-01-15");
        sParaTemp.put("endDate","2018-01-013");
        sParaTemp.put(ParamsKeyConstant.CARD_NO,"0101104");
        sParaTemp.put(ParamsKeyConstant.SERVICE,HttpServiceName.QueryBillBalanceAndPayRecord);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(url,sPara);
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
        sParaTemp.put(ParamsKeyConstant.SOURCE_CODE, "ZZJ");
        sParaTemp.put(ParamsKeyConstant.HOSPITAL_ID,"2001");
        sParaTemp.put(ParamsKeyConstant.DEVICE_INFO,"ZZJ001");
        sParaTemp.put(ParamsKeyConstant.TERMINAL_NO,"ZZJ001");

        sParaTemp.put(ParamsKeyConstant.OPER_ID,"ZZJ001");
        sParaTemp.put(ParamsKeyConstant.DEVICE_MAC,"00-FF-CE-BD-49-1D");
        sParaTemp.put(ParamsKeyConstant.DEVICE_IP,"192.168.2.11");
        sParaTemp.put(ParamsKeyConstant.TRADE_TIME,"2018-01-01 10:10:00");
        sParaTemp.put(ParamsKeyConstant.HOSP_CODE, String.valueOf("1000011272"));

        sParaTemp.put(ParamsKeyConstant.FLOW_ID,"11111111111111112");
        sParaTemp.put(ParamsKeyConstant.OUT_TRADE_NO,"02020010120180125103816245922319");
        sParaTemp.put("outTradeNo","02020010120180125103816245922319");
        sParaTemp.put("fee","0.5");
        sParaTemp.put("reason","挂号退费");

        sParaTemp.put(ParamsKeyConstant.SERVICE,HttpServiceName.BackFeeUserCash);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(sParaTemp);
        String result = HttpClientUtils.post(url,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);
    }


    @Test
    public void testUpdatePatient() throws IOException {
        String s="{\"service\":\"yuantu.wap.modify.virtual.settlement\",\"sourceCode\":\"HIS\",\"hospitalId\":\"2001\"," +
                "\"hospCode\":\"1000011272\",\"platformId\":\"124\",\"cardNo\":\"20150100020499\",\"cardType\":\"24\"," +
                "\"idType\":\"身份证\",\"patientType\":\"自费\",\"phone\":\"13718269215\",\"birthday\":\"2009-10-07\"," +
                "\"idNo\":\"110114201504245029\",\"patientName\":\"胡佳乐\",\"sex\":\"男\",\"nation\":\"汉族\"}";
        Map map=JSON.parseObject(s,Map.class);
        Map<String, String> sPara = ParamsUtil.buildRequestPara(map);
        String result = HttpClientUtils.post(url,sPara);
        JSONObject array= JSON.parseObject(result);
        System.out.print(result);

    }

    @Test
    public void test(){
        String s ="{\"extend\":{\"version\":\"1\",\"isPayNow\":\"0\",\"regTypeYT\":\"1\",\"Divide\":{\"output\":{\"name\":null,\"tradeinfo\":{\"tradeno\":\"211514150A180131000340\",\"feeno\":\"\",\"tradedate\":\"20180131111128\"},\"feeitemarray\":[{\"itemno\":\"1\",\"recipeno\":\"001000040\",\"hiscode\":\"OT00114/\",\"itemcode\":\"W0101020010\",\"itemname\":\"医事服务费【三级医院】【普通门诊】\",\"itemtype\":\"2\",\"unitprice\":\"50.0000\",\"count\":\"1\",\"fee\":\"50.0000\",\"feein\":\"40.0000\",\"feeout\":\"10.0000\",\"selfpay2\":\"10.0000\",\"state\":\"0\",\"fee_type\":\"0601\",\"preferentialfee\":\"0.0000\",\"preferentialscale\":\"0\"}],\"sumpay\":{\"feeall\":\"50.00\",\"fund\":\"40.00\",\"cash\":\"10.00\",\"personcountpay\":\"0.00\"},\"payinfo\":{\"mzfee\":\"50.00\",\"mzfeein\":\"40.00\",\"mzfeeout\":\"10.00\",\"mzpayfirst\":\"0.00\",\"mzselfpay2\":\"10.00\",\"mzbigpay\":\"40.00\",\"mzbigselfpay\":\"0.00\",\"mzoutofbig\":\"0.00\",\"bcpay\":\"0.00\",\"jcbz\":\"0.00\"},\"medicatalog\":{\"medicine\":\"0.00\",\"tmedicine\":\"0.00\",\"therb\":\"0.00\",\"examine\":\"0.00\",\"ct\":\"0.00\",\"mri\":\"0.00\",\"ultrasonic\":\"0.00\",\"oxygen\":\"0.00\",\"operation\":\"0.00\",\"treatment\":\"0.00\",\"xray\":\"0.00\",\"labexam\":\"0.00\",\"bloodt\":\"0.00\",\"orthodontics\":\"0.00\",\"prosthesis\":\"0.00\",\"forensic_expertise\":\"0.00\",\"material\":\"0.00\",\"other\":\"50.00\"},\"medicatalog2\":{\"diagnosis\":\"50.00\",\"examine\":\"0.00\",\"labexam\":\"0.00\",\"treatment\":\"0.00\",\"operation\":\"0.00\",\"material\":\"0.00\",\"medicine\":\"0.00\",\"therb\":\"0.00\",\"tmedicine\":\"0.00\",\"medicalservice\":\"0.00\",\"commonservice\":\"0.00\",\"registfee\":\"0.00\",\"otheropfee\":\"0.00\"}},\"state\":{\"success\":\"true\",\"error\":null,\"warning\":null}},\"Trade\":{\"output\":{\"name\":null,\"personcountaftersub\":\"0.00\",\"certid\":\"000000000273c5e7\",\"sign\":\"l3MPRJ9tQFGOLDuy0gPOaOuR7KrKZ9L71XaSu2T2UEIkOTJmyapZps56CqSru3bjRq6aupJAblAf231huHRbMRsqCiuOvJFbkIshBKgAtZxZuUP/dhejQtRKcdfsHVpesFwuQdGvjSesnISsA3DY4qkjQggrc0Ha4N9q8WJ1q2o=\"},\"state\":{\"success\":\"true\",\"error\":null,\"warning\":null}}}}";

        JSONObject jsonObject= JSON.parseObject(s);
        JSONObject jsonObject1=(JSONObject)jsonObject.get("extend");
        jsonObject.put("ybinfo",jsonObject1.toJSONString());
        String s2 = jsonObject.toJSONString();
        System.out.print(s2);
    }


}
