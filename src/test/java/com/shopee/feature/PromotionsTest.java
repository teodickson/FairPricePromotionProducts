package com.shopee.feature;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.shopee.constant.Path.BASE_URL;
import static com.shopee.constant.Path.PROMOTIONS;

public class PromotionsTest extends BaseTest{
    @BeforeMethod
    public void navigateToGivenPage() { user.promotionsPage().navigateToPage(PROMOTIONS);}

    @Test
    public void getPromotionPrice_All() {
        user.promotionsPage().scrollUntilBottom();
        List<Float> promoPrice = user.promotionsPage().getPromotionPrice();
        List<String> item = user.promotionsPage().getItemName();
        user.promotionsPage().printResult(item,promoPrice);
    }

    @Test
    public void getPromotionPrice_By2Free1() {
        user.promotionsPage().navigateToPage(PROMOTIONS+"?tag=buy-2-get-50");
        user.promotionsPage().scrollUntilBottom();
        List<Float> promoPrice = user.promotionsPage().getPromotionPrice();
        List<String> item = user.promotionsPage().getItemName();
        user.promotionsPage().printResult(item,promoPrice);
    }

    @Test
    public void getPromotionPrice_MustBuy() {
        user.promotionsPage().navigateToPage(PROMOTIONS+"?tag=must-buy");
        user.promotionsPage().scrollUntilBottom();
        List<Float> promoPrice = user.promotionsPage().getPromotionPrice();
        List<String> item = user.promotionsPage().getItemName();
        user.promotionsPage().printResult(item,promoPrice);
    }
}
