package com.qacollaboration.listeners;

import com.qacollaboration.enums.ConfigProperties;
import com.qacollaboration.utils.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

    private int count =0;
    private int retries = 1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean value = false;
            if(PropertiesUtil.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes"))
            {
               value = count<retries;
               count++;
            }
        return value;
    }
}
