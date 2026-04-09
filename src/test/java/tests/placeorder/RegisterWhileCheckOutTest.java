package tests.placeorder;

import base.BaseTest;
import flows.AddProductToCartFlow;
import flows.RegisterUserFlow;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import models.AddressDelivery;

public class RegisterWhileCheckOutTest extends BaseTest {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'

    @Test(description = "Test Case 14: Place Order: Register while Checkout")
    public void registerWhileCheckOut() {
        log("Register While Checkout test started");
        /* Initiate flows */
        AddProductToCartFlow addProductToCartFlow = new AddProductToCartFlow(driver);
        RegisterUserFlow registerUserFlow = new RegisterUserFlow(driver);
        //Assert we are at home page
        Assert.assertTrue(assertHonePageIsLoaded(),"Home page is not loaded");
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"),"Place Order is not displayed");
        log("home page loaded check");

        //Add product from home page and click view cart Btn from the popup alert
        ViewCartPage viewCartPage = addProductToCartFlow.getViewCartPage("2");

        //Asser we are at the correct view cart page
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/view_cart"), "Shopping cart page is not loaded URL");
        Assert.assertTrue(viewCartPage.getNumberOfProductsInCart()!=0,"Shopping cart page has no products in Cart");
        log("Shopping cart page is loaded check");




        //could add assertions for the login and register pages
        LoginPage loginPage =addProductToCartFlow.getLoginPage();
        Assert.assertTrue(loginPage.getSingInRegisterHeader().contains("New User Signup!"),"SingIn register header is missing");
        log("SingIn register page is loaded check");

        //
        RegisterPage registerPage=registerUserFlow.getRegisterPage("testName","testEmail"+getRandomNumber()+"@gmail.com");
        Assert.assertTrue(registerPage.getRegistrationTitle().contains("ENTER ACCOUNT INFORMATION"),"Register page is not displayed");
        log("Enter account info page is loaded check");


        AccountCreatedPage accountCreatedPage =registerUserFlow.getAccountCreatedPage(
                1,"accountname","password123",
                2002,12,28,
                "adress adress","adress asress asesds",
                "company name","adress number one","adress number two",
                "United States","statename","cityname","200022","12345567889");
        Assert.assertTrue(accountCreatedPage.getAccountCreatedText().contains("ACCOUNT CREATED!"),"" +
                "Account is created page did not load");
        log("Account created page is loaded check");


        HomePage homePage=registerUserFlow.getHomePage();

        Assert.assertTrue(homePage.getLoggedInAsUserName().equals("accountname"),"Logged In as user name is incorrect");
        log("Logged In as user page is loaded check");


        ViewCartPage viewCartPage2=addProductToCartFlow.getViewCartPage2();
        Assert.assertEquals(viewCartPage2.getCurrentUrl(),"https://automationexercise.com/view_cart","Cart page is not loaded URL");
        log("Cart page second time is loaded URL check");
        Assert.assertTrue(viewCartPage.getNumberOfProductsInCart()!=0,"Shopping cart page has no products in Cart");
        log("Items selected are still in cart check");

        CheckOutPage checkOutPage= addProductToCartFlow.getCheckOutPagePage();
        Assert.assertTrue(checkOutPage.getCurrentUrl().contains("https://automationexercise.com/checkout"),"Checkout page is not loaded URL");
        log("Checkout page is loaded URL check");
        //Needs to check the delivery adress if it matches the one i inserted

        AddressDelivery addressDelivery=checkOutPage.getDeliveryAddresses().get(0);

        //System.out.println(addressDelivery);
        //Assert.assertTrue(addressDelivery.getFirstName().equals("adress adress"),"First name is incorrect");
        //Assert.assertTrue(addressDelivery.getLastName().equals("adress asress asesds"),"Last name is incorrect");
        Assert.assertTrue(addressDelivery.getCity().equals("cityname"),"City name is incorrect");
        Assert.assertTrue(addressDelivery.getAddressOne().equals("adress number one"),"Address one is incorrect");
        Assert.assertTrue(addressDelivery.getAddressTwo().equals("adress number two"),"Address two is incorrect");
        Assert.assertTrue(addressDelivery.getCountry().equals("United States"),"Country name is incorrect");
        Assert.assertTrue(addressDelivery.getPhoneNumber().equals("12345567889"),"Phone number is incorrect");
        Assert.assertTrue(addressDelivery.getState().equals("statename"),"State name is incorrect");
        Assert.assertTrue(addressDelivery.getZipCode().equals("200022"),"Zip code is incorrect");
        Assert.assertTrue(addressDelivery.getCompanyName().equals("company name"),"Company name is incorrect");

        PaymentPage paymentPage= addProductToCartFlow.getPaymentPage("message order order order");
        Assert.assertTrue(paymentPage.getCurrentUrl().contains("https://automationexercise.com/payment"),"Payment page is not loaded URL");
        log("Payment page loaded URL check");

        PaymentDonePage paymentDonePage= addProductToCartFlow.getPaymentDonePage("tester card","12312312312312","123","13/02","2004");
        Assert.assertTrue(paymentDonePage.getCurrentUrl().contains("https://automationexercise.com/payment"),"Payment done page is not loaded URL");
        log("Payment done page is loaded URL check");

        DeletedAccountPage deletedAccountPage =addProductToCartFlow.getDeletedAccount();
        Assert.assertTrue(deletedAccountPage.getCurrentUrl().contains("https://automationexercise.com/delete_account"),"Delete account page is not loaded URL");
        log("Account deleted page is loaded URL check");


        HomePage homePage2=addProductToCartFlow.getHomePage();
        Assert.assertTrue(assertHonePageIsLoaded(),"Home page is not loaded");
        log("home page loaded check");
        log("test passed");






    }
}
