package com.qacollaboration;

import com.qacollaboration.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

public class BaseTest {

    protected BaseTest()
    {

    }
    @BeforeMethod
    protected void setUp(Object[] data) throws Exception {
        HashMap<String,String> dataMap = (HashMap<String, String>)data[0];
        Driver.initDriver(dataMap.get("browser"),dataMap.get("version"));
    }
    @AfterMethod
    protected void tearDown()
    {
        Driver.quiteDriver();
    }

}
