package tests.onetimers;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TestCasesPage;

public class TestCasesTest extends BaseTest {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'

    @Test(description = "Test Case 7: Verify Test Cases Page")
    public void verifyTestCasesPage() {
        log("Verify Test Cases TEST started");

        HomePage homePage = new HomePage(driver);
        TestCasesPage testCasesPage = new TestCasesPage(driver);
        //3. Verify that home page is visible successfully
        //URL check
        String expectedLink ="https://automationexercise.com/";
        String actualLink=driver.getCurrentUrl();
        Assert.assertEquals(actualLink, expectedLink,"Home page failed");
        log("Home page successfully loaded, Url check");
        //Title check
        String expectedTitle=driver.getTitle();
        String actualTitle="Automation Exercise";
        Assert.assertEquals(expectedTitle, actualTitle,"Home page failed");
        log("Home page successfully loaded, title check");

        //4. Click on 'Test Cases' button
        homePage.clickTestCasesButton();
        log("Test cases button clicked");

        //5. Verify user is navigated to test cases page successfully
        Assert.assertEquals(testCasesPage.getTestCasesPageTitle(), "TEST CASES",
                "Test Cases page title mismatch");
        log("Test cases page, title check");

        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/test_cases", "Test cases page failed");
        log("Test cases page successfully loaded, URL check");

        log("Test passed");

    }
}
