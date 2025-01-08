package com.vijay.testing.tests.vwoLogin;

import com.vijay.testing.pages.LoginPage_POM;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLogin_POM {

    @Description("Verify that invalid login gives error message")
    @Test
    public void testLoginNegativeVWO(){

        WebDriver driver = new EdgeDriver();
        LoginPage_POM loginPagePom = new LoginPage_POM(driver);
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();

        String error_message = loginPagePom.loginIntoVWOInvalidCredentials("admin","123");
        Assert.assertEquals(error_message,"Your email, password, IP address or location did not match");

        driver.quit();
    }
}
