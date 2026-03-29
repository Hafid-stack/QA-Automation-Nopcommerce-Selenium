package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By pageindicator= By.id("create-account");
    private By emailInput= By.cssSelector("input#customer_email");
    private By passwordInput= By.cssSelector("input#customer_password");
    private By loginButton= By.cssSelector(".action_bottom input[value='Sign In']");
    private By errorMessage= By.cssSelector(".customer_login #errors li");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public boolean loginPageIsOpen(){
        boolean fact=false;
        if (pageindicator.equals(By.id("create-account"))) {
            fact=true;
        }else  {
            fact=false;
        }
        return fact;

    }
    public void typeEmail(String email){
        type(emailInput,email);
    }
    public void typePassword(String password){
        type(passwordInput,password);
    }
    public void clickLoginButton(){
        click(loginButton);
    }

    public String getErrorMessage(){
        return getValue(errorMessage);
    }
    public void submitLoginBtn(){

        submit(loginButton);
    }
    public Boolean isSinginBtnClickable(){
        boolean result=false;
        if (waitForClickability(loginButton).isEnabled()){

            result=true;
        }else {
            result=false;
        }
        return result;

    }
}
