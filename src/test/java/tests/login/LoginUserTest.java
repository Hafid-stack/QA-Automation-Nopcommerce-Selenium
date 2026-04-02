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

        log("Clicked Login button");

        log("Check if login page is opened");




    }
}
