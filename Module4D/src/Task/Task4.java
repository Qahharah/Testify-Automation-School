package Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Open Guru99
        driver.get("http://demo.guru99.com/");

        // 2. Click Security Project
        driver.findElement(By.linkText("Security Project")).click();

        // 3. Enter text in UserID and Password fields
        driver.findElement(By.name("uid")).sendKeys("qahharat@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Walking321");

        // driver.quit();
    }
}
