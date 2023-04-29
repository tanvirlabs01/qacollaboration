package com.qacollaboration.utils.dataprovider;

import java.util.List;
import java.util.Map;

public class DataProviderFactory {
    protected static List<Map<String,Object>> getTestData(String testFile, String testName)
    {
       return new JsonImpl(testFile,testName).getData();
    }

}
