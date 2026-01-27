package Task;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task14 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            driver.manage().window().maximize();
            driver.get("https://www.toolsqa.com/");

            try {
                WebElement acceptCookies = wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                By.id("accept-cookie-policy")
                        )
                );
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].click();", acceptCookies
                );
            } catch (TimeoutException ignored) {
            }

            WebElement tutorialsButton = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//a[normalize-space()='Tutorials']")
                    )
            );

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView(true);", tutorialsButton
            );

            Thread.sleep(1000); // allow header animation to settle

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", tutorialsButton
            );

            System.out.println("I have completed Task 14 successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
