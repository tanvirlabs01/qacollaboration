package com.qacollaboration.extentReports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.qacollaboration.enums.ConfigProperties;
import com.qacollaboration.utils.PropertiesUtil;
import com.qacollaboration.utils.ScreenShotUtils;

public class ExtentLogger {
    private ExtentLogger() {
    }
    public static void pass(String message)
    {
        ExtentManager.getExtentTest().pass(message);
    }
    public static void fail(String message)
    {
        ExtentManager.getExtentTest().fail(message);
    }
    public static void skip(String message)
    {
        ExtentManager.getExtentTest().skip(message);
    }
    public static void pass(String message, boolean isScreenShotNeeded) {
        if(PropertiesUtil.get(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
        && isScreenShotNeeded)
        {
            ExtentManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
        }
        else {
            pass(message);
        }
    }
    public static void fail(String message, boolean isScreenShotNeeded) {
        if(PropertiesUtil.get(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenShotNeeded)
        {
            ExtentManager.getExtentTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
        }
        else {
            fail(message);
        }
    }
    public static void skip(String message, boolean isScreenShotNeeded) {
        if(PropertiesUtil.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenShotNeeded)
        {
            ExtentManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
        }
        else {
            skip(message);
        }
    }

}
