package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryProductsPage extends BasePage {
    private By categoryHeaderText=By.cssSelector(".features_items > h2.title");
    public CategoryProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getCategoryHeaderText(){
        return getValue(categoryHeaderText);

    }
}
