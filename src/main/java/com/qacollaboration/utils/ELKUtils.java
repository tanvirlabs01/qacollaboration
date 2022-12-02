package com.qacollaboration.utils;

import java.time.LocalDateTime;
import java.util.HashMap;


public class ELKUtils {
    private ELKUtils() {
    }
    public static void sendDetailsToElk()
    {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("testName","test 1");
        hashMap.put("status","fail");
        hashMap.put("executionTime", LocalDateTime.now().toString());
        //Response response = given().header

    }
}
