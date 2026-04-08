package tests.placeorder;

import base.BaseTest;
import flows.AddProductToCartFlow;
import flows.RegisterUserFlow;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class RegisterWhileCheckOutTest extends BaseTest {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'

//12.Click 'Cart' button
//13. Click 'Proceed To Checkout' button
//14. Verify Address Details and Review Your Order
//15. Enter description in comment text area and click 'Place Order'
//16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//17. Click 'Pay and Confirm Order' button
//18. Verify success message 'Your order has been placed successfully!'
//19. Click 'Delete Account' button
//20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    @Test(description = "Test Case 14: Place Order: Register while Checkout")
    public void registerWhileCheckOut() {
        log("Register While Checkout test started");
        AddProductToCartFlow addProductToCartFlow = new AddProductToCartFlow(driver);
        RegisterUserFlow registerUserFlow = new RegisterUserFlow(driver);
        Assert.assertTrue(assertHonePageIsLoaded(),"Home page is not loaded");
        ViewCartPage viewCartPage = addProductToCartFlow.getViewCartPage("2");
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/view_cart"), "Shopping cart page is not loaded");
        Assert.assertTrue(viewCartPage.getNumberOfProductsInCart()!=1,"Shopping cart page is not loaded");
        log("Shopping cart page is loaded check");
        //could add assertions for the login and register pages
        LoginPage loginPage =addProductToCartFlow.getLoginPage();
        RegisterPage registerPage=registerUserFlow.getRegisterPage("testName","testEmail"+getRandomNumber()+"@gmail.com");
        AccountCreatedPage accountCreatedPage =registerUserFlow.getAccountCreatedPage(
                1,"accountname","password123",
                2002,12,31,
                "adress adress","adress asress asesds",
                "company name","asdasdasd","asdasdasd",
                "asdasdasdas","asdasdasdsad","asdasdasdsad","12321","12345567889");
        Assert.assertEquals(accountCreatedPage.getAccountCreatedText().contains("ACCOUNT CREATED!"),"Account Created Successfully");
        HomePage homePage=registerUserFlow.getHomePage();
        Assert.assertTrue(homePage.getLoggedInAsUserName().equals("testName"),"Logged In as user name is incorrect");
        homePage.clickCartButtom();
        viewCartPage.clickCheckoutBtn();
//12.Click 'Cart' button
//13. Click 'Proceed To Checkout' button
//14. Verify Address Details and Review Your Order
//15. Enter description in comment text area and click 'Place Order'
//16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//17. Click 'Pay and Confirm Order' button
//18. Verify success message 'Your order has been placed successfully!'
//19. Click 'Delete Account' button
//20. Verify 'ACCOUNT DELETED!' and click 'Continue' button

    }
}
