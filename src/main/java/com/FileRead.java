package com;

import com.utils.ReadFileUtil;
import org.junit.Test;

import java.io.*;
import java.nio.CharBuffer;
import java.util.List;

/***/
public class FileRead {


    private static String path = "E:\\zjh\\workspace\\gateway\\frontgateway\\frontgateway-web\\src\\main\\resources\\filters";

    @Test
    public void getProperTies() throws IOException {
        List<String> files = ReadFileUtil.getFiles(path);
        File resFile = new File("C:\\Users\\zjh\\Desktop\\工作\\res.properties");
        BufferedWriter writer = new BufferedWriter(new FileWriter(resFile));
        for(String s :files){
            File file = new File(s);
            try {

//                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String temp;
                String res ="";
                while ((temp = reader.readLine()) != null) {
                    if(temp.contains("restapi/common/scancodepay")){
                        writer.write(s.substring(s.lastIndexOf("\\")+1)+":\r\n  "+temp+"\r\n");
                        break;
                    }
                }
                reader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        writer.flush();
    }

}
