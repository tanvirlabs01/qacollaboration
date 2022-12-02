package com.qacollaboration.listeners;

import com.qacollaboration.annotation.FrameworkAnnotation;
import com.qacollaboration.extentReports.ExtentLogger;
import com.qacollaboration.extentReports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class ListenerClass implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.inItReport();
    }
    @Override
    public void onFinish(ISuite suite)
    {
        ExtentReport.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result)
    {
        ExtentReport.createTest(result.getMethod().getMethodName());
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
                .author());
        ExtentReport.addCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
                .category());
    }
    @Override
    public void onTestSuccess(ITestResult result)
    {
        ExtentLogger.pass(result.getMethod().getMethodName()+" is passed");
    }
    @Override
    public void onTestFailure(ITestResult result)
    {
        ExtentLogger.fail(result.getMethod().getMethodName()+" is Failed",true);
        ExtentLogger.fail(result.getThrowable().toString());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        //Attached screenshot
    }
    @Override
    public void onTestSkipped(ITestResult result)
    {
        try {
            ExtentLogger.skip(result.getMethod().getMethodName()+" is Skipped",true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
