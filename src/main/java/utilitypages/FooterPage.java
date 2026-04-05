package utilitypages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterPage extends BasePage {

    private By footerUpandDown= By.id("footer");
    private By footerSubscriptionText=By.cssSelector("#footer h2");
    private By footerSubscriptionInput=By.cssSelector("#footer #susbscribe_email");
    private By footerSubscriptionArrow=By.cssSelector("#footer #subscribe");
    private By footerSubscriptionAlert=By.cssSelector("#footer .alert-success.alert");
    public FooterPage(WebDriver driver){
        super(driver);

    }

    public String getFooterSubscriptionText(){
                closeAdsIfPresent();
        return getValue(footerSubscriptionText);
    }
    public void typeFooterSubscriptionText(String text){
        type(footerSubscriptionInput,text);
    }
    public void clickFooterSubscriptionArrow(){
        click(footerSubscriptionArrow);
    }
    public String getFooterSubscriptionAlert(){
        return getValue(footerSubscriptionAlert);
    }
    public By subscriptionLocation(){
        return footerUpandDown;
    }
}
