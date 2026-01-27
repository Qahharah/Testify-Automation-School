package Task;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Task15 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void searchTestifyOnGoogle() {
        driver.get("https://www.google.com");

        WebElement searchBox =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

        searchBox.sendKeys("testify");
        searchBox.sendKeys(Keys.ENTER);

        Assert.assertTrue(driver.getTitle().toLowerCase().contains("testify"));
    }

    @Test(priority = 2)
    public void closeBrowserAfterGoogleSearch() {
        Assert.assertNotNull(driver);
    }

    @Test(priority = 3)
    public void printOrderNowButtonColor() {

        driver.get("https://www.mcdonalds.com/us/en-us.html");

        try {
            By acceptButton =
                    By.xpath("//button[.//text()[contains(.,'Accept')]]");
            wait.until(ExpectedConditions.elementToBeClickable(acceptButton)).click();
        } catch (TimeoutException ignored) {
        }

        wait.until(driver ->
                ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );

        By orderNowButton = By.xpath("//a[contains(@href,'order')]");

        WebElement orderNow =
                wait.until(ExpectedConditions.elementToBeClickable(orderNowButton));

        String backgroundColor = orderNow.getCssValue("background-color");

        System.out.println("Order Now button color: " + backgroundColor);

        Assert.assertNotNull(backgroundColor, "Order Now button color is null");
        Assert.assertFalse(backgroundColor.isEmpty(), "Order Now button color is empty");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            //driver.quit();
        }
    }
}
