package ui.tests.register;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterUserWithEmptyInputTest extends BaseTest {


    @Test(description = "Verify error messages while registering a user with empty input (First name)")
    public void registerUserWithEmptyInputTest() {

        log("Registering User with first name empty input test started");
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        log("Clicking on register button");
    }}