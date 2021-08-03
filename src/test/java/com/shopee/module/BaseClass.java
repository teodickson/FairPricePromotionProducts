package com.shopee.module;

import org.apache.log4j.Logger;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.shopee.constant.Path.BASE_URL;

public class BaseClass {
    public static WebDriver driver;
    public static Logger log = Logger.getLogger("com.fairprice.automation");

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

    @Step
    public void navigateToPage(String module) {
        try{
            driver.get(BASE_URL + module);
        } catch(Exception e) {
            driver.get("https://www.fairprice.com.sg/" + module);
        }
        log.info("Navigate to " + module + " successfully");
    }

    @Step
    public void scrollToBottomPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }

}
