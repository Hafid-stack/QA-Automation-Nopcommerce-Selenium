package tests.login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginUserTest extends BaseTest {


    @Test(description = "Login User Test")
    public void loginUserTest(){
        log("Login User Test");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickLoginBtn();
        log("Clicked Login button");

        log("Check if login page is opened");

        Assert.assertTrue(loginPage.loginPageIsOpen(),"Login page is not opened");

        log("Login page is opened");

        loginPage.typeEmail("testuser111@gmail.com");
        log("Typed email");
        loginPage.typePassword("password123");
        log("Typed password");
        loginPage.clickLoginButton();
        log("Clicked Login button");

        log("Checl if home page is opened for assertion");
        Assert.assertTrue(homePage.getHomepageBodyClass(),"Home page is not opened");
        log("Assertion done");
        log("Test passed");



    }
}
