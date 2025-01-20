package com.vijay.testing.tests.vwoLogin;

import com.vijay.testing.base.CommonToALLTest;
import com.vijay.testing.driver.DriverManager;
import com.vijay.testing.pages.vwo.DashboardPage_POM;
import com.vijay.testing.pages.vwo.LoginPage_POM;
import com.vijay.testing.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_POM extends CommonToALLTest {

    @Description("Verify that invalid login gives error message")
    @Test
    public void testLoginNegativeVWO(){

//        WebDriver driver = DriverManager.getDriver();
//        driver.get("https://app.vwo.com");
//      driver.manage().window().maximize();

        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
        String error_message = loginPagePom.loginIntoVWOInvalidCredentials(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));
        Assert.assertEquals(error_message, PropertiesReader.readKey("error_message"));

//        driver.quit();
    }

    @Description("Verify that valid login, goes to dashboard page")
    @Test
    public void testLoginPositiveVWO(){
        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
        loginPagePom.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashboardPage_POM dashboardPage_pom = new DashboardPage_POM(DriverManager.getDriver());
        String loggedInUserName = dashboardPage_pom.loggedInUserName();

        assertThat(loggedInUserName).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedInUserName, PropertiesReader.readKey("expected_username"));
    }
}
