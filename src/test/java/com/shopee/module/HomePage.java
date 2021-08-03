package com.shopee.module;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class HomePage extends BaseClass{
    WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @FindBy(xpath = "")
    protected WebElement xButton;

    @Step
    public void clickOnXButton() {
        clickOn(xButton);
        wait(2000);
    }
}
