package flows;

import base.BaseFlow;
import org.openqa.selenium.WebDriver;
import pages.*;
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
    public LoginPage getLoginPage(){
        viewCartPage.clickCheckoutBtn();
        viewCartPage.clickFloatingCartLoginSinginBtn();

        return loginPage;


        }
}
