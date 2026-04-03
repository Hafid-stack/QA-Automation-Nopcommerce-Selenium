package tests.register;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.Random;

public class RegisterUserTest extends BaseTest {
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'

    @Test(description = "Test Case 1: Register User")
    public void registerUserTest(){
        log("Registering User 1 test started");
         HomePage homePage = new HomePage(driver);
         LoginPage loginPage = new LoginPage(driver);
         RegisterPage registerPage = new RegisterPage(driver);
         AccountCreatedPage accountCreatedPage=new AccountCreatedPage(driver);
         DeletedAccount deletedAccount=new DeletedAccount(driver);
        //3. Verify that home page is visible successfully
        //URL check
        String expectedLink ="https://automationexercise.com/";
        String actualLink=driver.getCurrentUrl();
        Assert.assertEquals(actualLink, expectedLink,"Home page failed");
        log("Home page successfully loaded, check one");
        //Title check
        String expectedTitle=driver.getTitle();
        String actualTitle="Automation Exercise";
        Assert.assertEquals(expectedTitle, actualTitle,"Home page failed");
        log("Home page successfully loaded, check two");

        //4. Click on 'Signup / Login' button
        homePage.clickLoginSinginBtn();

        //5. Verify 'New User Signup!' is visible
        String expectedTtile2="New User Signup!";
        String actualTtile2=loginPage.getSingInRegisterHeader();
        Assert.assertEquals(actualTtile2, expectedTtile2, "Register page failed");
        log("Register page successfully loaded");

        //6. Enter name and email address
        loginPage.typeSingInFirstName("datatest15");
         log("Typed first name");
         loginPage.typeSingInEmail("datatest"+ getRandomNumber() +"@gmail.com");
         log("Typed email");

        //7. Click 'Signup' button
        loginPage.clickSingInRegisterButton();
         log("Clicked on Register button");

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String actualLabelText=registerPage.getRegistrationTitle();
        String expectedLabelText="ENTER ACCOUNT INFORMATION";
        Assert.assertEquals(actualLabelText, expectedLabelText,"Register page failed");

        //9. Fill details: Title, Name, Email, Password, Date of birth
        registerPage.titleMr();
        log("Clicked Mr option");
        registerPage.typeAccountName("datatestagain");
        log("Typed name");
        registerPage.typeAccountPassword("dataTestPassword");
        log("Typed password");
        registerPage.setDataOfBirth(2000,8,12);
        log("Date of Birth set");

        //10. Select checkbox 'Sign up for our newsletter!'
        registerPage.clickNewsLetterBtn();
        log("Clicked on News letter button");

        //11. Select checkbox 'Receive special offers from our partners!'
        registerPage.clickSpecialOffersBtn();
        log("Clicked on special offer button");

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        registerPage.typeAdressFirstName("adressDataFirstName");
        log("Typed adress first name");
        registerPage.typeAdressLastName("adressDataLastName");
        log("Typed adress last name");
        registerPage.typeAdressCompany("adressDataCompany");
        log("Typed adress company");
        registerPage.typeAdressAddress("adressDataAddress one 67575");
        log("Typed adress address one");
        registerPage.typeAdressAddress2("adressDataAddress Second 1234");
        log("Typed adress address second");
        registerPage.typeAdressCountry("Canada");
        log("Typed adress country");
        registerPage.typeAdressState("Adress State");
        log("Typed adress state");
        registerPage.typeAdressCity("adressDataCity First 1234");
        log("Typed adress address one");
        registerPage.typeAdressZipCode("20022");
        log("Typed adress zip code");
        registerPage.typeAdressPhoneNumber("1234567890");
        log("Typed adress phone number");

        //13. Click 'Create Account button'
        registerPage.clickCreateAccount();
        log("Clicked on Register button");

        //14. Verify that 'ACCOUNT CREATED!' is visible
        String actualText=accountCreatedPage.getAccountCreatedText();
        String expectedText="ACCOUNT CREATED!";
        Assert.assertEquals(actualText, expectedText,"Register page failed");
        log("Account Created Successfully");

        //15. Click 'Continue' button
        accountCreatedPage.clickContinueBtn();
        log("Clicked on Continue button");

        //16. Verify that 'Logged in as username' is visible
        String actualuserName=homePage.getLoggedInAsUserName();
        //System.out.println(actualuserName);
        String expecteduserName="datatestagain";
        Assert.assertEquals(actualuserName, expecteduserName,"Login Page failed");
        log("Logged In Successfully as userName");

        //17. Click 'Delete Account' button
        homePage.clickDeleteAccount();
        log("Clicked on Delete button");

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        deletedAccount.clickDeleteAccountContinueBtn();
        log("Clicked on Delete button");
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://automationexercise.com/";
        Assert.assertEquals(actualUrl, expectedUrl,"Login Page failed");
        log("Home page successfully opened");

        log("Test Passed");






    }
}
