package utilitypages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderUpperPage extends BasePage {

    //Before Log in options
    private By loginSinginButton = By.cssSelector("a[href='/login']");

    //After Login options
    public By getUserName = By.cssSelector(".fa-user + b");
    public By deleteAccountBtn=By.cssSelector("[href='/delete_account']");

    //Available options at all times




    //==========================
    public HeaderUpperPage(WebDriver driver) {
        super(driver);
    }

    //Before login functions
    public void clickRegisterButton() {
        click(loginSinginButton);

    }
    public void clickLoginButton() {
        click(loginSinginButton);

    }



    //After loggin functions
    public String getUserName() {
        return getValue(getUserName);
    }
    public void clickdeleteAccountBtn() {
        click(deleteAccountBtn);
    }
}
