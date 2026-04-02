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
        if(homepageBodyClass.equals(By.id("sauce-demo"))){
            result = true;
        }else {
            result = false;
        }
        //System.out.println(homepageBodyClass.toString());

        return result;
    }
    public void clickLoginSinginBtn(){
        headerUpperPage.clickLoginButton();
    }

    public String getLoggedInAsUserName() {
        return headerUpperPage.getUserName();
    }

    public void clickDeleteAccount() {
        click(headerUpperPage.deleteAccountBtn);
    }
}
