package com.fairprice.test;

import com.fairprice.page.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    public WebDriver driver;
    public User user;

    @BeforeTest
    public void beforeTestCase() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        user = new User(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.get("https://www.fairprice.com.sg/");
    }

    @AfterTest
    public void afterTestCase() {
        System.out.println("********************** TEST FINISHED **********************");
        System.out.println("*************** End to End Test Automation ****************");
        driver.quit();
    }
}
