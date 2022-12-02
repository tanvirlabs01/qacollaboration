package com.qacollaboration.utils;

import com.qacollaboration.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenShotUtils {
    private ScreenShotUtils()
    {

    }
    public static String getBase64Image()
    {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
