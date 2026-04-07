package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {
    //9. Verify that product detail is visible: product name, category, price, availability, condition, brand
    private By productName=By.cssSelector(".product-information h2");
    private By productIncreaseQuantity=By.id("quantity");
    private By productAlertViewCartBtn=By.cssSelector(".modal-content [href='/view_cart']");
    private By productContinueShoppingBtn=By.cssSelector(".modal-content [data-dismiss='modal']");
    private By productAddToCartBtn=By.cssSelector(".product-details button");
    private By productCategory=By.cssSelector(".product-information p:first-of-type");
    private By productPrice=By.cssSelector(".product-information span span");
    //private By productQuantityText=By.cssSelector(".product-information span label");
    private By getProductQuantity=By.id("quantity");
    private By productAvailability = By.cssSelector(".product-information p:nth-of-type(2)");
    private By productCondition= By.cssSelector(".product-information p:nth-of-type(3)");
    private By productBrand= By.cssSelector(".product-information p:nth-of-type(4)");
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    public void clickAlertViewCartBtn(){
        click(productAlertViewCartBtn);
    }
    public void clickContinueShoppingBtn(){
        click(productContinueShoppingBtn);
    }
    public void clickAddToCartBtn(){
        click(productAddToCartBtn);
    }
    public String getProductName(){
        return getValue(productName);
    }
    public String getProductCategory(){
        return getValue(productCategory);
    }
    public String getProductPrice(){
        return getValue(productPrice);
    }
    public String getProductAvailability(){
        return getValue(productAvailability);
    }
    public String getProductQuantity(){
        return getValue(getProductQuantity);
    }
    public String getProductCondition(){
        return getValue(productCondition);
    }
    public String getProductBrand(){
        return getValue(productBrand);
    }
    public void increaseProductQuantity(String quantity){
        type(productIncreaseQuantity,quantity);
        getValue(productIncreaseQuantity);
    }
    public void isProductInCartDetailDisplayed(){
        waitForVisibility(productName);
        waitForVisibility(productCategory);
        waitForVisibility(productPrice);
        waitForVisibility(productAvailability);
        waitForVisibility(productCondition);
        waitForVisibility(productBrand);
    }


}
