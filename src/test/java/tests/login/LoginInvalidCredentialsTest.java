package tests.login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginInvalidCredentialsTest extends BaseTest {

//Captch prevents the test from finishing, but it works mannually
    @Test(description = "Login with invalid user info")
    public void loginInvalidCredentialsTest() throws InterruptedException {
        log("Login empty fields test passed");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickLoginBtn();
        log("Clicked Login button");

        log("Check if login page is opened");

        Assert.assertTrue(loginPage.loginPageIsOpen(),"Login page is not opened");

        log("Login page is opened");

        loginPage.typeEmail("wronguser@wrong.com");
        log("Typed email");
        loginPage.typePassword("wrongpassword123");
        log("Typed password");
        Assert.assertTrue(loginPage.isSinginBtnClickable(),"Sing in btn is not clickable");

        loginPage.clickLoginButton();
        log("Clicked Login button");
        //System.out.println(driver.getPageSource());
        log("Checl if error message appears for assertion");
        String expectedResult="Incorrect email or password.";
        String actualResult = loginPage.getErrorMessage();
        Assert.assertTrue(actualResult.equals(expectedResult),"Error message is not correct.");
        log("Assertion done");
        log("Test passed");


    }
}
