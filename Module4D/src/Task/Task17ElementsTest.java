package Task17;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task17ElementsTest extends Task17BaseTest {

    @Test
    public void verifyElementIsDisplayed() {
        driver.get("https://demoqa.com/elements");

        boolean isDisplayed = driver.findElement(By.xpath("//span[text()='Text Box']")).isDisplayed();
        Assert.assertTrue(isDisplayed, "Text Box element should be displayed");
    }
}
