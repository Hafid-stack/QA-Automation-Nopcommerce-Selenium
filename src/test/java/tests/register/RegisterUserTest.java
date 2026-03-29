package tests.register;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterUserTest extends BaseTest {


    @Test(description = "Registering use 1")
    public void registerUserTest(){

         log("Registering User 1 test started");
         HomePage homePage = new HomePage(driver);
         RegisterPage registerPage = new RegisterPage(driver);

         homePage.clickRegisterBtn();
         log("Clicking on register button");

         String expectedResults=registerPage.checkRegisterHeader();
         String actualResults = "Create Account";
         Assert.assertEquals(expectedResults,actualResults,"Register failed");

         log("Register page");


         registerPage.typeFirstName("don1");
         log("Typed first name");
         registerPage.typeLastName("hafid1");
         log("Typed last name");
         registerPage.typeEmail("testuser111@gmail.com");
         log("Typed email");
         registerPage.typePassword("password123");
         log("Typed password");
         registerPage.clickRegisterButton();
         log("Clicked on Register button");

         log("Begin assertion");
        Boolean expectedResults2=homePage.getHomepageBodyClass();
        Assert.assertTrue(expectedResults2,"Register button click failed");

        log("Test passed");






    }
}
