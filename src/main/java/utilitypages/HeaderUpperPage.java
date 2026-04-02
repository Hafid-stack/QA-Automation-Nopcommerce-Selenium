package utilitypages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderUpperPage extends BasePage {

    public By getUserName= By.className(".fa.fa-user");
    public By deleteAccountBtn=By.className("[href='/delete_account']");
    private By loginSinginButton = By.cssSelector("a[href='/login']");
    private By wishlistButton = By.cssSelector(".header .header-upper .wishlist-label");
    private By wishlistQty = By.cssSelector(".header .header-upper .wishlist-qty");
    private By cartIcon = By.cssSelector(".header .header-upper .ico-cart");
    private By cartButton = By.cssSelector(".header .header-upper .cart-label");
    private By cartQty = By.cssSelector(".header .header-upper .cart-qty");
    private By customerCurrency = By.cssSelector(".header .header-upper .customer-currency");


    public HeaderUpperPage(WebDriver driver) {
        super(driver);
    }

    public void clickRegisterButton() {
        click(loginSinginButton);

    }
    public void clickLoginButton() {
        click(loginSinginButton);

    }
    public void clickWishlistButton() {
        click(wishlistButton);

    }
    public void clickWishlistQty() {
        click(wishlistQty);

    }
    public String getUserName() {
        return getValue(getUserName);
    }
    public void clickdeleteAccountBtn() {
        click(deleteAccountBtn);
    }
}
