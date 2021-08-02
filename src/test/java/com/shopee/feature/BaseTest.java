package com.shopee.feature;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Method;
import java.sql.Driver;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void beforeTestCase() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://shopee.sg/");
        driver.manage().window().fullscreen();
    }

    @AfterClass
    public void afterTestCase() {
        System.out.println("********************** TEST FINISHED **********************");
        System.out.println("*************** End to End Test Automation ****************");
        driver.quit();
    }
}
