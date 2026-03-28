package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl="https://demo.nopcommerce.com/";

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

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Explicit wait (longer for stability)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate once here
        driver.get(baseUrl);

        log("Browser started and navigated to base URL");
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
}
