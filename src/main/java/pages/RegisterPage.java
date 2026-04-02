package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    //Enter Account Information variables/selectors
    private By registrationTitle=By.xpath("//b[text()='Enter Account Information']");
    private By genderMr= By.id("id_gender1");
    private By genderMrs=By.id("id_gender2");
    private By accountNameElement = By.cssSelector("[data-qa='name']");
    private By accountPasswordElement = By.cssSelector("[data-qa='password']");
    private By dayOfBirthInput = By.cssSelector("[data-qa='days']");
    private By monthOfBirthInput = By.cssSelector("[data-qa='months']");
    private By yearOfBirthInput = By.cssSelector("[data-qa='years']");
    private By newsLetterBtn= By.id("newsletter");
    private By specialOffersBtn = By.id("optin");

    //Address Information variables/selectors

    private By infoFirstName= By.cssSelector("[data-qa='first_name']");
    private By infoLastName= By.cssSelector("[data-qa='last_name']");
    private By infoEmail= By.cssSelector("[data-qa='email']");
    private By infoCompany= By.cssSelector("[data-qa='company']");
    private By infoAddress= By.cssSelector("[data-qa='address']");
    private By infoAddress2= By.cssSelector("[data-qa='address2']");
    private By infoCountry= By.cssSelector("[data-qa='country']");
    private By infoState= By.cssSelector("[data-qa='state']");
    private By infoCity= By.cssSelector("[data-qa='city']");
    private By infoZipCode= By.cssSelector("[data-qa='zipcode']");
    private By infoPhone= By.cssSelector("[data-qa='mobile_number']");
    private By createAccountBtn= By.cssSelector("[data-qa='create-account']");

    //---------------------------------------

    public RegisterPage(WebDriver driver){
        super(driver);
    }

    //Enter Account Information functions
    public String getRegistrationTitle(){
        return getValue(registrationTitle);
    }

    public void titleMr() {
        click(genderMr);
    }
    public void titleMrs() {
        click(genderMrs);
    }

    public void typeAccountName(String accountName){
        type(accountNameElement,accountName);
    }

    public void typeAccountPassword(String password){
        type(accountPasswordElement,password);
    }
    public void setDataOfBirth(int year, int month, int day) {
        selectDropDown(dayOfBirthInput,String.valueOf(day));
        selectDropDown(monthOfBirthInput,String.valueOf(month));
        selectDropDown(yearOfBirthInput,String.valueOf(year));
    }
    public void clickNewsLetterBtn() {
        click(newsLetterBtn);
    }
    public void clickSpecialOffersBtn() {
        click(specialOffersBtn);
    }


    //Address Information functions
    public void typeAdressFirstName(String firstName){
        type(infoFirstName,firstName);
    }
    public void typeAdressLastName(String lastName){
        type(infoLastName,lastName);
    }
    public void typeAdressCompany(String company){
        type(infoCompany,company);
    }
    public void typeAdressAddress(String address){
        type(infoAddress,address);
    }
    public void typeAdressAddress2(String address){
        type(infoAddress2,address);
    }
    public void typeAdressCountry(String country){
        selectDropDown(infoCountry,String.valueOf(country));
    }
    public void typeAdressState(String state){
        type(infoState,state);
    }
    public void typeAdressCity(String city){
        type(infoCity,city);
    }
    public void typeAdressZipCode(String zipCode){
        type(infoZipCode,zipCode);
    }
    public void typeAdressPhoneNumber(String phoneNumber){
        type(infoPhone,phoneNumber);
    }

    public void clickCreateAccount() {
        click(createAccountBtn);
    }
}
