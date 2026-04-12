package tests.products;

import base.BaseTest;
import flows.AddProductToCartFlow;
import flows.RegisterUserFlow;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ViewCartPage;

public class RemoveProductFromCartTest extends BaseTest {


//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
    @Test(description = "Test Case 17: Remove Products From Cart")
    public void removeProductFromCartTest(){

        AddProductToCartFlow addProductToCartFlow=new AddProductToCartFlow(driver);
        RegisterUserFlow registerUserFlow=new RegisterUserFlow(driver);
        //3. Verify that home page is visible successfully
        Assert.assertTrue(assertHonePageIsLoaded(),"Home page is not loaded");
        //4. Add products to cart
        //5. Click 'Cart' button
        ViewCartPage viewCartPage=addProductToCartFlow.getViewCartPage("4");
        //6. Verify that cart page is displayed

        int itemsIncart=viewCartPage.getNumberOfProductsInCart();
        Assert.assertTrue(itemsIncart>0,"Cart has no visible product");
        //7. Click 'X' button corresponding to particular product
        viewCartPage.clickItemInCartDeleteBtn();
        driver.navigate().refresh();
        //8. Verify that product is removed from the cart
        int itemsIncart2=viewCartPage.getNumberOfProductsInCart();
        System.out.println(itemsIncart2);
        Assert.assertTrue(  itemsIncart2==0,"Cart has visible product");

        Assert.assertTrue(viewCartPage.getCartIsEmptyText().contains("Cart is empty"));


        log("Test passed");
    }
}
