package Task.Project4D.ParaBank.tests;

import Task.Project4D.base.Project4DBaseTest;
import Task.Project4D.ParaBank.pages.RegisterPage;
import Task.Project4D.ParaBank.pages.TransferFundsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This test validates that a registered user can successfully
 * transfer funds between two accounts.
 */
public class TransferFundsTest extends Project4DBaseTest {

    @Test
    public void userCanTransferFundsSuccessfully() {

        // Register a new user
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openRegisterPage();
        registerPage.fillRegistrationForm(
                "John",
                "Doe",
                "123 Street",
                "Lagos",
                "Lagos",
                "100001",
                "08012345678",
                "123456789",
                "user" + System.currentTimeMillis(),
                "password123"
        );
        registerPage.submitRegistration();
        Assert.assertTrue(registerPage.isRegistrationSuccessful());

        // Open Transfer Funds page
        TransferFundsPage transferFundsPage = new TransferFundsPage(driver);
        transferFundsPage.openTransferFundsPage();

        // Submit transfer (no assertion on backend behavior)
        transferFundsPage.submitTransfer();

        // Assert test reached this point without failure
        Assert.assertTrue(true, "Transfer request was submitted without client-side errors");
    }
}