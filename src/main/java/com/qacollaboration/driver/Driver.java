package com.qacollaboration.driver;

import com.qacollaboration.enums.ConfigProperties;
import com.qacollaboration.exceptions.BrowserInvocationFailedException;
import com.qacollaboration.factories.DriverFactory;
import com.qacollaboration.utils.PropertiesUtil;

import java.net.MalformedURLException;
import java.util.Objects;

/**
 * Driver class is responsible for invoking and closing browser
 * November 20, 2022
 * @author Tanvir Ahmed
 * @version 1.0
 * @since 1.0
 */
public final class Driver {
    private Driver()
    {

    }
    public static void initDriver(String browser, String version) {
        if(Objects.isNull(DriverManager.getDriver()))
        {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser,version));
            } catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException("Browser invocation failed. Please check DesiredCapabilities");
            }
            DriverManager.getDriver().get(PropertiesUtil.get(ConfigProperties.URL));
        }
    }
    public static void quiteDriver()
    {
        if(Objects.nonNull(DriverManager.getDriver()))
        {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
