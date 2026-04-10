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
    public AccountCreatedPage getAccountCreatedPage(UserData userData) {
        if (userData.getGender()==1){
            registerPage.titleMr();

        }else if (userData.getGender()==2){
            registerPage.titleMrs();
        }
        registerPage.typeAccountName(userData.getAccountName());
        registerPage.typeAccountPassword(userData.getPassword());
        registerPage.setDataOfBirth(userData.getYear(),userData.getMonth(),userData.getDay());

        //10. Select checkbox 'Sign up for our newsletter!'
        registerPage.clickNewsLetterBtn();

        //11. Select checkbox 'Receive special offers from our partners!'
        registerPage.clickSpecialOffersBtn();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        registerPage.typeAdressFirstName(userData.getFirstName());
        registerPage.typeAdressLastName(userData.getLastName());
        registerPage.typeAdressCompany(userData.getCompany());
        registerPage.typeAdressAddress(userData.getAddress1());
        registerPage.typeAdressAddress2(userData.getAddress2());
        registerPage.typeAdressCountry(userData.getCountry());
        registerPage.typeAdressState(userData.getState());
        registerPage.typeAdressCity(userData.getCity());
        registerPage.typeAdressZipCode(userData.getZipCode());
        registerPage.typeAdressPhoneNumber(userData.getPhoneNumber());
        registerPage.clickCreateAccount();

        return  accountCreatedPage;
    }
    public HomePage getHomePage(){
        accountCreatedPage.clickContinueBtn();
        return  homePage;
    }
    public DeletedAccountPage getDeletedAccount(){
        //accountCreatedPage.getAccountCreatedText();
        accountCreatedPage.clickContinueBtn();
        return deletedAccountPage;

    }



}
