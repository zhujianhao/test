package com.javaNIO;

import java.io.IOException;
import java.nio.charset.Charset;

/***/
public class TestService {


    public static void main(String[] args) throws IOException, InterruptedException {
        JavaNIO  javaNIOService = new JavaNIO(3333);
        javaNIOService.doService();

    }
}
