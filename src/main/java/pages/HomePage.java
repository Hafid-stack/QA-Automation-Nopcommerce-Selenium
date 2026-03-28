package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilitypages.HeaderUpperPage;

public class HomePage extends BasePage {


    private HeaderUpperPage headerUpperPage;
    private By homepageBodyClass= By.id("sauce-demo");

    public HomePage(WebDriver driver) {
        super(driver);
        headerUpperPage = new HeaderUpperPage(driver);
    }

    public void clickRegisterBtn(){
        headerUpperPage.clickRegisterButton();

    }
    public Boolean getHomepageBodyClass(){
        boolean result = false;
        if(homepageBodyClass.toString().equals("sauce-demo")){
            result = true;
        }else {
            result = false;
        }
        return result;
    }
}
