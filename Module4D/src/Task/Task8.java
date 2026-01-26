package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task8 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://idorenyinankoh.github.io/loginPage/");

        List<WebElement> inputs = driver.findElements(By.tagName("input"));

        inputs.get(0).sendKeys("Qahharat");
        inputs.get(1).sendKeys("Ibrahim");
        inputs.get(2).sendKeys("qahharat.ibrahim@test.com");

        inputs.get(4).click();

        inputs.get(6).sendKeys("Test1234");
        inputs.get(7).sendKeys("Test1234");
        inputs.get(8).sendKeys("Testify task 8");

        driver.findElement(By.tagName("body")).click();

        WebElement button = driver.findElement(By.tagName("button"));
        System.out.println(button.isEnabled());
    }
}
