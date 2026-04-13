package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);

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

        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(locator));

        int attempts = 0;

        while (attempts < 3) {

            element.clear();

            if (text.isEmpty()) {
                element.sendKeys(" ");
                element.sendKeys(Keys.BACK_SPACE);
            } else {
                element.sendKeys(text);
            }

            String enteredText = element.getAttribute("value");

            if (enteredText.equals(text)) {
                return;
            }

            attempts++;
        }

        throw new RuntimeException("Failed to type text into field: " + locator);
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
    protected void clickImproved(By locator){
        WebElement element = waitForClickability(locator);

        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            scrollToElement(element);
            try {
                element.click();
            } catch (ElementClickInterceptedException ex) {
                jsClick(element);
            }
        }
    }

    protected void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", element
        );
    }

    protected void jsClick(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    protected void clickWithRetry(By locator, int attempts){
        for(int i=0;i<attempts;i++){
            try{
                clickImproved(locator);
                return;
            } catch(Exception e){
                log("Click failed, retrying... attempt " + (i+1));
                try {
                    sleep(200); // short wait
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        throw new RuntimeException("Failed to click after " + attempts + " attempts: " + locator);
    }
    protected void closeAdsIfPresent(){
        List<By> ads = List.of(
                By.cssSelector("iframe[id^='aswift']"),
                By.cssSelector(".ad-banner")
        );

        for(By ad : ads){
            try{
                driver.switchTo().frame(driver.findElement(ad));
                WebElement close = driver.findElement(By.cssSelector(".close"));
                close.click();
                driver.switchTo().defaultContent();
                log("Ad closed successfully");
            } catch(Exception e){
                driver.switchTo().defaultContent();
            }
        }
    }
    protected WebElement waitFor(ExpectedCondition<WebElement> condition, int timeoutSeconds){
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return customWait.until(condition);
    }
    protected WebElement waitForClickabilityImproved(By locator){
        return waitFor(ExpectedConditions.elementToBeClickable(locator), 15);
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected String getTitleText() {
        return driver.getTitle();
    }
    protected List<WebElement> waitForVisibilityOfElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

}
