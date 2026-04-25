package ui.tests.placeorder;

import base.BaseTest;
import flows.AddProductToCartFlow;
import flows.RegisterUserFlow;
import models.NewUserSingup;
import models.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import testdata.Generator;
import testdata.UserFactory;

public class LoginBeforeCheckoutTest extends BaseTest {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'

    @Test(description = "Test Case 16: Place Order: Login before Checkout")
    public void loginBeforeCheckoutTest(){
        AddProductToCartFlow addProductToCartFlow = new AddProductToCartFlow(driver);
        RegisterUserFlow registerUserFlow = new RegisterUserFlow(driver);
        UserFactory userFactory = new UserFactory();
        UserData userData = userFactory.getUserData();
        NewUserSingup newUserSingup = userFactory.getNewUserSingup();
        Generator generator = new Generator();
        //3. Verify that home page is visible successfully
        Assert.assertTrue(assertHonePageIsLoaded(),"Login failed");
        //4. Click 'Signup / Login' button
        //5. Fill email, password and click 'Login' button
        HomePage homePage = registerUserFlow.getValidUserDataToLoginAndReturnHomePage(newUserSingup,userData);
        //6. Verify 'Logged in as username' at top
        Assert.assertEquals(homePage.getLoggedInAsUserName(),userData.getAccountName(),"Logged in username does not match the used one");
        //7. Add products to cart
        //8. Click 'Cart' button
        ViewCartPage viewCartPage = addProductToCartFlow.getViewCartPage("3");
        //9. Verify that cart page is displayed
        Assert.assertTrue(viewCartPage.pageUrl().equals(driver.getCurrentUrl()),"View cart page did not load");
        //10. Click Proceed To Checkout
        CheckOutPage checkOutPage = addProductToCartFlow.getCheckOutPagePage();
        //11. Verify Address Details and Review Your Order
        Assert.assertTrue(checkOutPage.getDeliveryAddresses().getCity().equals(userData.getCity()),"City name is incorrect");
        Assert.assertTrue(checkOutPage.getDeliveryAddresses().getAddressOne().equals(userData.getAddress1()),"Address one is incorrect");
        Assert.assertTrue(checkOutPage.getDeliveryAddresses().getAddressTwo().equals(userData.getAddress2()),"Address two is incorrect");
        Assert.assertTrue(checkOutPage.getDeliveryAddresses().getCountry().equals(userData.getCountry()),"Country name is incorrect");
        Assert.assertTrue(checkOutPage.getDeliveryAddresses().getPhoneNumber().equals(userData.getPhoneNumber()),"Phone number is incorrect");
        Assert.assertTrue(checkOutPage.getDeliveryAddresses().getState().equals(userData.getState()),"State name is incorrect");
        Assert.assertTrue(checkOutPage.getDeliveryAddresses().getZipCode().equals(userData.getZipCode()),"Zip code is incorrect");
        Assert.assertTrue(checkOutPage.getDeliveryAddresses().getCompanyName().equals(userData.getCompany()),"Company name is incorrect");

        //12. Enter description in comment text area and click 'Place Order'
        PaymentPage paymentPage=addProductToCartFlow.getPaymentPage(generator.generateComment());
        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //14. Click 'Pay and Confirm Order' button

        PaymentDonePage paymentDonePage=addProductToCartFlow.getPaymentDonePage(generator.generateFakeCardData());
        //15. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(paymentDonePage.getOrderMessage().contains("Congratulations! Your order has been confirmed!"),"Order success message is incorrect");


        //16. Click 'Delete Account' button
        DeletedAccountPage deletedAccountPage=addProductToCartFlow.getDeletedAccount();

        //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(deletedAccountPage.getDeleteAccounText().contains("ACCOUNT DELETED!"),"Account deleted text is incorrect");
        HomePage homePage1 = addProductToCartFlow.getHomePage();

        Assert.assertTrue(assertHonePageIsLoaded(),"Home page is not loaded");


        log("Test passed");


    }
}
