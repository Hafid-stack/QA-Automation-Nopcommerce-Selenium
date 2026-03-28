package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {


    private By firstNameInput = By.cssSelector("input#first_name");
    private By lastNameInput = By.cssSelector("input#last_name");
    private By emailFieldInput = By.cssSelector("input#email");
     private By passwordInput = By.cssSelector("input#password");
    private By registerButton = By.className("action_bottom");
    private By registerHeader = By.className("accounts-title");


    public RegisterPage(WebDriver driver){
        super(driver);
    }

    public void typeFirstName(String fName){
        type(firstNameInput,fName);
    }
    public void typeLastName(String lName){
        type(lastNameInput,lName);
    }
    public void typeEmail(String email){
        type(emailFieldInput,email);
    }
    public void typePassword(String password){
        type(passwordInput,password);
    }

    public void clickRegisterButton(){
        click(registerButton);
    }

    public String checkRegisterHeader(){
        return getValue(registerHeader);
    }

}
