package Task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task18InventoryPage {

    private WebDriver driver;

    private By firstItemAddToCart =
            By.id("add-to-cart-sauce-labs-backpack");
    private By firstItemName =
            By.cssSelector(".inventory_item_name");
    private By cartIcon =
            By.className("shopping_cart_link");

    public Task18InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getItemName() {
        return driver.findElement(firstItemName).getText();
    }

    public Task18CartPage addItemToCartAndGoToCart() {
        driver.findElement(firstItemAddToCart).click();
        driver.findElement(cartIcon).click();
        return new Task18CartPage(driver);
    }
}
