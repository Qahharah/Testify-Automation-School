package Task17;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task17WidgetsTest extends Task17BaseTest {

    @Test
    public void interactWithAccordion() {
        driver.get("https://demoqa.com/accordian");

        driver.findElement(By.id("section1Heading")).click();

        boolean contentVisible =
                driver.findElement(By.id("section1Content")).isDisplayed();

        Assert.assertTrue(contentVisible, "Accordion content should be visible");
    }
}
