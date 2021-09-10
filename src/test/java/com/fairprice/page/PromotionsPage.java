package com.shopee.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
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
    @FindBy(xpath = "//ul[@class='elements-div']//span")
    protected List<WebElement> promotion_group;
    @FindBy(xpath = "//div[@data-impressiontype='PRODUCT_IMPRESSION']/a[@href]")
    protected List<WebElement> productImage;

    String arrow = "//div[@data-testid='arrow'][@direction='%s']/i";

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

    public void getPromotionGroup() {
        System.out.println("There are " + promotion_group.size() + " promotion groups");
        for(WebElement e : promotion_group) {
            tryToDismissAlert();
            if(e.getText().isEmpty()) {
                swipeTo("right");
            }
            System.out.println("- " + e.getText());
        }
    }

    protected void swipeTo(String direction) {
        try {
            clickOn(driver.findElement(By.xpath(String.format(arrow, direction))));
            wait(1000);
        } catch(NoSuchElementException ignored) {}
    }

    protected void tryToDismissAlert() {
        wait(1000);
        try{
            driver.switchTo().alert().dismiss();
        } catch(NoAlertPresentException ignored) {}

    }

    public void clickOnPromotionGroupsAndGetUrl() {
        swipeTo("left");
        for(WebElement e : promotion_group) {
            if(e.getText().isEmpty()) {
                System.out.println("Now swiping to right...");
                swipeTo("right");
                clickOn(e);
                wait(1000);
            } else {
                clickOn(e);
                wait(1000);
            }
            System.out.println("The url for " + e.getText().toUpperCase().replace(" ","_") + " : " + driver.getCurrentUrl());
        }
    }

    public void takeScreenshotOfProduct(String testCase) throws IOException {
            takeScreenshotOfElementsss(productImage.get(0),testCase);
    }
}
