package com.shopee.module;

import com.shopee.feature.BaseTest;
import io.qameta.allure.Step;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PromotionsPage extends BaseClass {
    WebDriver driver;
    public PromotionsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@data-impressiontype='PRODUCT_IMPRESSION']//span[@weight='black']")
    protected List<WebElement> promotion_price;
    @FindBy(xpath = "//div[@data-impressiontype='PRODUCT_IMPRESSION']//span[@weight='normal']")
    protected List<WebElement> promotion_item;
    @FindBy(xpath = "//span[text()='Promotions']/../../span")
    protected WebElement numOfProducts;

    public List<Float> getPromotionPrice() {
        List<Float> price = new ArrayList<>();
        for (WebElement pp : promotion_price) {
            price.add(Float.parseFloat(pp.getText().replace("$","")));
        }
        return price;
    }

    public List<String> getItemName() {
        List<String> name = new ArrayList<>();
        for (WebElement pi : promotion_item) {
            name.add(pi.getText());
        }
        return name;
    }

    public void printResult(List<String> item, List<Float> price) {
        System.out.println("\n\n************* NTUC Fair Price Promotion *************");
        System.out.println("******************** " + this.getDate() + " ********************");
        for(int r=0; r<item.size();r++) {
            System.out.printf("%d %-50s %s", (r+1) ,item.get(r), "$ "+price.get(r));
            System.out.println("\n");
        }
        log.info("Result is successfully printed out...");
    }

    private LocalDate getDate() {
        return LocalDate.now();
    }

    public void scrollUntilBottom() {
        try{
            while(numberOfProducts() != promotion_item.size()){
                scrollToBottomPage();
                System.out.println("number of product : " + numberOfProducts());
                System.out.println("current item size : "+promotion_item.size());
                System.out.println("can still be scrolled...");
            }
        } catch(Exception e) { log.warn("Time out"); }
    }

    protected int numberOfProducts() {
        return Integer.parseInt(numOfProducts.getText().replace(" products",""));
    }
}
