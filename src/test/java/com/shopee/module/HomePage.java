package com.shopee.module;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage extends BaseClass{
    WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @FindBy(css = "div.shopee-popup__close-btn")
    protected WebElement xButton;

    @Step
    public void clickOnXButton() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(xButton));
        clickOn(xButton);
        wait(2000);
    }

    @Step
    public void skipPopUp() {
        //driver.switchTo().
    }
}
