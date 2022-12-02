package com.qacollaboration.utils;

import com.qacollaboration.frameworkconstants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataProviderUtils {

    private static List<Map<String,String>> list = new ArrayList<>();
    @DataProvider(name="getData",parallel = true)
    public static Object[][] getData(Method method)
    {
        String testName = method.getName();
        if(list.isEmpty())
        {
            list =ExcelUtils.getTestDetails(FrameworkConstants.getIterationdatasheet());
        }
        List<Map<String,String>> smallList = new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            if((list.get(i).get("testname").equalsIgnoreCase(testName))&&(list.get(i).get("execute").equalsIgnoreCase("yes")))
            {
                smallList.add(list.get(i));
            }
        }
        Object[][] testData = new Object[smallList.size()][1];
        for(int j = 0;j<smallList.size();j++)
        {
            testData[j][0]=smallList.get(j);
        }
        return testData;
    }
}
