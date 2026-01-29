package Task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task18CartPage {

    private WebDriver driver;

    private By cartItemName =
            By.className("inventory_item_name");
    private By checkoutButton =
            By.id("checkout");

    public Task18CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartItemName() {
        return driver.findElement(cartItemName).getText();
    }

    public Task18CheckoutInfoPage clickCheckout() {
        driver.findElement(checkoutButton).click();
        return new Task18CheckoutInfoPage(driver);
    }
}
