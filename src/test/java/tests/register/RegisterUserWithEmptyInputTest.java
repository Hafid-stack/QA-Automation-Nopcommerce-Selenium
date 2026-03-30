package tests.register;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterUserWithEmptyInputTest extends BaseTest {


    @Test(description = "Verify error messages while registering a user with empty input (First name)")
    public void registerUserWithEmptyInputTest(){

         log("Registering User with first name empty input test started");
         HomePage homePage = new HomePage(driver);
         RegisterPage registerPage = new RegisterPage(driver);

         homePage.clickRegisterBtn();
         log("Clicking on register button");

         String expectedResults=registerPage.checkRegisterHeader();
         String actualResults = "Create Account";
         Assert.assertEquals(expectedResults,actualResults,"Register failed");

         log("Register page");


         registerPage.typeFirstName("");
         log("Typed first name");
         registerPage.typeLastName("testlast");
         log("Typed last name");
         registerPage.typeEmail("testuser55@gmail.com");
         log("Typed email");
         registerPage.typePassword("password123");
         log("Typed password");
         registerPage.clickRegisterButton();
         log("Clicked on Register button");

         log("Begin assertion");
         String actualResult2="First name can't be blank.";
         String expectedResults2=registerPage.checkErrorMessage();
         Assert.assertEquals(expectedResults2,actualResult2,"Register failed");

        log("Test passed");

    }
    @Test(description = "Verify error messages while registering a user with empty input (Last Name)")
    public void registerUserWithEmptyInputTest2(){
        log("Registering User with last name empty input test started");
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        homePage.clickRegisterBtn();
        log("Clicking on register button");

        String expectedResults=registerPage.checkRegisterHeader();
        String actualResults = "Create Account";
        Assert.assertEquals(expectedResults,actualResults,"Register failed");

        log("Register page");


        registerPage.typeFirstName("");
        log("Typed first name");
        registerPage.typeLastName("testlast");
        log("Typed last name");
        registerPage.typeEmail("testuser55@gmail.com");
        log("Typed email");
        registerPage.typePassword("password123");
        log("Typed password");
        registerPage.clickRegisterButton();
        log("Clicked on Register button");

        log("Begin assertion");
        String actualResult2="First name can't be blank.";
        String expectedResults2=registerPage.checkErrorMessage();
        Assert.assertEquals(expectedResults2,actualResult2,"Register failed");

        log("Test passed");

    }

}

