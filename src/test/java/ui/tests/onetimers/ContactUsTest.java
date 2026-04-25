package ui.tests.onetimers;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

import java.io.IOException;

public class ContactUsTest extends BaseTest {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
    @Test(description = "Test Case 6: Contact Us Form")
    public void contactUsTest() throws IOException {
        log("Contact Us Form test started");
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        //3. Verify that home page is visible successfully
        String expectedLink ="https://automationexercise.com/";
        String actualLink=driver.getCurrentUrl();
        Assert.assertEquals(actualLink, expectedLink,"Home page failed");
        log("Home page successfully loaded, Url check");
        //Title check
        String expectedTitle=driver.getTitle();
        String actualTitle="Automation Exercise";
        Assert.assertEquals(expectedTitle, actualTitle,"Home page failed");
        log("Home page successfully loaded, Tile check");

        //4. Click on 'Contact Us' button
        homePage.clickContactUsButton();
        log("Contact Us Form clicked");

        //5. Verify 'GET IN TOUCH' is visible
        String actualFormTile=contactUsPage.getFormInContactUsTitle();
        String expectedFormTile="GET IN TOUCH";
        Assert.assertEquals(actualFormTile, expectedFormTile,"Home page failed");
        log("Contact Us Form visible, Title check");

        //6. Enter name, email, subject and message
        contactUsPage.typeInContactUsName("contactusName");
        log("Contact us Name typed");
        contactUsPage.typeInContactUsEmail("contactusEmail@gmail.com");
        log("Contact Us Email typed");
        contactUsPage.typeInContactUsMessage("contactusMessage contactusMessage contactusMessage contactusMessage contactusMessagecontactusMessage ");
        log("Contact Us Message typed");

        //7. Upload file
        contactUsPage.sendFileToContactUs(contactUsPage.createSafeTestFile("testfilesafe"));
        log("Contact Us File uploaded");

        //8. Click 'Submit' button
        contactUsPage.clickSubmitButton();
        log("Contact Us submit button clicked");

        //9. Click OK button
        driver.switchTo().alert().accept();
        log("Contact Us Alert OK button clicked");

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        String actualSuccessMessage=contactUsPage.getFormMessageSubmitedSuccessfullyText();
        String expectedSuccessMessage="Success! Your details have been submitted successfully.";
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage,"Contact Us Alert failed");
        log("Contact Us success message, text check");

        //11. Click 'Home' button and verify that landed to home page successfully
        contactUsPage.clickFormHomeButton();
        log("Contact Us Home button clicked");

        wait.until(ExpectedConditions.urlContains("automationexercise.com"));
        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"), "Home page URL mismatch");
        log("Home page successfully loaded, URL check");

        //Title check
        wait.until(ExpectedConditions.titleIs("Automation Exercise"));
        Assert.assertTrue(driver.getTitle().equals("Automation Exercise"), "Home page title mismatch");
        log("Home page successfully loaded, Title check");

        log("Test passed");
    }
}
