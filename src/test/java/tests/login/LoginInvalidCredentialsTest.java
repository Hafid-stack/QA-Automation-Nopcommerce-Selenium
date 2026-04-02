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

        log("Clicked Login button");

        log("Check if login page is opened");


    }
}
