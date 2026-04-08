package flows;

import base.BaseFlow;
import org.openqa.selenium.WebDriver;
import pages.*;
import utilitypages.AddressDelivery;
import utilitypages.CartItem;
import utilitypages.HeaderUpperPage;

import java.sql.Driver;
import java.util.List;

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
    private DeletedAccount deletedAccount;
    public AddProductToCartFlow(WebDriver driver) {
        super(driver);
    }
    public ViewCartPage getViewCartPage(String productId, WebDriver driver) {
        homePage = new HomePage(driver);
        homePage.clickHomePageViewProductBtn(productId);
        homePage.clickCartButtom();
        return viewCartPage;
    }
    public LoginPage getLoginPage(){
        viewCartPage.clickCheckoutBtn();
        viewCartPage.clickFloatingCartLoginSinginBtn();

        return loginPage;


    }

    public ViewCartPage getViewCartPage2(){
        homePage.clickProductsButton();
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
    public DeletedAccount getDeletedAccount(){
        headerUpperPage.clickdeleteAccountBtn();
        return deletedAccount;
    }
    public HomePage getHomePage(){
        deletedAccount.clickDeleteAccountContinueBtn();
        return homePage;
    }

}
