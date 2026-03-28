package tests.headers;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;
import utilitypages.HeaderUpperPage;

public class UpperHeaderTest extends BaseTest {


    @Test(description = "Testing upper header clicks")
    public void clickRegisterHeader(){


        HeaderUpperPage headerUpperPage = new HeaderUpperPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        log("step 1");
        headerUpperPage.clickRegisterButton();
        log("Clicking on register button");

        String expectedResults=registerPage.checkRegisterHeader();

        String actualResults = "Register";
        Assert.assertEquals(expectedResults,actualResults,"Register button click failed");

        log("Testing upper header click passed");
    }
}
