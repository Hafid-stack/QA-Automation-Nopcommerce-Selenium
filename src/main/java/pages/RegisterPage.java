package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    private By maleButton = By.id("gender-male");
    private By femaleButton = By.id("gender-female");
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By emailField = By.id("Email");
    private By companyNameField = By.id("Company");
    private By newsletter = By.id("NewsLetterSubscriptions_0__IsActive");
    private By passwordField = By.id("Password");
    private By confirmPasswordField = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");
    private By registerHeader = By.cssSelector("div.page-title h1");


    public RegisterPage(WebDriver driver){
        super(driver);
    }

    public void clickSelectedGender(String gender){

        if (gender.equals("Male")){
            click(maleButton);
        }else if (gender.equals("Female")){
            click(femaleButton);
        }
    }

    public void typeFirstName(String fName){
        type(firstName,fName);
    }
    public void typeLastName(String lName){
        type(lastName,lName);
    }
    public void typeEmail(String email){
        type(emailField,email);
    }
    public void typeCompanyName(String companyName){
        type(companyNameField,companyName);

    }
    public void typePassword(String password){
        type(passwordField,password);
    }
    public void typeConfirmPassword(String confirmPassword){
        type(confirmPasswordField,confirmPassword);
    }
    public void clickNewsletter(){

        click(newsletter);
    }

    public void clickRegisterButton(){
        click(registerButton);
    }

    public String checkRegisterHeader(){
        return getValue(registerHeader).getText();
    }

}
