package Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task10 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://jqueryui.com/");

        driver.findElement(By.linkText("Dialog")).click();

        WebElement frame = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frame);

        driver.findElement(By.className("ui-dialog-titlebar-close")).click();

        System.out.println("Dialog closed successfully");
    }
}
