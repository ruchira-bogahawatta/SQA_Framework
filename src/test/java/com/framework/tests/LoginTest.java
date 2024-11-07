package com.framework.tests;

import com.framework.pages.LoginPage;
import com.framework.util.CustomDataProv;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    private LoginPage loginPage;

    @Test(dataProvider = "loginCredentials",  dataProviderClass = CustomDataProv.class)
    public void ValidLoginCredentials(String userEmail, String password, String expectedURL) {
        Reporter.log("======Login to application with a valid registered user======", true);
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.loginUser(userEmail, password);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedURL, "User was not redirected to the account page after login.");
    }

}
