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

    @Test(description = "Test Case 14: Place Order: Register while Checkout")
    public void registerWhileCheckOut() {
        log("Register While Checkout test started");
        AddProductToCartFlow addProductToCartFlow = new AddProductToCartFlow(driver);
        RegisterUserFlow registerUserFlow = new RegisterUserFlow(driver);
        Assert.assertTrue(assertHonePageIsLoaded(),"Home page is not loaded");
        ViewCartPage viewCartPage = addProductToCartFlow.getViewCartPage("2",driver);
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

        ViewCartPage viewCartPage2=addProductToCartFlow.getViewCartPage2();
        CheckOutPage checkOutPage= addProductToCartFlow.getCheckOutPagePage();
        PaymentPage paymentPage= addProductToCartFlow.getPaymentPage("message order order order");

        PaymentDonePage paymentDonePage= addProductToCartFlow.getPaymentDonePage("tester card","12312312312312","123","13/02","2004");
        DeletedAccount deletedAccount=addProductToCartFlow.getDeletedAccount();
        HomePage homePage2=addProductToCartFlow.getHomePage();





    }
}
