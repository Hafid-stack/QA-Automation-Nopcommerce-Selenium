package flows;

import base.BaseFlow;
import models.NewUserSingup;
import models.UserData;
import org.openqa.selenium.WebDriver;
import pages.*;
import utilitypages.HeaderUpperPage;

public class RegisterUserFlow extends BaseFlow {

    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private AccountCreatedPage accountCreatedPage;
    private DeletedAccountPage deletedAccountPage;
    private PaymentPage paymentPage;
    private ViewCartPage viewCartPage;

    public RegisterUserFlow(WebDriver driver) {
        super(driver);
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.deletedAccountPage =new DeletedAccountPage(driver);
        this.registerPage = new RegisterPage(driver);
        this.accountCreatedPage = new AccountCreatedPage(driver);
        this.viewCartPage = new ViewCartPage(driver);
        this.paymentPage = new PaymentPage(driver);
    }
    public LoginPage getLoginPage() {
        homePage.clickLoginSinginBtn();
        return  loginPage;
    }
    public RegisterPage getRegisterPage(NewUserSingup newUserSingup) {
        loginPage.typeSingInFirstName(newUserSingup.getName());
        loginPage.typeSingInEmail(newUserSingup.getEmail());
        loginPage.clickSingInRegisterButton();
        return  registerPage;
    }
    public AccountCreatedPage getAccountCreatedPage
            (UserData userData) {
        if (userData.gender==1){
            registerPage.titleMr();

        }else if (userData.gender==2){
            registerPage.titleMrs();
        }
        registerPage.typeAccountName(userData.accountName);
        registerPage.typeAccountPassword(userData.password);
        registerPage.setDataOfBirth(userData.year,userData.month,userData.day);

        //10. Select checkbox 'Sign up for our newsletter!'
        registerPage.clickNewsLetterBtn();

        //11. Select checkbox 'Receive special offers from our partners!'
        registerPage.clickSpecialOffersBtn();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        registerPage.typeAdressFirstName(userData.firstName);
        registerPage.typeAdressLastName(userData.lastName);
        registerPage.typeAdressCompany(userData.company);
        registerPage.typeAdressAddress(userData.address1);
        registerPage.typeAdressAddress2(userData.address2);
        registerPage.typeAdressCountry(userData.country);
        registerPage.typeAdressState(userData.state);
        registerPage.typeAdressCity(userData.city);
        registerPage.typeAdressZipCode(userData.zipCode);
        registerPage.typeAdressPhoneNumber(userData.phoneNumber);
        registerPage.clickCreateAccount();

        return  accountCreatedPage;
    }
    public HomePage getHomePage(){
        accountCreatedPage.clickContinueBtn();
        return  homePage;
    }
    public DeletedAccountPage getDeletedAccount(){
        accountCreatedPage.getAccountCreatedText();
        accountCreatedPage.clickContinueBtn();
        return deletedAccountPage;

    }



}
