package Task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task18LoginPage {

    private WebDriver driver;

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");

    public Task18LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public Task18InventoryPage login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
        return new Task18InventoryPage(driver);
    }
}
