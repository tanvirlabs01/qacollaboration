package com.qacollaboration.factories;

import com.qacollaboration.driver.DriverManager;
import com.qacollaboration.enums.WaitStrategy;
import com.qacollaboration.frameworkconstants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public final class ExplicitWaitFactories {
    private ExplicitWaitFactories() {
    }

    public static WebElement performedExplicitWait(WaitStrategy waitStrategy, By by)
    {
        WebElement webElement = null;
        if(waitStrategy==WaitStrategy.CLICKABLE)
        {
            webElement = new WebDriverWait(DriverManager.getDriver(), Duration.of(FrameworkConstants.getExplicitWait(), ChronoUnit.SECONDS))
            //webDriverWait.until(d->d.findElement(by).isDisplayed());
            .until(ExpectedConditions.presenceOfElementLocated(by));
        }
        else if(waitStrategy==WaitStrategy.PRESENCE)
        {
           webElement = new WebDriverWait(DriverManager.getDriver(), Duration.of(FrameworkConstants.getExplicitWait(), ChronoUnit.SECONDS))
            //webDriverWait.until(d->d.findElement(by).isDisplayed());
            .until(ExpectedConditions.presenceOfElementLocated(by));
        }
        else if(waitStrategy==WaitStrategy.VISIBLE)
        {
            webElement = new WebDriverWait(DriverManager.getDriver(), Duration.of(FrameworkConstants.getExplicitWait(), ChronoUnit.SECONDS))
            //webDriverWait.until(d->d.findElement(by).isDisplayed());
            .until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        else if(waitStrategy==WaitStrategy.NONE)
        {
            webElement = DriverManager.getDriver().findElement(by);
        }
        return webElement;
    }
}
