package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeletedAccount extends BasePage {

    private By accountDeletedName = By.cssSelector("[data-qa='account-deleted']");
    private By continueBtn = By.cssSelector("[data-qa='continue-button']");
    public DeletedAccount(WebDriver driver) {
        super(driver);
    }

    public String getDeleteAccounText() {
      return   getValue(accountDeletedName);
    }

    public void clickDeleteAccountContinueBtn() {
        click(continueBtn);
    }
}
