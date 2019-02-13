package com.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import jxl.Cell;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.read.biff.PasswordException;

/***/
public class Test {


    public static void main(String[] args) throws IOException, BiffException {
//handler文件生成
//                File file =new File("E:\\zjh\\corpHandler");
//        try {
//
//            FileWriter fileWriter = new FileWriter(file);
//            for(int i =1851;i<=1867;i++){
//                fileWriter.write("#\nsd.jn.default.hos"+i+".hos.id=${sd.jn.default.hos"+i+".hos.id}\n" +
//                        "sd.jn.default.hos"+i+".paltform.url=${sd.jn.default.hos"+i+".paltform.url}\n" +
//                        "sd.jn.default.hos"+i+".appo.url=${sd.jn.default.hos"+i+".appo.url}\n" +
//                        "sd.jn.default.hos"+i+".his.url=${sd.jn.default.hos"+i+".his.url}\n" +
//                        "sd.jn.default.hos"+i+".his.appId=${sd.jn.default.hos"+i+".his.appId}\n" +
//                        "sd.jn.default.hos"+i+".his.appKey=${sd.jn.default.hos"+i+".his.appKey}\n\n");
//            }
//            fileWriter.flush();
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//~~~~~~~~~~~~~~~~~properties文件生成~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//                File file =new File("E:\\zjh\\corp.txt");
//        try {
//
//            FileWriter fileWriter = new FileWriter(file);
//            for(int i =1851;i<=1867;i++){
//                fileWriter.write("#\nsd.jn.default.hos"+i+".hos.id="+i+"\n" +
//                        "sd.jn.default.hos"+i+".paltform.url=http://11.17.8.165:8081\n" +
//                        "sd.jn.default.hos"+i+".appo.url=http://11.17.8.109:8080/iris/IrisHttpServlet\n" +
//                        "sd.jn.default.hos"+i+".his.url=http://11.17.8.109:8080/iris/IrisHttpServlet\n" +
//                        "sd.jn.default.hos"+i+".his.appId=362\n" +
//                        "sd.jn.default.hos"+i+".his.appKey=751686106D10F5800899D82B28E507F4\n\n");
//            }
//            fileWriter.flush();
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//~~~~~~~~~~~~~~~~~监控sql生成~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//      File f = new File("C:\\Users\\zjh\\Desktop\\工作\\济南\\济南委属配置列表.xls");
//        List<Corp> corps = new ArrayList<>();
//        Corp corp ;
//        try {
//            Workbook workbook = Workbook.getWorkbook(f);
//            Sheet sheet =workbook.getSheet(0);
//            int i = sheet.getRows();
//            for(i--;i>=1;i--){
//                corp = new Corp();
//                corp.setCorpName(sheet.getCell(0,i).getContents());
//                corp.setCorpId(sheet.getCell(1,i).getContents());
//                corp.setHosCode(sheet.getCell(2,i).getContents());
//                corps.add(corp);
//            }
//            for(Corp c : corps){
//                System.out.println("insert into corp (`city`,`province`,`corp_name`,corp_id,`gmt_create`,`gmt_modify`,`corp_no`,`gateway_ip`,`gateway_www_ip`) " +
//                        "values('济南','山东','"+c.getCorpName()+"','"+c.getCorpId()+"',now(),now(),'"+c.getHosCode()+"','http://11.17.8.127:8081/frontgateway/','http://11.17.8.127:8081/frontgateway/');");
//            }
//     } catch (IOException e) {
//            e.printStackTrace();
//        } catch (BiffException e) {
//            e.printStackTrace();
//        }
        for (int j = 2; j <= 3; j++)
            for (int i = 214; i < 231; i++) {

                System.out.println("insert into user_corp(`gmt_create`,`gmt_modify`,`is_deleted`,`user_id`,`corp_id`) " +
                        "values(now(),now(),'0','" + j + "','" + i + "');");
            }
////~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~handler文件生成~~~~~~~~~~~~~~~··
//    File file1= new File("C:\\Users\\zjh\\Desktop\\工作\\济南\\济南委属配置列表.xls");
//    Workbook workbook = Workbook.getWorkbook(file1);
//    Sheet sheet = workbook.getSheet(0);
//    int i =sheet.getRows();
//        FileWriter fileWriter;
//    for(i--;i>=1;i--){
//        File file = new File("E:\\zjh\\济南\\hos"+sheet.getCell(1,i).getContents());
//        file.mkdir();
//        File file0 = new File("E:\\zjh\\济南\\hos"+sheet.getCell(1,i).getContents()+"\\HOS"+sheet.getCell(1,i).getContents()+"BizHandler.java");
//        file0.createNewFile();
//        fileWriter=new FileWriter(file0);
//        fileWriter.write("package com.yuantu.handler.sd.jn.hos"+sheet.getCell(1,i).getContents()+";\n" +
//                "\n" +
//                "import com.yuantu.handler.sd.jn.DefaultJiNanHandler;\n" +
//                "import org.springframework.stereotype.Service;\n" +
//                "\n" +
//                "/**\n" +
//                " * Created by zjh on "+new Date() +"\n" +
//                " * "+sheet.getCell(0,i).getContents()+"\n" +
//                " */\n" +
//                "@Service\n" +
//                "public class HOS"+sheet.getCell(1,i).getContents()+"BizHandler extends DefaultJiNanHandler{\n" +
//                "\n" +
//                "    @Override\n" +
//                "    public String packageCode() {\n" +
//                "        return \"sd.jn.default.hos"+sheet.getCell(1,i).getContents()+"\";\n" +
//                "    }\n" +
//                "\n" +
//                "}");
//        fileWriter.flush();
//        fileWriter.close();
//    }

    }


    public static String escapeChar(int x) {
        if (x <= 0x7f) {
            return Character.toString((char) x);
        } else {
            return "\\u" + String.format("%04x", x);
        }
    }

    public static String escape(String in) {
        return in.chars().mapToObj(x -> escapeChar(x)).collect(Collectors.joining());
    }
}

class Corp{
    private String corpName;
    private String corpId;
    private String hosCode;

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public String getHosCode() {
        return hosCode;
    }

    public void setHosCode(String hosCode) {
        this.hosCode = hosCode;
    }
}
