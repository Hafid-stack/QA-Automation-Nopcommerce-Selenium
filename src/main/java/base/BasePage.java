package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(15));


    }

    protected WebElement waitForClickability(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    protected void click(By locator) {
        waitForClickability(locator).click();
    }

    protected WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    protected void type(By locator, String text) {
        WebElement element=waitForVisibility(locator);
        element.clear();
        if(text.isEmpty()) {
            element.sendKeys(" ");
            element.sendKeys(Keys.BACK_SPACE);
        } else {
            element.sendKeys(text);

        }
    }

    protected String  getValue(By locator) {
        return waitForVisibility(locator).getText();
     }

    protected void log(String text) {
        System.out.println("[Pages Log]: " +text);
    }
    protected void submit(By locator) {
        waitForVisibility(locator).submit();
    }
    protected void selectDropDown(By locator, String option) {
        Select selectOption=new Select(waitForVisibility(locator));
        selectOption.selectByVisibleText(option);

    }
    protected void selectDropDownByValue(By locator, String option) {
        Select selectOption=new Select(waitForVisibility(locator));
        selectOption.selectByValue(option);

    }
    public String createSafeTestFile(String fileName) throws IOException {
        File tempFile = new File("src/test/resources/" + fileName);
        if (tempFile.createNewFile()) {
            FileWriter writer = new FileWriter(tempFile);
            writer.write("This is a safe, automated test file for QA purposes.");
            writer.close();
        }
        return tempFile.getAbsolutePath();
    }
    public void clickImproved(By locator){
        WebElement element = waitForClickability(locator);

        try {
            element.click();
        } catch (Exception e) {

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});",
                    element)
            ;

            try {
                element.click();
            } catch (Exception ex) {

                // Final fallback → JS click
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].click();", element
                );
            }
        }
    }


}
