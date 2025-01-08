package com.vijay.testing.tests.sampleTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium2 {

    @Test
    public  void test_VWO_login(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com");
        driver.quit();
    }
}
