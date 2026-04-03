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
    //functions relay on upper header

    public void clickContactUsButton() {
        headerUpperPage.clickContactUsBtn();
    }
    public void clickLoginSinginBtn(){
        headerUpperPage.clickRegisterSinginButton();
    }

    public String getLoggedInAsUserName() {
        return headerUpperPage.getUserName();
    }

    public void clickDeleteAccount() {
        click(headerUpperPage.deleteAccountBtn);
    }

    public void clickLogoutBtn() {
        headerUpperPage.clickLogoutButton();
    }
    public Boolean loginSinginBtnPresent() {

        return headerUpperPage.isLoginSinginButtonPresent();
    }
}
