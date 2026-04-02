package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage {

    private By accountCreatedText= By.cssSelector("[data-qa='account-created']");
    private By continueBtn=By.cssSelector("[data-qa='continue-button']");

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountCreatedText() {
        return getValue(accountCreatedText);
    }

    public void clickContinueBtn() {
        click(continueBtn);
    }
}
