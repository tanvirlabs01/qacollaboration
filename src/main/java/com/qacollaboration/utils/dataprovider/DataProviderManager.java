package com.qacollaboration.utils.dataprovider;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataProviderManager {
    private static String testFilePath = System.getProperty("user.dir")+"\\"+"Filepath";
    private static List<Map<String,Object>> testDataList = new ArrayList<>();
    @DataProvider(name="getData",parallel = true)
    public static Object[][] getData(Method method)
    {
        String testName = method.getName();
        String[] className = method.getDeclaringClass().getTypeName().split("\\.");
        String fileName = className[className.length-1];
        String testFile = testFilePath+"\\"+fileName+"Data.json";
        testDataList = DataProviderFactory.getTestData(testFile,testName);
        Object [][] testData = new Object[testDataList.size()][1];
        for(int i=0;i<testDataList.size();i++)
        {
            testData[i][0]=testDataList.get(i);
        }
        return testData;
    }
}
