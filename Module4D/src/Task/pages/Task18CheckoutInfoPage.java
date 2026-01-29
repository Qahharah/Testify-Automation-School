package Task.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task18CheckoutInfoPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");

    public Task18CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public Task18CheckoutOverviewPage enterDetailsAndContinue(
            String fName, String lName, String zip) {

        WebElement firstNameInput =
                wait.until(ExpectedConditions.elementToBeClickable(firstName));
        scrollIntoView(firstNameInput);
        firstNameInput.clear();
        firstNameInput.sendKeys(fName);

        WebElement lastNameInput =
                wait.until(ExpectedConditions.elementToBeClickable(lastName));
        scrollIntoView(lastNameInput);
        lastNameInput.clear();
        lastNameInput.sendKeys(lName);

        WebElement postalCodeInput =
                wait.until(ExpectedConditions.elementToBeClickable(postalCode));
        scrollIntoView(postalCodeInput);
        postalCodeInput.clear();
        postalCodeInput.sendKeys(zip);

        WebElement continueBtn =
                wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueBtn.click();

        return new Task18CheckoutOverviewPage(driver);
    }

    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
