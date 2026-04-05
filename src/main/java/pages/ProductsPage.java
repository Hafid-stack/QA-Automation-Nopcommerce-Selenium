package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    private String addToCartSelector = "[data-product-id='%s']";
    private By productsContainer = By.className("features_items");
    private By productCards = By.cssSelector(".features_items .col-sm-4");
    private By getProductCardsName = By.cssSelector(".features_items .col-sm-4 .productinfo p");
    private By productsPageTitle= By.cssSelector("h2.title");
    private String productsLocatorByNumber="a[href='/product_details/%s']";
    private By productSearch=By.cssSelector("input#search_product");
    private By productSearchButton=By.cssSelector("button#submit_search");
    private By productAddedAlertContinueBtn=By.cssSelector(".modal-footer [data-dismiss='modal']");
    private By productAddedAlertViewCartBtn=By.cssSelector(".modal-body a[href='/view_cart']");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductsPageTitle(){
        return getValue(productsPageTitle);
    }
    public void clickProductByNumber(String productNumber){
        By productLocator= By.cssSelector(String.format(productsLocatorByNumber,productNumber));
        //System.out.println(productLocator);
        clickImproved(productLocator);
    }

    public boolean isProductsListDisplayed() {
        return waitForVisibility(productsContainer).isDisplayed();
    }

    public int getProductsCount() {

        return waitForVisibility(productsPageTitle).getText().length();
    }

    public void clickSearchProduct(){
        clickImproved(productSearch);
    }
    public void typeProductNameInsEARCH(String productName){
        type(productSearch,productName);
    }
    public void clickSearchButton(){
        clickImproved(productSearchButton);
    }
    public List<WebElement> getProductElements() {
        return driver.findElements(getProductCardsName);
    }
    public void clickAddToCartButton(String productId){
        By dynamicLocator = By.cssSelector(String.format(addToCartSelector, productId));
        clickImproved(dynamicLocator);
        log("Clicked 'Add to Cart' for product ID: " + productId);
    }
    public void clickContinueShoppingButton(){
        clickImproved(productAddedAlertContinueBtn);
    }

    public void clickViewCartButton() {
        clickImproved(productAddedAlertViewCartBtn);
    }
}
