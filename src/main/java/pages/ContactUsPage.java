package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {


    private By formInContactUsTitle=By.cssSelector(".contact-form h2");
    private By formTypeName=By.cssSelector("[data-qa='name']");
    private By formTypeEmail=By.cssSelector("[data-qa='email']");
    private By formTypeSubject=By.cssSelector("[data-qa='subject']");
    private By formTypeMessage=By.cssSelector("[data-qa='message']");
    private By formInputFile=By.cssSelector(".form-group.col-md-12 input[type='file']");
    private By formSubmitButton=By.cssSelector("[data-qa='submit-button']");
    private By formMessageSubmitedSuccessfullyText=By.cssSelector(".contact-form .status.alert.alert-success");
    private By formHomeButton=By.cssSelector("#form-section a");



    //===============
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public String getFormInContactUsTitle() {
        return getValue(formInContactUsTitle);
    }

    public void typeInContactUsName(String contactUsName) {
        type(formTypeName, contactUsName);
    }
    public void  typeInContactUsEmail(String email) {
        type(formTypeEmail, email);
    }
    public void typeInContactUsSubject(String subject) {
        type(formTypeSubject, subject);
    }
    public void typeInContactUsMessage(String message) {
        type(formTypeMessage, message);
    }
    public void clickSubmitButton() {
        click(formSubmitButton);
    }
    public void sendFileToContactUs(String fileName) {
        type(formInputFile, fileName);
    }
    public String getFormMessageSubmitedSuccessfullyText() {
        return getValue(formMessageSubmitedSuccessfullyText);
    }
    public void clickFormHomeButton() {
        click(formHomeButton);
    }
}
