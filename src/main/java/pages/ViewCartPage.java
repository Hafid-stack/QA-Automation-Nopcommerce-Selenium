package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilitypages.CartItem;

import java.util.ArrayList;
import java.util.List;

public class ViewCartPage extends BasePage {

    private By productRows = By.xpath("//tr[starts-with(@id,'product-')]");

    public ViewCartPage(WebDriver driver) {
        super(driver);
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
}