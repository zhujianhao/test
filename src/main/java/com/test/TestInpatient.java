package com.test;



import com.service.HisGateWay;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestInpatient {


    private String baseurl="http://localhost:8083/inpatient-web/";
    @Test
    public void testDevice(){

    }

    @Test
    public void testInitDevice() throws IOException {
        Map map=new HashMap();
        map.put("deviceNo","TV_001");
        map.put("deviceMac","2e:77:6w:gg");
        map.put("pushToken","ssss");
        map.put("versionNum","1");
        map.put("deviceType","TV");
        String s=HttpClientUtils.post(baseurl+"device/initDevice",map);
        System.out.println(s);
    }
    @Test
    public void testCost() throws IOException {
        Map map=new HashMap();
        map.put("deviceToken","a68eca88-4d40-4432-81ce-c11f846bae2c");
        map.put("pinyinCode","A");
        String s=HttpClientUtils.post(baseurl+"cost/getCostInfo",map);
        System.out.println(s);
    }// 结果： The host did not accept the connection within timeout of 16000 ms

    @Test
    public void testMedicineInfo() throws IOException {
        Map map=new HashMap();
        map.put("deviceToken","a68eca88-4d40-4432-81ce-c11f846bae2c");
        map.put("pinyinCode","A");
        String s=HttpClientUtils.post(baseurl+"cost/getMedicianInfo",map);
        System.out.println(s);
    }

    @Test
    public void testGetMessage() throws IOException {
        Map map=new HashMap();
        map.put("deviceToken","f6af8582-e3ed-44b6-82d3-489de7f25216");

        String s=HttpClientUtils.post(baseurl+"message/getMessageTemplateList",map);
        System.out.println(s);
    }

    @Test
    public void testgetMessageList() throws IOException {
        Map map=new HashMap();
        map.put("deviceToken","f6af8582-e3ed-44b6-82d3-489de7f25216");
        map.put("currentPage","1");
        map.put("pageSize","10");

        String s=HttpClientUtils.post(baseurl+"message/getMessageList",map);
        System.out.println(s);
    }
//pass
    @Test
    public void testgetCreatOrder() throws IOException {
        Map map=new HashMap();
        map.put("deviceToken","ddf82d31-7376-4e43-bef3-7179ba763682");
        map.put("type","1");
        map.put("orderTime","2017-12-09");
        map.put("userPhone","13588277427");
        map.put("address","西园三路");
        map.put("version","1");
        map.put("productId","1");

        String s=HttpClientUtils.post(baseurl+"order/createOrder",map);
        System.out.println(s);
    }
//pass
    @Test
    public void testQueryOrder() throws IOException {
        Map map=new HashMap();
        map.put("deviceToken","ddf82d31-7376-4e43-bef3-7179ba763682");
        map.put("type","1");
        map.put("currentPage","1");
        map.put("pageSize","10");
        map.put("phone","13588277427");

        String s=HttpClientUtils.post(baseurl+"order/getOrderList",map);
        System.out.println(s);

    }

//pass
    @Test
    public void testOrders() throws IOException {
        Map map=new HashMap();
        map.put("deviceToken","ddf82d31-7376-4e43-bef3-7179ba763682");
        map.put("orderNo","20170227132636181000000000000065");

        String s=HttpClientUtils.post(baseurl+"order/getOrderDetail",map);
        System.out.println(s);

    }

    @Test
    public void testupdateOrders() throws IOException {
        Map map=new HashMap();
        map.put("id","150");
        map.put("status","3");
        map.put("type","1");

        String s=HttpClientUtils.post(baseurl+"order/updateOrder",map);
        System.out.println(s);

    }
//pass
    @Test
    public void testGetValidatCode() throws IOException {
        Map map=new HashMap();
        map.put("deviceToken","ddf82d31-7376-4e43-bef3-7179ba763682");
        map.put("userPhones","13588277427");
        map.put("type","1");

        String s=HttpClientUtils.post(baseurl+"order/getValidateCode",map);
        System.out.println(s);
    }

    @Test
    public void testPatientInfo() throws IOException {
        Map map=new HashMap();
        map.put("deviceToken","ddf82d31-7376-4e43-bef3-7179ba763682");
        map.put("patientHosId","1");


        String s=HttpClientUtils.post(baseurl+"patient/getPatientInfo",map);
        System.out.println(s);

    }
    //pass
    @Test
    public void testGetUserDevice() throws IOException {
        Map map=new HashMap();
        map.put("deviceToken","ddf82d31-7376-4e43-bef3-7179ba763682");


        String s=HttpClientUtils.post(baseurl+"userDevice/getUserByDevice",map);
        System.out.println(s);

    }

    //pass
    //查询用户绑定的设备
    @Test
    public void testGetUserDeviceList() throws IOException {
        Map map=new HashMap();
        map.put("deviceToken","ddf82d31-7376-4e43-bef3-7179ba763682");
        map.put("patientHosId","1");

        String s=HttpClientUtils.post(baseurl+"userDevice/getDeviceListByUser",map);
        System.out.println(s);

    }
//pass
    @Test
    public void testBindDevice() throws IOException {
        Map map=new HashMap();
        map.put("deviceToken","ddf82d31-7376-4e43-bef3-7179ba763682");
        map.put("patientHosId","1");

        String s=HttpClientUtils.post(baseurl+"userDevice/bindDevice",map);
        System.out.println(s);

    }

    //pass
    @Test
    public void testUnbindUserDevice() throws IOException {
        Map map=new HashMap();
        map.put("deviceToken","ddf82d31-7376-4e43-bef3-7179ba763682");
        map.put("patientHosId","1");

        String s=HttpClientUtils.post(baseurl+"userDevice/unbindDevice",map);
        System.out.println(s);

    }

    //pass
    @Test
    public void testgetWardByToken() throws IOException {
        Map map=new HashMap();
        map.put("deviceToken","ddf82d31-7376-4e43-bef3-7179ba763682");

        String s=HttpClientUtils.post(baseurl+"ward/getWardInfoByToken",map);
        System.out.println(s);
        }

        //pass
    @Test
    public void testgetCorpInfo() throws IOException {
        Map map=new HashMap();
        map.put("deviceToken","ddf82d31-7376-4e43-bef3-7179ba763682");

        String s=HttpClientUtils.post(baseurl+"ward/getCorpInfo",map);
        System.out.println(s);
    }

        @Test
    public void testGateWay() throws IOException {
        String s="{\n" +
                "  \"operId\": \"ZZJ001\",\n" +
                "  \"sourceCode\": \"ZZj\",\n" +
                "  \"tradeTime\": \"2017-03-03 10:10:00\",\n" +
                "  \"extend\": \"\",\n" +
                "  \"doctCode\": \"233\",\n" +
                "  \"sign_type\": \"RSA\",\n" +
                "  \"terminalNo\": \"ZZJ001\",\n" +
                "  \"deviceMac\": \"00-FF-CE-BD-49-1D\",\n" +
                "  \"hospitalId\": \"265\",\n" +
                "  \"deviceInfo\": \"ZZJ001\",\n" +
                "  \"sign\": \"mGz8JVNDMEvrfgmZVNM1dVGFRIzOX6kkMyXCY90vI6ci1\",\n" +
                "  \"deviceIp\": \"192.168.2.11\",\n" +
                "  \"service\": \"yuantu.wap.query.inhos.ward.info\",\n" +
                "  \"hospCode\": \"3702010326\",\n" +
                "  \"deptCode\": \"\",\n" +
                "  \"areaCode\": \"10\",\n" +
                "  \"flowId\": \"261ZZJ012017061612111010\"\n" +
                "}";
        System.out.println(HttpClientUtils.post("http://121.40.253.119:8190/frontgateway/gateway.do",s));
        }

        //pass  病房那些之後再弄
        @Test
    public void testinitDevice() throws IOException {
        Map map = new HashMap();
        map.put("deviceNo","232323");
        map.put("deviceMac","ww:ee:rr:ww:ss");
        map.put("pushToken","sdfdfdfafdf");
        map.put("versionNum","2");
        map.put("deviceType","BOX");
        System.out.println(HttpClientUtils.post("http://localhost:8083/inpatient-web/device/initDevice",map));
        }
    //pass
    @Test
    public void testgetAccesstoken() throws IOException {
        Map map = new HashMap();
        map.put("secret","7947ef1b-c31a-4098-a82b-b40f115bd0a1");
        System.out.println(HttpClientUtils.post("http://localhost:8083/inpatient-web/device/getAccessTokenBySecret",map));
    }

    //pass
    @Test
    public void testgetDevice() throws IOException {
        Map map = new HashMap();
        map.put("deviceToken","a68eca88-4d40-4432-81ce-c11f846bae2c");
        ;
        System.out.println(HttpClientUtils.post("http://localhost:8083/inpatient-web/device/getDeviceInfoByToken",map));
    }

    //pass
    @Test
    public void testWardArea() throws IOException {
        Map map = new HashMap();
        map.put("deviceToken","f6af8582-e3ed-44b6-82d3-489de7f25216");
        ;
        System.out.println(HttpClientUtils.post("http://localhost:8083/inpatient-web/ward/getAreaDetail",map));

    }
//pass
    @Test
    public void testVedio() throws IOException {
        Map map = new HashMap();
        map.put("deviceToken","a68eca88-4d40-4432-81ce-c11f846bae2c");
        map.put("category","1");
        ;
        System.out.println(HttpClientUtils.post("http://localhost:8083/inpatient-web/video/getVideoList",map));

    }

 //pass
    @Test
    public void testGetQuestionPaper() throws IOException {
        Map map = new HashMap();
        map.put("deviceToken","a68eca88-4d40-4432-81ce-c11f846bae2c");
        ;
        System.out.println(HttpClientUtils.post("http://localhost:8083/inpatient-web/question/getQuestionPaper",map));

    }

    //pass
    @Test
    public void testGetProductList() throws IOException {
        Map map = new HashMap();
        map.put("deviceToken","a68eca88-4d40-4432-81ce-c11f846bae2c");
        map.put("type","1");
        ;
        System.out.println(HttpClientUtils.post("http://localhost:8083/inpatient-web/product/getProductTypeList",map));

    }

    //pass
    @Test
    public void testGetProductDetailList() throws IOException {
        Map map = new HashMap();
        map.put("deviceToken","a68eca88-4d40-4432-81ce-c11f846bae2c");
        map.put("parentTypeId","4");
        ;
        System.out.println(HttpClientUtils.post("http://localhost:8083/inpatient-web/product/getProductDetailList",map));

    }

    //pass
    @Test
    public void testPush() throws IOException {
        Map map = new HashMap();
        map.put("deviceToken","a68eca88-4d40-4432-81ce-c11f846bae2c");
        map.put("pushType","1");
        ;
        System.out.println(HttpClientUtils.post("http://localhost:8083/inpatient-web/order/push",map));

    }

//pass
    @Test
    public void testNotice() throws IOException {
        Map map = new HashMap();
        map.put("deviceToken","a68eca88-4d40-4432-81ce-c11f846bae2c");
        map.put("type","1");
        ;
        System.out.println(HttpClientUtils.post("http://ngrok.yuantutech.com:35684/inpatient-web/notice/getNotice",map));

    }

    @Test
    public void testGetDocByToken() throws IOException {
        Map map = new HashMap();
        map.put("deviceToken","a68eca88-4d40-4432-81ce-c11f846bae2c");
        map.put("doctCode","001330");
        ;
        System.out.println(HttpClientUtils.post("http://ngrok.yuantutech.com:35684/inpatient-web/doct/getDoctByToken",map));

    }

    //一日清单
    @Test
    public void testDailyCost() throws IOException {
        Map map = new HashMap();
        map.put("deviceToken","d048e3a6-1cea-408b-a2c8-8540f104d457");
        map.put("patientHosId","123");
        map.put("date","2017-04-01")
        ;
        System.out.println(HttpClientUtils.post("http://ngrok.yuantutech.com:35684/inpatient-web/patient/getCostInfo",map));

    }


}
