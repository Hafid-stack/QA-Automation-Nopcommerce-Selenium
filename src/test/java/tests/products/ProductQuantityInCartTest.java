package tests.products;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductsPage;
import pages.ViewCartPage;
import utilitypages.CartItem;

import java.util.List;

public class ProductQuantityInCartTest extends BaseTest {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
    @Test(description = "Test Case 13: Verify Product quantity in Cart")
    public void productQuantityInCartTest(){
        log("Product correct quantity test started");
        HomePage homePage = new HomePage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        ViewCartPage viewCartPage=new ViewCartPage(driver);
        //3. Verify that home page is visible successfully
        //URL check
        String expectedLink ="https://automationexercise.com/";
        String actualLink=driver.getCurrentUrl();
        Assert.assertEquals(actualLink, expectedLink,"Home page failed");
        log("Home page successfully loaded, check one");
        //Title check
        String expectedTitle=driver.getTitle();
        String actualTitle="Automation Exercise";
        Assert.assertEquals(expectedTitle, actualTitle,"Home page failed");
        log("Home page successfully loaded, check two");


        //4. Click 'View Product' for any product on home page
        homePage.clickHomePageViewProductBtn("1");
        log("First product Add to cart button clicked");

        //5. Verify product detail is opened
        productDetailPage.isProductInCartDetailDisplayed();
        log("Products details present, checked");

        //6. Increase quantity to 4
        productDetailPage.increaseProductQuantity("4");
        log("Products quantity in cart increased to 4");

        //7. Click 'Add to cart' button
        productDetailPage.clickAddToCartBtn();
        log("Add to cart button clicked");

//        //8. Click 'Continue Shopping' button
//        productDetailPage.clickContinueShoppingBtn();
//        log("Continue shopping button clicked");
//        Impossible you need to re-click add product

        //8. Click 'View Cart' button
        productDetailPage.clickAlertViewCartBtn();
        log("View cart button clicked");

        //9. Verify that product is displayed in cart page with exact quantity
        Assert.assertEquals(viewCartPage.getProductQuantity(),"4","Products quantity in cart incorrect");
        log("Products quantity in cart check");

        log("Test passed");
    }
}
