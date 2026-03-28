package tests.register;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterUserTest extends BaseTest {


    @Test(description = "Registering use 1")
    public void registerUserTest(){

         log("Registering User 1 test");
         HomePage homePage = new HomePage(driver);
         RegisterPage registerPage = new RegisterPage(driver);

         homePage.clickRegisterBtn();
         log("Clicking on register button");

         String expectedResults=registerPage.checkRegisterHeader();
         String actualResults = "Register";
         Assert.assertEquals(expectedResults,actualResults,"Register failed");

         log("Register page");

         log("Clicking on Gender Select button");
         registerPage.typeFirstName("don");
         log("Type first name");
         registerPage.typeLastName("hafid");
         log("Type last name");
         registerPage.typeEmail("testuser1@gmail.com");
         log("Type email");
         log("Type company name");
         log("Clicking on Newsletter Select button");
         registerPage.typePassword("password123");
         log("Type password");
         log("Type confirm password");
         registerPage.clickRegisterButton();
         log("Clicking on Register button");





    }
}
