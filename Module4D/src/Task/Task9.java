package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task9 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Navigate to saucedemo
        driver.get("https://www.saucedemo.com/");

        // 2. Login
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        // 3. Navigate back to login screen
        driver.navigate().back();

        // 4. Print LOGIN button VALUE attribute
        WebElement loginButton =
                driver.findElement(By.id("login-button"));

        System.out.println(
                "Login button value: "
                        + loginButton.getAttribute("value")
        );

        // 5. Navigate forward to homepage
        driver.navigate().forward();

        // 6. Print product name to confirm homepage
        WebElement productName =
                driver.findElement(By.className("inventory_item_name"));

        System.out.println(
                "Product name: "
                        + productName.getText()
        );

        driver.quit();
    }
}