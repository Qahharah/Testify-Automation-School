package Task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task18CheckoutCompletePage {

    private WebDriver driver;

    private By successMessage =
            By.className("complete-header");

    public Task18CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
