package com.shopee.module;

import org.openqa.selenium.WebDriver;

public class User {
    WebDriver driver;

    public User(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage homepage() { return new HomePage(driver);}
}
