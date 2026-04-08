package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {


    private By nameOnCard= By.cssSelector("[data-qa='name-on-card']");
    private By numberOnCard= By.cssSelector("[data-qa='card-number']");
    private By cvcCard= By.cssSelector("[data-qa='cvc']");
    private By expiryMonthCard= By.cssSelector("[data-qa='expiry-month']");
    private By expiryYearCard= By.cssSelector("[data-qa='expiry-year']");
    private By payAndConfirmBtn= By.cssSelector("[data-qa='pay-button']");
    protected PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void typeNameOnCard(String cardName){
        type(nameOnCard,cardName);
    }
    public void typeNumberOnCard(String cardNumber){
        type(numberOnCard,cardNumber);
    }
    public void typeCvcCard(String cvcCard3){
        type(cvcCard,cvcCard3);
    }
    public void typeExpiryMonthCard(String monthCard){
        type(expiryMonthCard,monthCard);
    }
    public void typeExpiryYearCard(String yearCard){
        type(expiryYearCard,yearCard);
    }
    public void clickPayButton(){
        click(payAndConfirmBtn);
    }

}
