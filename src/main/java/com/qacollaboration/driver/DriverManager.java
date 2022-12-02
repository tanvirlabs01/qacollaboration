package com.qacollaboration.driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class DriverManager {
    /*
    private static ThreadLocal<WebDriver> dr = ThreadLocal.withInitial(()->{
       System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
       return new ChromeDriver();
   });
    */
    private DriverManager()
    {

    }
    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();
    public static WebDriver getDriver()
    {
        return dr.get();
    }
    static void setDriver(WebDriver webDriver)
    {
        if(Objects.nonNull(webDriver))
        {
            dr.set(webDriver);
        }
    }
    static void unload()
    {
        dr.remove();
    }
}
