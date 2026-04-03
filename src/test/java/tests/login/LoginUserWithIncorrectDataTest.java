package tests.login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class LoginUserWithIncorrectDataTest extends BaseTest {


//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
    @Test(description = "Test Case 3: Login User with incorrect email and password")
    public void loginUserWithIncorrectDataTest() {
        log("Login User test started");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

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

        //5. Verify 'Login to your account' is visible
        String expectedTtile2="Login to your account";
        String actualTtile2=loginPage.getLoginHeader();
        Assert.assertEquals(actualTtile2, expectedTtile2, "Login page failed");
        log("Login page successfully loaded, check");

        //6. Enter incorrect email address and password
        loginPage.typeLoginEmail("incorrect@gmail.com");
        log("Typed email");
        loginPage.typeLoginPassword("incorrectPassword");
        log("Typed Password");

        //7. Click 'login' button
        loginPage.clickLoginButton();
        log("Clicked login button");


        //8. Verify error 'Your email or password is incorrect!' is visible
        String actualErrorMessage= loginPage.getLoginErrorMessage();
        String expectedErrorMessage="Your email or password is incorrect!";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"Login error failed to display");
        log("Login error message,text check");

        log("Test passed");




    }
}
