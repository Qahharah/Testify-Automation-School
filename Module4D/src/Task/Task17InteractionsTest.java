package Task17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task17InteractionsTest extends Task17BaseTest {

    @Test
    public void dragAndDropTest() {
        driver.get("https://demoqa.com/droppable");

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);

        actions
                .moveToElement(source)
                .clickAndHold()
                .pause(500)
                .moveByOffset(150, 0)   // critical: real mouse movement
                .pause(500)
                .moveToElement(target)
                .pause(500)
                .release()
                .build()
                .perform();

        wait.until(ExpectedConditions.attributeContains(
                By.id("droppable"),
                "class",
                "ui-state"
        ));

        String classes = target.getAttribute("class");

        Assert.assertTrue(
                classes.contains("ui-state"),
                "Droppable should change state after drag-and-drop"
        );
    }
}
