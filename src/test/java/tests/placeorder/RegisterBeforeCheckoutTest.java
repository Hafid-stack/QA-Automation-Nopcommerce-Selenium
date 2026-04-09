package tests.placeorder;

import base.BaseTest;
import flows.AddProductToCartFlow;
import flows.RegisterUserFlow;
import models.FakeCardData;
import models.NewUserSingup;
import models.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import testdata.Generator;
import testdata.UserFactory;

public class RegisterBeforeCheckoutTest extends BaseTest {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//17. Click 'Delete Account' button
//18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    @Test(description = "Test Case 15: Place Order: Register before Checkout")
    public void registerBeforeCheckoutTest(){
        log("Register before Checkout test started");
        RegisterUserFlow registerUserFlow = new RegisterUserFlow(driver);
        AddProductToCartFlow addProductToCartFlow = new AddProductToCartFlow(driver);
        UserFactory userFactory = new UserFactory();
        Generator generator = new Generator();
        //3. Verify that home page is visible successfully
        Assert.assertTrue(assertHonePageIsLoaded(),"Home page is not loaded");
        //4. Click 'Signup / Login' button
        LoginPage loginPage = registerUserFlow.getLoginPage();
        //5. Fill all details in Signup and create account
        NewUserSingup newUserSingup =userFactory.getNewUserSingup();
        RegisterPage registerPage= registerUserFlow.getRegisterPage(newUserSingup);
        UserData userData = userFactory.getUserData();
        AccountCreatedPage accountCreatedPage=registerUserFlow.getAccountCreatedPage(userData);

        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Assert.assertTrue(accountCreatedPage.getAccountCreatedText().contains("ACCOUNT CREATED!"),"Account created text is incorrect");
        HomePage homePage = registerUserFlow.getHomePage();

        //7. Verify ' Logged in as username' at top
        Assert.assertTrue(homePage.getLoggedInAsUserName().contains(userData.accountName),"Account name is incorrect");
        //8. Add products to cart
        //9. Click 'Cart' button

        ViewCartPage viewCartPage = addProductToCartFlow.getViewCartPage("2");
        //10. Verify that cart page is displayed

        Assert.assertTrue(viewCartPage.pageUrl().contains(driver.getCurrentUrl()),"Page url is incorrect");
        //11. Click Proceed To Checkout

        CheckOutPage checkOutPage=addProductToCartFlow.getCheckOutPagePage();
        //12. Verify Address Details and Review Your Order
        Assert.assertTrue(checkOutPage.getDeliveryAddresses().getCity().equals(userData.city),"City name is incorrect");
        Assert.assertTrue(checkOutPage.getDeliveryAddresses().getAddressOne().equals(userData.address1),"Address one is incorrect");
        Assert.assertTrue(checkOutPage.getDeliveryAddresses().getAddressTwo().equals(userData.address2),"Address two is incorrect");
        Assert.assertTrue(checkOutPage.getDeliveryAddresses().getCountry().equals(userData.country),"Country name is incorrect");
        Assert.assertTrue(checkOutPage.getDeliveryAddresses().getPhoneNumber().equals(userData.phoneNumber),"Phone number is incorrect");
        Assert.assertTrue(checkOutPage.getDeliveryAddresses().getState().equals(userData.state),"State name is incorrect");
        Assert.assertTrue(checkOutPage.getDeliveryAddresses().getZipCode().equals(userData.zipCode),"Zip code is incorrect");
        Assert.assertTrue(checkOutPage.getDeliveryAddresses().getCompanyName().equals(userData.company),"Company name is incorrect");


        Assert.assertTrue(checkOutPage.getCartItems().isEmpty(),"CartItems is empty");


        //13. Enter description in comment text area and click 'Place Order'
        PaymentPage paymentPage=addProductToCartFlow.getPaymentPage(generator.generateComment());

        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        FakeCardData fakeCardData=generator.generateFakeCardData();
        PaymentDonePage paymentDonePage=addProductToCartFlow.getPaymentDonePage(fakeCardData);
        //15. Click 'Pay and Confirm Order' button
        //16. Verify success message 'Your order has been placed successfully!'







    }
}
