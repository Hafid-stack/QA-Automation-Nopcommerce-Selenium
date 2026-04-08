package flows;

import base.BaseFlow;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.ViewCartPage;
import utilitypages.CartItem;

public class AddProductToCartFlow extends BaseFlow {

    private HomePage homePage;
    private ProductsPage productsPage;
    private ViewCartPage viewCartPage;
    private LoginPage loginPage;
    private CartItem cartItem;
    public AddProductToCartFlow(WebDriver driver) {
        super(driver);
    }
    public ViewCartPage getViewCartPage(String productId){
        homePage.clickHomePageViewProductBtn(productId);
        homePage.clickCartButtom();
        return viewCartPage;
    }
    public CheckOutPage getCheckOutPage(){
        viewCartPage. processedtocheckout;
        viewCartPage.clickregisterloginbtn;

        return loginPage;


        }
//    Click 'Register / Login' button
//9. Fill all details in Signup and create account
//10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
//11. Verify ' Logged in as username' at top
//12.Click 'Cart' button
//13. Click 'Proceed To Checkout' button
//14. Verify Address Details and Review Your Order
//15. Enter description in comment text area and click 'Place Order'
//            16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//17. Click 'Pay and Confirm Order' button
//18. Verify success message 'Your order has been placed successfully!'
//            19. Click 'Delete Account' button
//20. Verify 'ACCOUNT DELETED!' and click 'Continue' button

}
