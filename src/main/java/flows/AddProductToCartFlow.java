package flows;

import base.BaseFlow;
import models.FakeCardData;
import org.openqa.selenium.WebDriver;
import pages.*;
import models.CartItem;
import utilitypages.HeaderUpperPage;

public class AddProductToCartFlow extends BaseFlow {

    private HomePage homePage;
    private ProductsPage productsPage;
    private ViewCartPage viewCartPage;
    private LoginPage loginPage;
    private CartItem cartItem;
    private PaymentPage paymentPage;
    private CheckOutPage checkOutPage;
    private PaymentDonePage paymentDonePage;
    private HeaderUpperPage headerUpperPage;
    private DeletedAccountPage deletedAccountPage;
    public AddProductToCartFlow(WebDriver driver) {
        super(driver);
        this.productsPage = new ProductsPage(driver);
        this.homePage = new HomePage(driver);
        this.productsPage = new ProductsPage(driver);
        this.viewCartPage = new ViewCartPage(driver);
        this.loginPage = new LoginPage(driver);
        this.paymentPage=new PaymentPage(driver);
        this.checkOutPage= new CheckOutPage(driver);
        this.paymentDonePage = new PaymentDonePage(driver);
        this.headerUpperPage= new HeaderUpperPage(driver);
        this.deletedAccountPage =new DeletedAccountPage(driver);

    }
    public ViewCartPage getViewCartPage(String productId) {

        homePage.clickAddToCartBtn(productId);
        homePage.clickAlertViewCartBtn();
        //return new ViewCartPage(driver);
        return viewCartPage;
    }
    public LoginPage getLoginPage(){
        viewCartPage.clickCheckoutBtn();
        viewCartPage.clickFloatingCartLoginSinginBtn();

        return loginPage;


    }
    // Double check if the same function is present in the register flow
    public ViewCartPage getViewCartPage2(){
        homePage.clickCartButtom();
        return  viewCartPage;
    }

    public CheckOutPage getCheckOutPagePage(){
        viewCartPage.clickCheckoutBtn();
        return checkOutPage;
    }
    public PaymentPage getPaymentPage(String message){


        checkOutPage.typeOrderMessage(message);
        checkOutPage.clickOrderButton();
        return paymentPage;
    }

    public PaymentDonePage getPaymentDonePage(FakeCardData fakeCardData){
        paymentPage.typeNameOnCard(fakeCardData.getCardFullName());
        paymentPage.typeNumberOnCard(fakeCardData.getCardNumber());
        paymentPage.typeCvcCard(fakeCardData.getCvcNumber());
        paymentPage.typeExpiryMonthCard(fakeCardData.getExpirationMonth());
        paymentPage.typeExpiryYearCard(fakeCardData.getExpirationYear());
        paymentPage.clickPayButton();
        return paymentDonePage;
    }
    public DeletedAccountPage getDeletedAccount(){
        headerUpperPage.clickdeleteAccountBtn();
        return deletedAccountPage;
    }
    public HomePage getHomePage(){
        deletedAccountPage.clickDeleteAccountContinueBtn();
        return homePage;
    }



}
