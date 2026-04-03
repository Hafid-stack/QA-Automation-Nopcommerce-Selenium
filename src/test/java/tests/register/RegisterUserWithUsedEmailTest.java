package tests.register;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class RegisterUserWithUsedEmailTest extends BaseTest {
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'

    @Test(description = "Test Case 5: Register User with existing email")
    public void registerUserTest(){
        log("Registering User with used email test started");
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
        loginPage.typeSingInFirstName("usedemailtest");
         log("Typed first name");
         loginPage.typeSingInEmail("correctemail12@gmail.com");
         log("Typed email");

        //7. Click 'Signup' button
        loginPage.clickSingInRegisterButton();
         log("Clicked on Register button");

        //8. Verify error 'Email Address already exist!' is visible
        String actualEmailError=loginPage.getSinginEmailErrorMessage();
        String expectedEmailError="Email Address already exist!";
        Assert.assertEquals(actualEmailError, expectedEmailError,"Email Address already exist!");
        log("Email Address already used error message, text check");



        log("Test Passed");






    }
}
