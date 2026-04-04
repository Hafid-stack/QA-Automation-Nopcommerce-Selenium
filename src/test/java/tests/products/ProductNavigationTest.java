package tests.products;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ProductNavigationTest extends BaseTest {
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
    @Test(description = "Test Case 8: Verify All Products and product detail page")
    public void productNavigationTest() {
        log("Product navigation/detail test started");
        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage=new ProductsPage(driver);
        ProductDetailPage productDetailPage=new ProductDetailPage(driver);
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

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        String url="https://automationexercise.com/products";
        wait.until(ExpectedConditions.urlContains(url));
        Assert.assertTrue(driver.getCurrentUrl().contains(url),"Products page failed");
        log("Products page successfully loaded, URL check");

        Assert.assertEquals(productsPage.getProductsPageTitle(),"ALL PRODUCTS","Products page failed");
        log("Products page successfully loaded, Title check");

        //6. The products list is visible
        //7. Click on 'View Product' of first product
        //might need to add some sort of scrool
        productsPage.clickProductByNumber("1");
        log("First product successfully clicked");

        //8. User is landed to product detail page

        Assert.assertTrue(driver.getTitle().contains("Automation Exercise - Product Details"),"First product page failed");
        log("First product successfully loaded, Title check");
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/product_details/1"),"First product page failed");
        log("First product successfully loaded, URL check");

        //9. Verify that product detail is visible: product name, category, price, availability, condition, brand
        Assert.assertTrue(productDetailPage.getProductName().contains("Blue Top"),"First product page failed");
        log("Product name, check");
        Assert.assertTrue(productDetailPage.getProductCategory().contains("Category: Women > Tops"),"First product page failed");
        log("Product category, check");
        Assert.assertTrue(productDetailPage.getProductPrice().contains("Rs. 500"),"First product page failed");
        log("Product price, check");
        Assert.assertTrue(productDetailPage.getProductAvailability().contains("Availability: In Stock"),"First product page failed");
        log("Product availability, check");
        Assert.assertTrue(productDetailPage.getProductCondition().contains("Condition: New"),"First product page failed");
        log("Product condition, check");
        Assert.assertTrue(productDetailPage.getProductBrand().contains("Brand: Polo"),"First product page failed");
        log("Product brand, check");

        log("Test Passed");

    }
}
