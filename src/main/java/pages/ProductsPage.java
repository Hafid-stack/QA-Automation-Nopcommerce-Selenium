package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private By productsPageTitle= By.cssSelector("h2.title");
    private String productsLocatorByNumber="a[href='/product_details/%s']";
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductsPageTitle(){
        return getValue(productsPageTitle);
    }
    public void clickProductByNumber(String productNumber){
        By productLocator= By.cssSelector(String.format(productsLocatorByNumber,productNumber));
        System.out.println(productLocator);
        clickImproved(productLocator);
    }
}
