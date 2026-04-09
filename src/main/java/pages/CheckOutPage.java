package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import models.AddressDelivery;
import models.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CheckOutPage extends BasePage {
    private By placeOrderBtn=By.cssSelector("[href='/payment']");
    private By orderMessage=By.cssSelector("#ordermsg [name='message']");
    private By productRows=By.id("product-1");
    private By deliveryFullName= By.cssSelector("#address_delivery .address_firstname.address_lastname");
    private By adressDeliveryRows=By.cssSelector("#address_delivery");
    private By deliveryAdresses=By.cssSelector(".address_address1.address_address2");
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    public List<AddressDelivery> getDeliveryAddresses() {

        List<WebElement> addressDetails = driver.findElements(adressDeliveryRows);
        List<AddressDelivery> items = new ArrayList<>();

        for (WebElement detail : addressDetails) {

            // Full name
            String fullName = detail
                    .findElement(By.cssSelector(".address_firstname.address_lastname"))
                    .getText();

            String[] nameParts = fullName.split(" ");
            String firstName = nameParts[0];
            String lastName = nameParts[1];

            // Address lines (scoped correctly)
            List<WebElement> deliveryAddresses =
                    detail.findElements(By.cssSelector(".address_address1.address_address2"));

            String companyName = deliveryAddresses.get(0).getText();
            String addressOne = deliveryAddresses.get(1).getText();
            String addressTwo = deliveryAddresses.get(2).getText();

            // City, state, zip
            String cityStateZipCode =
                    detail.findElement(By.cssSelector(
                                    ".address_city.address_state_name.address_postcode"))
                            .getText();

            String[] parts = cityStateZipCode.split(" ");

            String city = parts[0];
            String state = parts[1];
            String zipCode = parts[2];

            // Country
            String country = detail
                    .findElement(By.cssSelector(".address_country_name"))
                    .getText();

            // Phone
            String phoneNumber = detail
                    .findElement(By.cssSelector(".address_phone"))
                    .getText();

            items.add(new AddressDelivery(
                    firstName,
                    lastName,
                    companyName,
                    addressOne,
                    addressTwo,
                    city,
                    state,
                    zipCode,
                    country,
                    phoneNumber
            ));
        }

        return items;
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
    public void typeOrderMessage(String message) {
            type(orderMessage,message);
    }
    public void clickOrderButton() {
        click(placeOrderBtn);
    }


}
