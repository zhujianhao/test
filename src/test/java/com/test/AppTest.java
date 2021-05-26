package com.test;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() throws IOException {
        Map map=new HashMap();
        //map.put("terminalNo",null);
        map.put("corpId","2001");
        map.put("channel","2");
        map.put("operId","Z001");
        map.put("corpCode","1000011272");
        map.put("deviceInfo",null);
        map.put("branchCode","1000011272");
        map.put("schResultId","12");
        map.put("intervalFlag","2");
        map.put("regMode","1");
  //      map.put("regType","OT00124");
        map.put("flowId","10000");
        map.put("deptCode","");
        String s=HttpClientUtils.post("http://plan.uat.ali.yuantutech.com/plancenter/rest/api/schList",map);

        System.out.print(s);


    }


    public void testRegist() throws IOException {
        String s=String.valueOf((Float.valueOf("33.0000")*100));
        System.out.print(s);
    }


}
