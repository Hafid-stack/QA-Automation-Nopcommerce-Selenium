package tests.products;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductsPage;
import pages.ViewCartPage;

public class AddProductInCartTest extends BaseTest {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
    @Test(description = "Test Case 12: Add Products in Cart")
    public void addProductInCartTest()
    {
        log("Product navigation/detail test started");
        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage=new ProductsPage(driver);
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

        //4. Click on 'Products' button
        homePage.clickProductsButton();
        log("Products button clicked");

        //5. Hover over first product and click 'Add to cart'
        productsPage.clickAddToCartButton("1");
        log("First product Add to cart button clicked");

        //7. Click 'Continue Shopping' button
        productsPage.clickContinueShoppingButton();

        //7. Hover over second product and click 'Add to cart'
        productsPage.clickAddToCartButton("2");
        log("Second product Add to cart button clicked");
        //8. Click 'View Cart' button

        productsPage.clickViewCartButton();
        log("Continue shopping button clicked");

        //9. Verify both products are added to Cart
        Assert.assertEquals(viewCartPage.getNumberOfProductsInCart(),2,"Verification failed products are not present in the cart");
        log("Products in cart checked");

        //10. Verify their prices, quantity and total price


    }
}
