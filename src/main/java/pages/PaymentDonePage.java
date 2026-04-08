package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentDonePage extends BasePage {

    private By OrderSuccessMessage=By.cssSelector("#form .container p");
    private By continueBtn=By.cssSelector("[data-qa='continue-button']");
    public PaymentDonePage(WebDriver driver) {
        super(driver);
    }
    public String getOrderMessage(){
        return getValue(OrderSuccessMessage);
    }
    public void clickContinueBtn(){
        click(continueBtn);
    }
}
