package flows;

import base.BaseFlow;
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

        homePage.clickAddToCartBtn("2");
        homePage.clickAlertViewCartBtn();
        //return new ViewCartPage(driver);
        return viewCartPage;
    }
    public LoginPage getLoginPage(){
        viewCartPage.clickCheckoutBtn();
        viewCartPage.clickFloatingCartLoginSinginBtn();

        return loginPage;


    }

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

    public PaymentDonePage getPaymentDonePage(String nameOnCard,String numberOnCard, String cvcNumber,String expirationMonth,String expirationYear){
        paymentPage.typeNameOnCard(nameOnCard);
        paymentPage.typeNumberOnCard(numberOnCard);
        paymentPage.typeCvcCard(cvcNumber);
        paymentPage.typeExpiryMonthCard(expirationMonth);
        paymentPage.typeExpiryYearCard(expirationYear);
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
