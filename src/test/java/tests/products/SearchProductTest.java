package tests.products;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductsPage;

import java.util.List;

public class SearchProductTest extends BaseTest {
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
    @Test(description = "Test Case 9: Search Product")
    public void searchProductTest(){
        log("Product Search test started");
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

        Assert.assertEquals(productsPage.getTheFixedProductsPageTitle(),"ALL PRODUCTS","Products page failed");
        log("Products page successfully loaded, Title check");

        //6. Enter product name in search input and click search button
        productsPage.typeProductNameInsEARCH("Blue Top");
        productsPage.clickSearchButton();
        //7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(productsPage.isProductsListDisplayed(), "Products list container is not visible");
        log("Products page successfully loaded searched products, check");

        //8. Verify all the products related to search are visible
        List<WebElement> products = productsPage.getProductElements();
        boolean isFound = false;

        for(WebElement element : products) {
            if(element.getText().equals("Blue Top")) {
                isFound = true;
                break;
            }
        }
        Assert.assertTrue(isFound, "Product 'Blue Top' not found!");
        log("Search Product successfully visible, product title check");

        log("Test passed");

    }


}
