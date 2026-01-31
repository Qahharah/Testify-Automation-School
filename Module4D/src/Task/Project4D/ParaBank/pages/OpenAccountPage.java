package Task.Project4D.ParaBank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This Page Object represents the "Open New Account" page on ParaBank.
 * It contains all locators and actions related to opening a new bank account.
 */
public class OpenAccountPage {

    // WebDriver instance used to interact with the browser
    private WebDriver driver;

    // WebDriverWait used for explicit waits to handle dynamic elements
    private WebDriverWait wait;

    // Locator for the "Open New Account" link in the Account Services menu
    private By openAccountLink = By.linkText("Open New Account");

    // Locator for the "Open New Account" submit button
    private By openAccountButton = By.xpath("//input[@value='Open New Account']");

    // Locator for a success indicator after account creation
    // We assert using a visible heading instead of backend account IDs
    private By successHeader = By.xpath("//h1[contains(text(),'Account')]");

    /**
     * Constructor initializes WebDriver and WebDriverWait
     * @param driver WebDriver instance passed from the BaseTest
     */
    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Navigates to the Open New Account page
     * by clicking the "Open New Account" link.
     */
    public void openPage() {
        wait.until(ExpectedConditions.elementToBeClickable(openAccountLink)).click();
    }

    /**
     * Opens a new Savings account using the default selections
     * and submits the form.
     */
    public void openSavingsAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(openAccountButton)).click();
    }

    /**
     * Verifies that the account was opened successfully
     * by checking for a visible success-related heading.
     *
     * @return true if account creation was successful
     */
    public boolean isAccountOpenedSuccessfully() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successHeader))
                .isDisplayed();
    }
}
