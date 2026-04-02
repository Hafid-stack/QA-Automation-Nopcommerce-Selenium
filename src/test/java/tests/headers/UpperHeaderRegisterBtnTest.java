package tests.headers;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import utilitypages.HeaderUpperPage;

public class UpperHeaderRegisterBtnTest extends BaseTest {


    @Test(description = "Testing upper header clicks")
    public void clickRegisterHeader()  {


        HeaderUpperPage headerUpperPage = new HeaderUpperPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        log("step 1");

        headerUpperPage.clickRegisterButton();
        log("Clicking on register button");
    }
}
