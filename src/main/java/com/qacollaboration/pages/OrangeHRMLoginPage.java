package com.qacollaboration.pages;

import com.qacollaboration.driver.DriverManager;
import com.qacollaboration.enums.WaitStrategy;
import org.openqa.selenium.By;
public final class OrangeHRMLoginPage extends BasePage {
    private final By textBoxUserName = By.xpath("//input[@name='username']");
    private final By textBoxPassword = By.xpath("//input[@name='password']");
    private final By loginButton = By.xpath("//button");

    public OrangeHRMLoginPage enterUserName(String userName) throws Exception {
        typeText(textBoxUserName,userName, WaitStrategy.PRESENCE,"UserName");
        return this;
    }
    public OrangeHRMLoginPage enterPassword(String password) throws Exception {
        typeText(textBoxPassword,password,WaitStrategy.PRESENCE,"Password");
        return this;
    }
    public OrnageHRMHomePage clickLogin() throws Exception {
        click(loginButton,WaitStrategy.PRESENCE, "Login Button");
        return new OrnageHRMHomePage();
    }
    public String getTitle()
    {
        return DriverManager.getDriver().getTitle();
    }

}
