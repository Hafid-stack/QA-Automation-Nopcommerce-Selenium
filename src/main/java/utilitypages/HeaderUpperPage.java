package utilitypages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderUpperPage extends BasePage {

    private By registerButton = By.className("ico-register");

    private By loginButton = By.className("ico-login");
    private By wishlistButton = By.className("wishlist-label");
    private By wishlistQty = By.className("wishlist-qty");
    private By cartIcon = By.className("ico-cart");
    private By cartButton = By.className("cart-label");
    private By cartQty = By.className("cart-qty");
    private By customerCurrency = By.className("customer-currency");


    public HeaderUpperPage(WebDriver driver) {
        super(driver);
    }

    public void clickRegisterButton() {
        click(registerButton);

    }
    public void clickLoginButton() {
        click(loginButton);

    }
    public void clickWishlistButton() {
        click(wishlistButton);

    }
    public void clickWishlistQty() {
        click(wishlistQty);

    }
}
