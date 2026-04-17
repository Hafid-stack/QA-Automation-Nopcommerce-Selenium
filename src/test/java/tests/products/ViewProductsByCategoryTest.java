package tests.products;

import base.BaseTest;
import flows.AddProductToCartFlow;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryProductsPage;
import utilitypages.LeftSideBarPage;

public class ViewProductsByCategoryTest extends BaseTest {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'

    @Test(description = "Test Case 18: View Category Products")
    public void viewProductsByCategoryTest(){
        AddProductToCartFlow addProductToCartFlow = new AddProductToCartFlow(driver);
        LeftSideBarPage leftSideBarPage=new LeftSideBarPage(driver);
        //3. Verify that categories are visible on left sidebar

        Assert.assertTrue(leftSideBarPage.getLeftSideBarCategoriesHeaderText().contains("CATEGORY"),"Category Products not found");

        //4. Click on 'Women' category
        //5. Click on any category link under 'Women' category, for example: Dress
        CategoryProductsPage categoryProductsPage=addProductToCartFlow.clickAWomenProduct();
        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        Assert.assertTrue(categoryProductsPage.getCategoryHeaderText().contains("WOMEN - TOPS PRODUCTS"));
        //7. On left sidebar, click on any sub-category link of 'Men' category
        CategoryProductsPage categoryProductsPage1=addProductToCartFlow.pickAManProduct();
        //8. Verify that user is navigated to that category page

        Assert.assertTrue(categoryProductsPage1.getCategoryHeaderText().contains("MEN - JEANS PRODUCTS"),"D" +
                "User did not navigate to category page successfully");

        log("Test passed");


    }
}
