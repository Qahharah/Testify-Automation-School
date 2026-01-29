package Task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task18CheckoutOverviewPage {

    private WebDriver driver;

    private By overviewItemName =
            By.className("inventory_item_name");
    private By finishButton =
            By.id("finish");

    public Task18CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getOverviewItemName() {
        return driver.findElement(overviewItemName).getText();
    }

    public Task18CheckoutCompletePage clickFinish() {
        driver.findElement(finishButton).click();
        return new Task18CheckoutCompletePage(driver);
    }
}
