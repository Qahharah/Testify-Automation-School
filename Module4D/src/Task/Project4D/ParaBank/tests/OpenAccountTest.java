package Task.Project4D.ParaBank.tests;

import Task.Project4D.base.Project4DBaseTest;
import Task.Project4D.ParaBank.pages.OpenAccountPage;
import Task.Project4D.ParaBank.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

// This test class validates that a registered user can successfully open a new Savings account.
public class OpenAccountTest extends Project4DBaseTest {


    @Test
    public void userCanOpenSavingsAccount() {

        //  Initialize the RegisterPage
        RegisterPage registerPage = new RegisterPage(driver);

        //  Navigate directly to the registration page
        registerPage.openRegisterPage();

        //  Generate unique credentials to avoid duplication issues
        String username = "user" + System.currentTimeMillis();
        String password = "password123";

        //  Fill the registration form with valid details
        registerPage.fillRegistrationForm(
                "Yusuf",
                "Ibrahim",
                "Street 1",
                "Lagos",
                "Lagos",
                "100001",
                "08012345678",
                "1234",
                username,
                password
        );

        //  Submit the registration form
        registerPage.submitRegistration();

        //  Assert that registration was successful
        Assert.assertTrue(
                registerPage.isRegistrationSuccessful(),
                "Registration was not successful"
        );

        //  Initialize the OpenAccountPage
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);

        //  Navigate to the Open New Account page
        openAccountPage.openPage();

        //  Open a new Savings account
        openAccountPage.openSavingsAccount();

        //  Assert that the account was opened successfully
        Assert.assertTrue(
                openAccountPage.isAccountOpenedSuccessfully(),
                "Account was not opened successfully"
        );
    }
}
