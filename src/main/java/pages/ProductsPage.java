package pages;

import base.BasePage;
import org.openqa.selenium.*;

import java.time.Duration;
import java.util.List;

public class ProductsPage extends BasePage {

    private String addToCartSelector = ".product-overlay [data-product-id='%s']";
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
//        By dynamicLocator = By.cssSelector(String.format(addToCartSelector, productId));
//        //System.out.println(dynamicLocator);
////        By dynamicLocator2 = By.cssSelector(String.format(productsLocatorByNumber, productId));
////
////        actions.moveToElement(waitForVisibility(dynamicLocator2),0,-10).
////                pause(500).perform();
//////
////        click(dynamicLocator);
//        try {
//            click(dynamicLocator);
//        } catch (StaleElementReferenceException e) {
//            WebElement addToCartBtn = driver.findElement(dynamicLocator);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtn);
//        }
////        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dynamicLocator);
//        log("Clicked 'Add to Cart' for product ID: " + productId);
//        By productCardLocator = By.cssSelector(String.format(productsLocatorByNumber, productId));
//        WebElement productCard = waitForVisibility(productCardLocator);
//        actions.moveToElement(productCard)
//                .pause(Duration.ofMillis(500))
//                .perform();
        By addToCartBtnLocator = By.cssSelector(String.format(addToCartSelector, productId));
//        click(addToCartBtnLocator);
        WebElement addToCartBtn = driver.findElement(addToCartBtnLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtn);

    }
    public void clickContinueShoppingButton(){
        clickImproved(productAddedAlertContinueBtn);
    }

    public void clickViewCartButton() {
        clickImproved(productAddedAlertViewCartBtn);
    }
}
