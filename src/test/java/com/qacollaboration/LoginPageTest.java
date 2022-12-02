package com.qacollaboration;

import com.qacollaboration.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class LoginPageTest extends BaseTest{
    private LoginPageTest()
    {

    }

    @Test
    public void Test1()
    {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
    }

    @Test
    public void Test2()
    {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
    }
}
