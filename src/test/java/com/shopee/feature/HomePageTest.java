package com.shopee.feature;

import com.shopee.module.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{
    @Test
    public void test() {
        user.homepage().clickOnXButton();
    }
}
