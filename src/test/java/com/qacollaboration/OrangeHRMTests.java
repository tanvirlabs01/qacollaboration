package com.qacollaboration;

import com.qacollaboration.annotation.FrameworkAnnotation;
import com.qacollaboration.enums.CategoryType;
import com.qacollaboration.pages.OrangeHRMLoginPage;
import com.qacollaboration.utils.DataProviderUtils;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.HashMap;

public class OrangeHRMTests extends BaseTest{
    private OrangeHRMTests()
    {

    }
    @FrameworkAnnotation(author = {"Tanvir","Ahmed"},category = {CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
    @Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class )
    //@Test
    public void loginLogoutTest(HashMap<String,String> testData) throws Exception {
        String title = new OrangeHRMLoginPage()
                .enterUserName(testData.get("username"))
                .enterPassword(testData.get("password"))
                .clickLogin()
                .clickWelcome()
                .clickLogOut()
                .getTitle();

        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

    @Test
    public void newTest(HashMap<String,String> testData) throws Exception {
        String title = new OrangeHRMLoginPage()
                .enterUserName(testData.get("username"))
                .enterPassword(testData.get("password"))
                .clickLogin()
                .clickWelcome()
                .clickLogOut()
                .getTitle();

        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }
}
