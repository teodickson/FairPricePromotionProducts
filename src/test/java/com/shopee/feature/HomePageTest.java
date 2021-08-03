package com.shopee.feature;

import com.shopee.module.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{
    HomePage user = new HomePage(driver);
    @Test
    public void test() {
        user.clickOnXButton();
    }
}
