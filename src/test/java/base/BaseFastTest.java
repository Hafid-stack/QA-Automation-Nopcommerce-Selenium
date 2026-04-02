package base;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class BaseFastTest extends BaseTest {

    @Test
    public void baseFastTest() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        AccountCreatedPage accountCreatedPage=new AccountCreatedPage(driver);
        DeletedAccount deletedAccount=new DeletedAccount(driver);


        homePage.clickLoginSinginBtn();


        loginPage.typeSingInFirstName("whatever");
        log("Typed first name");
        loginPage.typeSingInEmail("whatever22@gmail.com");
        log("Typed email");
        loginPage.clickSingInRegisterButton();
        registerPage.setDataOfBirth(1999,8,13);

        Thread.sleep(10000);
        registerPage.typeAdressCountry("Canada");
        Thread.sleep(10000);

        log("Date of Birth set");
    }
}
