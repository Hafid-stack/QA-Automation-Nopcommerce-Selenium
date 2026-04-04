package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {
        //9. Verify that product detail is visible: product name, category, price, availability, condition, brand
    private By productName=By.cssSelector(".product-information h2");
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


}
