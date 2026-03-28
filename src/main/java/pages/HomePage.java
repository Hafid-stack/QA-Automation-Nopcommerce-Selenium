package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import utilitypages.HeaderUpperPage;

public class HomePage extends BasePage {


    private HeaderUpperPage headerUpperPage;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickRegisterBtn(){
        headerUpperPage.clickRegisterButton();

    }
}
