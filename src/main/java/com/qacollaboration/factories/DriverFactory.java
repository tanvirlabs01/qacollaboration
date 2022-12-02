package com.qacollaboration.factories;

import com.qacollaboration.enums.ConfigProperties;
import com.qacollaboration.utils.PropertiesUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private DriverFactory() {

    }
    public static WebDriver getDriver(String browser,String version) throws MalformedURLException {
        WebDriver driver = null;
        if(browser.equalsIgnoreCase("chrome"))
        {
            if(PropertiesUtil.get(ConfigProperties.RUNMODE).equalsIgnoreCase("remote"))
            {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName("chrome");
                desiredCapabilities.setVersion(version);
                driver = new RemoteWebDriver(new URL(PropertiesUtil.get(ConfigProperties.SELENIUMGRIDURL)),desiredCapabilities);
            }
            else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

            }
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            if(PropertiesUtil.get(ConfigProperties.RUNMODE).equalsIgnoreCase("remote"))
            {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName("firefox");
                desiredCapabilities.setVersion(version);
                driver = new RemoteWebDriver(new URL(PropertiesUtil.get(ConfigProperties.SELENIUMGRIDURL)),desiredCapabilities);
                }
            }
            else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        return driver;
    }
}
