package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import models.CartItem;

import java.util.ArrayList;
import java.util.List;

public class ViewCartPage extends BasePage {

    private By productRows = By.xpath("//tr[starts-with(@id,'product-')]");
    private By productQuantityBtn=By.className("cart_quantity");
    private By checkoutBtn=By.cssSelector("a.check_out");
    private By floatingCartLoginSinginBtn=By.cssSelector(".modal-content a[href='/login']");
    private By floatingCartContinueShoppingBtn=By.cssSelector(".modal-content .modal-footer button");
    public ViewCartPage(WebDriver driver) {
        super(driver);
    }
    public void clickCheckoutBtn(){
        click(checkoutBtn);
    }
    public void clickFloatingCartLoginSinginBtn(){
        click(floatingCartLoginSinginBtn);

    }
    public void clickFloatingCartContinueShoppingBtn(){
        click(floatingCartContinueShoppingBtn);
    }
    public String getProductQuantity(){

        return getValue(productQuantityBtn);
    }
    public int getNumberOfProductsInCart() {
        return driver.findElements(productRows).size();
    }

    public List<CartItem> getCartItems() {

        List<WebElement> products = driver.findElements(productRows);
        List<CartItem> items = new ArrayList<>();

        for (WebElement product : products) {

            int price = Integer.parseInt(
                    product.findElement(By.cssSelector(".cart_price p"))
                            .getText()
                            .replaceAll("[^0-9]", "")
            );

            int quantity = Integer.parseInt(
                    product.findElement(By.cssSelector(".cart_quantity button"))
                            .getText()
            );

            int total = Integer.parseInt(
                    product.findElement(By.cssSelector(".cart_total_price"))
                            .getText()
                            .replaceAll("[^0-9]", "")
            );

            items.add(new CartItem(price, quantity, total));
        }

        return items;
    }
    public String pageUrl(){
        return "https://automationexercise.com/view_cart";
    }
}