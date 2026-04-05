package tests.onetimers;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import utilitypages.FooterPage;

import java.awt.*;

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
public class SubscriptionTest extends BaseTest {

    @Test(description = "Test Case 10: Verify Subscription in home page")
    public void subscriptionTest(){
        log("Subscription test started");
        HomePage homePage = new HomePage(driver);
        FooterPage footerPage = new FooterPage(driver);
        //3. Verify that home page is visible successfully
        String expectedLink ="https://automationexercise.com/";
        String actualLink=driver.getCurrentUrl();
        Assert.assertEquals(actualLink, expectedLink,"Home page failed");
        log("Home page successfully loaded, Url check");
        //Title check
        String expectedTitle=driver.getTitle();
        String actualTitle="Automation Exercise";
        Assert.assertEquals(expectedTitle, actualTitle,"Home page failed");
        log("Home page successfully loaded, Tile check");

        //4. Scroll down to footer
        WebElement element = driver.findElement(footerPage.subscriptionLocation());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        //5. Verify text 'SUBSCRIPTION'
        Assert.assertTrue(footerPage.getFooterSubscriptionText().contains("SUBSCRIPTION"), "Footer subscription failed");
        log("Subscription, text check");

        //6. Enter email address in input and click arrow button
        footerPage.typeFooterSubscriptionText("testemail@gmail.com");
        log("Test email typed");
        footerPage.clickFooterSubscriptionArrow();
        log("Arrow clicked");

        Assert.assertTrue(footerPage.getFooterSubscriptionAlert().contains("You have been successfully subscribed!"), "Footer subscription alert failed");
        log("Subscription alert, text check");

        log("Test passed");

    }


}
