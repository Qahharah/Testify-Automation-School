package Task17;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task17FormsTest extends Task17BaseTest {

    @Test
    public void submitBasicForm() {
        driver.get("https://demoqa.com/text-box");

        driver.findElement(By.id("userName")).sendKeys("Test User");
        driver.findElement(By.id("userEmail")).sendKeys("test@test.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(By.id("submit")));
        js.executeScript("arguments[0].click();",
                driver.findElement(By.id("submit")));

        String nameOutput = driver.findElement(By.id("name")).getText();
        Assert.assertTrue(nameOutput.contains("Test User"));
    }
}
