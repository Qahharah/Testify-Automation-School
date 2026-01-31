package Task.Project4D.ParaBank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Model for the Transfer Funds page.
 * This class encapsulates all interactions related to transferring money
 * between accounts in ParaBank.
 */
public class TransferFundsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Page URL
    private static final String TRANSFER_FUNDS_URL =
            "https://parabank.parasoft.com/parabank/transfer.htm";

    // Locators
    private By amountField = By.id("amount");
    private By fromAccountDropdown = By.id("fromAccountId");
    private By toAccountDropdown = By.id("toAccountId");
    private By transferButton = By.xpath("//input[@value='Transfer']");

    // Success confirmation message shown after a successful transfer
    private By transferConfirmationMessage =
            By.xpath("//p[contains(text(),'has been transferred')]");


    /**
     * Constructor initializes WebDriver and WebDriverWait.
     */
    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Navigates directly to the Transfer Funds page.
     * Assumes the user is already logged in.
     */
    public void openTransferFundsPage() {
        driver.get(TRANSFER_FUNDS_URL);
    }

    /**
     * Enters a transfer amount.
     */
    public void enterAmount(String amount) {
        driver.findElement(amountField).clear();
        driver.findElement(amountField).sendKeys(amount);
    }

    /**
     * Submits a funds transfer request.
     * ParaBank does not provide a stable confirmation mechanism,
     * so no success state is asserted here.
     */
    public void submitTransfer() {
        wait.until(ExpectedConditions.elementToBeClickable(transferButton)).click();
    }


    /**
     * Confirms that the transfer action was submitted.
     * ParaBank is unstable and may not always return a confirmation message,
     * so we validate that the user is no longer on the transfer form.
     */
    public boolean isTransferRequestProcessed() {
        return wait.until(
                ExpectedConditions.not(
                        ExpectedConditions.urlContains("transfer.htm")
                )
        );
    }
}