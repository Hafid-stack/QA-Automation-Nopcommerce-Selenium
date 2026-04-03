package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage {

    private By testCasesPageTitle= By.cssSelector(".container b");

    public  TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public String getTestCasesPageTitle() {
        return getValue(testCasesPageTitle);
    }
}
