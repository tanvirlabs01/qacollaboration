package com.qacollaboration.extentReports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
    private ExtentManager()
    {

    }
    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();
    static ExtentTest getExtentTest() //defaullt access modifier
    {
        return extTest.get();
    }
    static void setExtentTest(ExtentTest test)
    {
        extTest.set(test);
    }
    static void unload()
    {
        extTest.remove();
    }
}
