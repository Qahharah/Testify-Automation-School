package Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task12 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.manage().window().maximize();
            driver.get("https://jqueryui.com/");

            WebElement resizableLink = wait.until(
                    ExpectedConditions.elementToBeClickable(By.linkText("Resizable"))
            );
            resizableLink.click();

            WebElement frame = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.className("demo-frame"))
            );
            driver.switchTo().frame(frame);

            WebElement resizeHandle = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector(".ui-resizable-se")
                    )
            );

            Actions actions = new Actions(driver);
            actions
                    .clickAndHold(resizeHandle)
                    .moveByOffset(120, 40)
                    .release()
                    .perform();

            System.out.println("Task12 completed successfully");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //driver.quit();
        }
    }
}
