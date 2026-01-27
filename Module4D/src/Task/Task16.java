package Task;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Task16 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    @Test
    public void verifyOurContactFooterDetails() {

        driver.get("https://testifyltd.com");

        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebElement footerEmail = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'info@testifyltd.com')]")
                )
        );

        String pageSource = driver.getPageSource();

        Assert.assertTrue(
                pageSource.contains("info@testifyltd.com"),
                "Email not found in footer"
        );

        Assert.assertTrue(
                pageSource.contains("Nigeria"),
                "Location 'Nigeria' not found in footer"
        );

        Assert.assertTrue(
                pageSource.contains("+234"),
                "Phone number not found in footer"
        );
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            //driver.quit();
        }
    }
}
