package com.fairprice.test;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;


import static com.fairprice.constant.Path.*;

public class PromotionsTest extends BaseTest {
    @BeforeMethod
    public void navigateToGivenPage() { user.promotionsPage().navigateToPage(PROMOTIONS);}

    @Test
    public void getAllPromotionGroupUrl() {
        user.promotionsPage().getPromotionGroup();
        user.promotionsPage().clickOnPromotionGroupsAndGetUrl();
    }

    @Test
    public void getPromotionPrice_All() {
        user.promotionsPage().scrollUntilBottom();
        List<Float> promoPrice = user.promotionsPage().getPromotionPrice();
        List<String> item = user.promotionsPage().getItemName();
        user.promotionsPage().printResult(item,promoPrice);
    }

    @Test
    public void getPromotionPrice_By2Free1() {
        user.promotionsPage().navigateToPage(PROMOTIONS + BUY_2_GET_1);
        user.promotionsPage().scrollUntilBottom();
        List<Float> promoPrice = user.promotionsPage().getPromotionPrice();
        List<String> item = user.promotionsPage().getItemName();
        user.promotionsPage().printResult(item,promoPrice);
    }

    @Test
    public void getPromotionPrice_MustBuy() {
        user.promotionsPage().navigateToPage(PROMOTIONS + MUST_BUY);
        user.promotionsPage().scrollUntilBottom();
        List<Float> promoPrice = user.promotionsPage().getPromotionPrice();
        List<String> item = user.promotionsPage().getItemName();
        user.promotionsPage().printResult(item,promoPrice);
    }

    @Test
    public void getPromotionPrice_Wednesday() {
        user.promotionsPage().navigateToPage(PROMOTIONS + WEDNESDAY);
        user.promotionsPage().scrollUntilBottom();
        List<Float> promoPrice = user.promotionsPage().getPromotionPrice();
        List<String> item = user.promotionsPage().getItemName();
        user.promotionsPage().printResult(item,promoPrice);
    }

    @Test
    public void getPromotionPrice_PWP(Method method, ITestContext context) throws IOException {
        user.promotionsPage().navigateToPage(PROMOTIONS + PWP);
        user.promotionsPage().scrollUntilBottom();
        List<Float> promoPrice = user.promotionsPage().getPromotionPrice();
        List<String> item = user.promotionsPage().getItemName();
        user.promotionsPage().printResult(item,promoPrice);
        user.promotionsPage().takeScreenshotOfProduct(method.getName());
        user.promotionsPage().runVisualTest(method.getName(),context);
    }

    @Test
    public void getPromotionPrice_WeeklyDeals() {
        user.promotionsPage().navigateToPage(PROMOTIONS + WEEKLY_DEALS);
        user.promotionsPage().scrollUntilBottom();
        List<Float> promoPrice = user.promotionsPage().getPromotionPrice();
        List<String> item = user.promotionsPage().getItemName();
        user.promotionsPage().printResult(item,promoPrice);
    }

    @Test
    public void getPromotionPrice_FreshPicks() {
        user.promotionsPage().navigateToPage(PROMOTIONS + FRESH_PICKS);
        user.promotionsPage().scrollUntilBottom();
        List<Float> promoPrice = user.promotionsPage().getPromotionPrice();
        List<String> item = user.promotionsPage().getItemName();
        user.promotionsPage().printResult(item,promoPrice);
    }

    @Test
    public void getPromotionPrice_DigitalClubExclusive() {
        user.promotionsPage().navigateToPage(PROMOTIONS + DIGITAL_CLUB_EXCLUSIVE);
        user.promotionsPage().scrollUntilBottom();
        List<Float> promoPrice = user.promotionsPage().getPromotionPrice();
        List<String> item = user.promotionsPage().getItemName();
        user.promotionsPage().printResult(item,promoPrice);
    }

    @Test
    public void getPromotionPrice_MarkDownToClear() {
        user.promotionsPage().navigateToPage(PROMOTIONS + MARKDOWN_TO_CLEAR);
        user.promotionsPage().scrollUntilBottom();
        List<Float> promoPrice = user.promotionsPage().getPromotionPrice();
        List<String> item = user.promotionsPage().getItemName();
        user.promotionsPage().printResult(item,promoPrice);
    }
    @Test
    public void getPromotionPrice_ValueDeals() {
        user.promotionsPage().navigateToPage(PROMOTIONS + VALUE_DEALS);
        user.promotionsPage().scrollUntilBottom();
        List<Float> promoPrice = user.promotionsPage().getPromotionPrice();
        List<String> item = user.promotionsPage().getItemName();
        user.promotionsPage().printResult(item,promoPrice);
    }

    @Test
    public void getPromotionPrice_SupportLocal() {
        user.promotionsPage().navigateToPage(PROMOTIONS + SUPPORT_LOCAL);
        user.promotionsPage().scrollUntilBottom();
        List<Float> promoPrice = user.promotionsPage().getPromotionPrice();
        List<String> item = user.promotionsPage().getItemName();
        user.promotionsPage().printResult(item,promoPrice);
    }

    @Test
    public void getPromotionPrice_CartonDeals() {
        user.promotionsPage().navigateToPage(PROMOTIONS + CARTON_DEALS);
        user.promotionsPage().scrollUntilBottom();
        List<Float> promoPrice = user.promotionsPage().getPromotionPrice();
        List<String> item = user.promotionsPage().getItemName();
        user.promotionsPage().printResult(item,promoPrice);
    }

    @Test
    public void getPromotionPrice_FreeGiftWithPurchase() {
        user.promotionsPage().navigateToPage(PROMOTIONS + FREE_GIFT_WITH_PURCHASE);
        user.promotionsPage().scrollUntilBottom();
        List<Float> promoPrice = user.promotionsPage().getPromotionPrice();
        List<String> item = user.promotionsPage().getItemName();
        user.promotionsPage().printResult(item,promoPrice);
    }
}
