package tests.login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class LoginUserTest extends BaseTest {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
    @Test(description = "Test Case 2: Login User with correct email and password")
    public void loginUserTest(){
        log("Login User test started");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        DeletedAccountPage deletedAccountPage = new DeletedAccountPage(driver);
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

        //6. Enter correct email address and password
        loginPage.typeLoginEmail("correctemail12@gmail.com");
        log("Typed email");
        loginPage.typeLoginPassword("qwertyuiop1234");
        log("Typed Password");

        //7. Click 'login' button
        loginPage.clickLoginButton();
        log("Clicked login button");

        //8. Verify that 'Logged in as username' is visible
        String actualUserName=homePage.getLoggedInAsUserName();
        String expectedUserName="correctname";
        Assert.assertEquals(actualUserName, expectedUserName,"Login page failed");
        log("Home page successfully logged in as intended user, check");

        //9. Click 'Delete Account' button
        homePage.clickDeleteAccount();
        log("Clicked Delete account button");

        //10. Verify that 'ACCOUNT DELETED!' is visible
        String actualDeleteAccountText= deletedAccountPage.getDeleteAccounText();
        String expectedDeleteAccountText="ACCOUNT DELETED!";
        Assert.assertEquals(actualDeleteAccountText, expectedDeleteAccountText,"Delete account failed");
        log("Deleted account is visible, text check");

        log("Test passed");









    }
}
