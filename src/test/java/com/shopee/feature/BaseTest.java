package com.shopee.feature;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTest {
    public WebDriver driver;

    @BeforeTest
    public void beforeTestCase() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://shopee.sg/");
        driver.manage().window().fullscreen();
    }

    @AfterTest
    public void afterTestCase() {
        System.out.println("********************** TEST FINISHED **********************");
        System.out.println("*************** End to End Test Automation ****************");
        driver.quit();
    }
}
