package com.shopee.feature;

import com.shopee.module.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.shopee.constant.Path.PROMOTIONS;

public class HomePageTest extends BaseTest{

    @BeforeMethod
    public void navigateToGivenPage() { user.homepage().navigateToPage(PROMOTIONS);}

    @Test
    public void test() {
        user.homepage().clickOnXButton();
    }
}
