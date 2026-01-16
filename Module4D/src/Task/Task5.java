package Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task5 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/");

            driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
            driver.findElement(By.xpath("//input[@id='login-button']")).click();

            driver.findElement(By.xpath(
                    "//div[text()='Sauce Labs Bolt T-Shirt']/ancestor::div[@class='inventory_item']//button"
            )).click();

            driver.findElement(By.xpath("//span[@class='shopping_cart_badge' and text()='1']"));

            driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

            // driver.findElement(By.xpath("//button[@id='checkout']")).click();

        } finally {
            driver.quit();
        }
    }
}
