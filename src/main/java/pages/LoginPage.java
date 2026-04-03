package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    //Log in variables
    private By loginTitle=By.cssSelector(".login-form h2");
    private By emailLoginInput=By.cssSelector("[data-qa='login-email']");
    private By passwordLoginInput=By.cssSelector("[data-qa='login-password']");
    private By loginButton=By.cssSelector("[data-qa='login-button']");
    private By loginErrorMessage=By.cssSelector(".login-form p");
    //New user Sing Up variables
    private By registerTitle = By.cssSelector(".signup-form h2");
    private By emailFieldInput = By.cssSelector("[data-qa='signup-email']");
    private By firstNameInput = By.cssSelector("[data-qa='signup-name']");
    private By registerButton = By.cssSelector(".signup-form [type='submit']");



    //=====================================
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Login to your account functions

    public String getLoginHeader() {
        return getValue(loginTitle);
    }
    public void typeLoginEmail(String email) {
        type(emailLoginInput, email);
    }
    public void typeLoginPassword(String password) {
        type(passwordLoginInput, password);
    }
    public void clickLoginButton() {
        click(loginButton);
    }
    public String getLoginErrorMessage() {
        return getValue(loginErrorMessage);
    }



    //New user Sing Up WebElements functions
    public String getSingInRegisterHeader(){
        return getValue(registerTitle);
    }
    public void typeSingInEmail(String email){
        type(emailFieldInput,email);
    }
    public void clickSingInRegisterButton(){
        click(registerButton);
    }
    public void typeSingInFirstName(String fName){
        type(firstNameInput,fName);
    }


}
