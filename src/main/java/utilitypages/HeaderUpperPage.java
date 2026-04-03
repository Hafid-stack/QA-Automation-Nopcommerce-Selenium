package utilitypages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.swing.plaf.PanelUI;

public class HeaderUpperPage extends BasePage {

    //Before Log in options
    private By loginSinginButton = By.cssSelector("a[href='/login']");

    //After Login options
    public By getUserName = By.cssSelector(".fa-user + b");
    public By deleteAccountBtn=By.cssSelector("[href='/delete_account']");
    public By logoutBtn=By.cssSelector("[href='/logout']");

    //Available options at all times




    //==========================
    public HeaderUpperPage(WebDriver driver) {
        super(driver);
    }

    //Before login functions
    public void clickRegisterSinginButton() {
        click(loginSinginButton);

    }

    public Boolean isLoginSinginButtonPresent() {
        boolean button = false;
        if (waitForClickability(loginSinginButton).isEnabled()){
            button = true;
        }else {
            button = false;
        }
        return button;
    }



    //After loggin functions
    public String getUserName() {
        return getValue(getUserName);
    }
    public void clickdeleteAccountBtn() {
        click(deleteAccountBtn);
    }
    public void clickLogoutButton() {
        click(logoutBtn);

    }
}
