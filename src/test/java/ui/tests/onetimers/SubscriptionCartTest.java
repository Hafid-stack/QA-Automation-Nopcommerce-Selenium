package ui.tests.onetimers;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilitypages.FooterPage;

public class SubscriptionCartTest extends BaseTest {
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
    @Test(description = "Test Case 11: Verify Subscription in Cart page")
    public void subscriptionCartTest(){
        log("Subscription in cart test started");
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

        //4. Click 'Cart' button
        homePage.clickCartButtom();
        log("Cart button clicked");
        //5. Scroll down to footer
        WebElement element = driver.findElement(footerPage.subscriptionLocation());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        //6. Verify text 'SUBSCRIPTION'
        Assert.assertTrue(footerPage.getFooterSubscriptionText().contains("SUBSCRIPTION"), "Footer subscription failed");
        log("Subscription, text check");

        //7. Enter email address in input and click arrow button
        footerPage.typeFooterSubscriptionText("testemail@gmail.com");
        log("Test email typed");
        footerPage.clickFooterSubscriptionArrow();
        log("Arrow clicked");

        //8. Verify success message 'You have been successfully subscribed!' is visible

        Assert.assertTrue(footerPage.getFooterSubscriptionAlert().contains("You have been successfully subscribed!"), "Footer subscription alert failed");
        log("Subscription alert, text check");

        log("Test passed");


    }
}
