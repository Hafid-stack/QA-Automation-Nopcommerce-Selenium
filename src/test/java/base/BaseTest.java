package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl="https://automationexercise.com/";

    @BeforeClass
    public void setUp() {

        ChromeOptions options = new ChromeOptions();

        // Disable popups / browser noise
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("password_manager_leak_detection", false);
        prefs.put("credentials_enable_service", false);

        options.setExperimentalOption("prefs", prefs);

        // Extra stability
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("~/Library/Application Support/Google/Chrome/Default/Extensions/gighmmpiobklfepjocnamgkkbiglidom/6.38.1");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Explicit wait (longer for stability)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate once here
        driver.get(baseUrl);
        closeAdsIfPresent();
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
            log("Browser closed");
        }
    }

    protected void log(String message) {
        System.out.println("[TEST LOG] " + message);
    }

    protected int getRandomNumber() {
       return  ThreadLocalRandom.current().nextInt(1, 10000);
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
}
