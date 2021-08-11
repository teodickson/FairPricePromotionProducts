package com.shopee.module;

import org.apache.log4j.Logger;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.shopee.constant.Image.BASE_PATH;
import static com.shopee.constant.Path.BASE_URL;

public class BaseClass {
    public static WebDriver driver;
    public static Logger log = Logger.getLogger("com.fairprice.automation");
    BufferedImage expImage;
    BufferedImage actImage;
    BufferedImage markedImage;
    ImageDiffer imgDiff;
    ImageDiff diff;
    SoftAssert softAssert = new SoftAssert();

    public BaseClass(WebDriver driver) {
        BaseClass.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @Step
    protected void clickOn(WebElement element) {
        try{
            element.click();
            log.info("user clicks on element : " + element);
        } catch(Exception e) {
            System.out.println(e);
            clickElementViaJSExecutor(element);
        }
    }

    protected void clickElementViaJSExecutor(WebElement element) {
        log.warn("Element is not clickable, try to click with JSExecutor");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
        log.info("click on " + element + " via JSExecutor successful");
    }

    @Step
    protected void wait(int milliseconds) {
        try{
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void navigateToPage(String module) {
        try{
            driver.get(BASE_URL + module);
        } catch(Exception e) {
            driver.get("https://www.fairprice.com.sg/" + module);
        }
        log.info("Navigate to " + module + " successfully");
    }

    @Step
    public void scrollToBottomPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }

    @Step
    public void assertImagesAreIdentical(String base, String actual, String result) throws IOException {
        expImage = ImageIO.read(new File(System.getProperty("user.dir") + base));
        actImage = ImageIO.read(new File(System.getProperty("user.dir") + "/screenshots/" + actual + ".png"));
        imgDiff = new ImageDiffer();
        diff = imgDiff.makeDiff(actImage,expImage);
        if(diff.hasDiff()) {
            markedImage = diff.getMarkedImage();
            ImageIO.write(markedImage,"PNG",new File(System.getProperty("user.dir") + result));
        }
        softAssert.assertFalse(diff.hasDiff(),"Check if the images are identical");
        softAssert.assertAll();
        System.out.println("Checking images are identical");
    }

    @Step
    public void runVisualTest(String testCase,ITestContext context) throws IOException {
        String base = BASE_PATH + testCase + "/png";
        String diff = "/screenshots/" + testCase + "_Diff.png";
        context.setAttribute("method",testCase);
        context.setAttribute("base",base);
        context.setAttribute("diff",diff);
        assertImagesAreIdentical(base,testCase,diff);
    }

    @Step
    protected void takeScreenshotOfElement(WebElement element, String testCase) throws IOException {
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(driver,element);
        ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir") + "/screenshots/" + testCase + ".png"));
        System.out.println("Take screenshot and save...");
    }

    @Step
    protected void takeScreenshotOfElementsss(WebElement element, String testCase) throws IOException {
        Screenshot screenshot = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver,element);
        ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir") + "/screenshots/" + testCase + ".png"));
        System.out.println("Take screenshot and save...");
    }

}
