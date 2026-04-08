package flows;

import base.BaseFlow;
import org.openqa.selenium.WebDriver;
import pages.*;

public class RegisterUserFlow extends BaseFlow {

    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private AccountCreatedPage accountCreatedPage;
    private DeletedAccount deletedAccount;

    public RegisterUserFlow(WebDriver driver) {
        super(driver);
    }
    public LoginPage getLoginPage() {
        homePage.clickLoginSinginBtn();
        return  loginPage;
    }
    public RegisterPage getRegisterPage(String name, String email){
        loginPage.typeSingInFirstName(name);
        loginPage.typeSingInEmail(email);
        loginPage.clickSingInRegisterButton();
        return  registerPage;
    }
    public AccountCreatedPage getAccountCreatedPage
            (int gender, String accountName, String accountPassword,int accountYear,int  accountMonth,int accountDay,
             String adressName, String addressLastName, String adressCompany, String adress1, String adress2,
             String adressCountry, String adressState, String adressCity, String adressZipCode,
             String adressPhoneNumber){
        if (gender==1){
            registerPage.titleMr();

        }else if (gender==2){
            registerPage.titleMrs();
        }
        registerPage.typeAccountName(accountName);
        registerPage.typeAccountPassword(accountPassword);
        registerPage.setDataOfBirth(accountYear,accountMonth,accountDay);

        //10. Select checkbox 'Sign up for our newsletter!'
        registerPage.clickNewsLetterBtn();

        //11. Select checkbox 'Receive special offers from our partners!'
        registerPage.clickSpecialOffersBtn();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        registerPage.typeAdressFirstName(adressName);
        registerPage.typeAdressLastName(addressLastName);
        registerPage.typeAdressCompany(adressCompany);
        registerPage.typeAdressAddress(adress1);
        registerPage.typeAdressAddress2(adress2);
        registerPage.typeAdressCountry(adressCountry);
        registerPage.typeAdressState(adressState);
        registerPage.typeAdressCity(adressCity);
        registerPage.typeAdressZipCode(adressZipCode);
        registerPage.typeAdressPhoneNumber(adressPhoneNumber);
        registerPage.clickCreateAccount();

        return  accountCreatedPage;
    }
    public DeletedAccount getDeletedAccount(){
        accountCreatedPage.getAccountCreatedText();
        accountCreatedPage.clickContinueBtn();
        return deletedAccount;

    }



}
