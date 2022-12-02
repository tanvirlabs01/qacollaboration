package com.qacollaboration.pages;

import com.qacollaboration.enums.WaitStrategy;
import com.qacollaboration.extentReports.ExtentLogger;
import com.qacollaboration.factories.ExplicitWaitFactories;
import org.openqa.selenium.By;

public class BasePage {
    protected void click(By by, WaitStrategy waitStrategy, String elementName) throws Exception {
        ExplicitWaitFactories.performedExplicitWait(waitStrategy,by).click();
        ExtentLogger.pass(elementName+"is Clicked",true);
    }

    protected void typeText(By by, String value,WaitStrategy waitStrategy,String elementName) throws Exception {
        ExplicitWaitFactories.performedExplicitWait(waitStrategy,by).sendKeys(value);
        ExtentLogger.pass(value+"is enter successfully in"+elementName,true);
    }

}
