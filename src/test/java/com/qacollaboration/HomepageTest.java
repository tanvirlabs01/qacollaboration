package com.qacollaboration;

import com.qacollaboration.driver.DriverManager;
import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;


public final class HomepageTest extends BaseTest{
    private HomepageTest(){

    }
    @Test
    public void Test3()
    {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - youtube", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();

        assertThat(title)
                .as("Title is null").isNotNull()
                .as("It doesn't contains expected text").containsIgnoringCase("google search")
                                        .matches("\\w.*"+"Google Search")
                                                .hasSizeBetween(15,100);

        List<WebElement> links = DriverManager.getDriver().findElements(By.xpath("//h3"));
        assertThat(links)
                        .hasSize(10)
                                .extracting(WebElement::getText)
                                        .contains("Testing Mini Bytes - YouTube");
    }
}
