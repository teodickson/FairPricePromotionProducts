package com.fairprice.page;

import org.openqa.selenium.WebDriver;

public class User {
    WebDriver driver;

    public User(WebDriver driver) {
        this.driver = driver;
    }

    public PromotionsPage promotionsPage() { return new PromotionsPage(driver);}
}
