package tests.products;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;

public class ViewProductsBybrandTest extends BaseTest {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//7. On left sidebar, click on any other brand link
//8. Verify that user is navigated to that brand page and can see products
    @Test(description = "Test Case 19: View & Cart Brand Products")
    public void viewProductsBybrandTest(){

        HomePage homePage = new HomePage(driver);
        //3. Click on 'Products' button
        ProductsPage productsPage = homePage.clickProductsBtnAndGetProductsPage();
        //4. Verify that Brands are visible on left sidebar
        Assert.assertTrue(productsPage.getLeftSideBarPage().getLeftSideBarBrandsHeaderText().contains("BRANDS"),"Brands are not present");
        //5. Click on any brand name
        //function internally clicks a randon brand and return its value
        String targetedBrandName = productsPage.getLeftSideBarPage().clickRandomBrand();
       //6. Verify that user is navigated to brand page and brand products are displayed
        //String actualTitle =productsPage.getProductsPageTitleAfterClickingBrand(targetedBrandName);
        driver.navigate().refresh();
        driver.navigate().refresh();

        Assert.assertTrue(productsPage.getTheFixedProductsPageTitle().contains(targetedBrandName),"Brand mismatch. Expected: [" +
                        targetedBrandName +
                        "] Title: [" +
                productsPage.getTheFixedProductsPageTitle() +
                        "]"
        );

    }
}
