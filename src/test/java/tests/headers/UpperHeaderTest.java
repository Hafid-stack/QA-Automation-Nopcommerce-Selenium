package tests.headers;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;
import utilitypages.HeaderUpperPage;

public class UpperHeaderTest extends BaseTest {

    @Test(description = "Testing uppder header clicks")
    public void clickRegisterHeader(){


        HeaderUpperPage headerUpperPage = new HeaderUpperPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        headerUpperPage.clickRegisterButton();
        log("Clicking on register button");

        String expectedResults=registerPage.checkRegisterHeader();
        String actualResults = "Register";
        Assert.assertEquals(expectedResults,actualResults,"Register failed");
        log("Check if we are in the register page");
        log("Testing uppder header clicks passed");
    }
}
