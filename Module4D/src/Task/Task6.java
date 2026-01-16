package Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task6 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Navigate to saucedemo
        driver.get("https://www.saucedemo.com/");

        // 2. Login
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        // 3. Add ONE product (Sauce Labs Bolt T-Shirt)
        driver.findElement(By.cssSelector("button[data-test='add-to-cart-sauce-labs-bolt-t-shirt']")).click();

        // 4. Click cart icon
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();

        // 5. Click checkout
        driver.findElement(By.cssSelector("#checkout")).click();

        // driver.quit();
    }
}
