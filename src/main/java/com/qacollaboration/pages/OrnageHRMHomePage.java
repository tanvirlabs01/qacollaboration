package com.qacollaboration.pages;

import com.qacollaboration.enums.WaitStrategy;
import org.openqa.selenium.By;

public class OrnageHRMHomePage extends BasePage{
    private final By link = By.xpath("//li[@class='oxd-userdropdown']");
    private final By logOut = By.linkText("Logout");

    public OrnageHRMHomePage clickWelcome() throws Exception {
        //WebDriverWait webDriverWait = new WebDriverWait(DriverManagement.getDriver(), Duration.of(10, ChronoUnit.SECONDS));
        //webDriverWait.until(d->d.findElement(link).isDisplayed());
        //DriverManagement.getDriver().findElement(link).click();
        click(link, WaitStrategy.PRESENCE, "Welcome Dropdown");
        return this;
    }
    public OrangeHRMLoginPage clickLogOut() throws Exception {
        click(logOut, WaitStrategy.PRESENCE, "Logout Button");
        return new OrangeHRMLoginPage();
    }
}
