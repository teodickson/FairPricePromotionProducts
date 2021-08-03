package com.shopee.module;

import org.apache.log4j.Logger;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    public static Logger log = Logger.getLogger("com.shopee.automation");

    public BaseClass(WebDriver driver) {
        BaseClass.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @Step
    protected void clickOn(WebElement element) {
        try{
            element.click();
            log.info("user clicks on element : " + element);
        } catch(Exception e) {
            System.out.println(e);
            clickElementViaJSExecutor(element);
        }
    }

    protected void clickElementViaJSExecutor(WebElement element) {
        log.warn("Element is not clickable, try to click with JSExecutor");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
        log.info("click on " + element + " via JSExecutor successful");
    }

    @Step
    protected void wait(int milliseconds) {
        try{
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}
