package Task.Project4D.ParaBank.tests;

import Task.Project4D.base.Project4DBaseTest;
import Task.Project4D.ParaBank.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class RegisterTest extends Project4DBaseTest {

    @Test
    public void userCanRegisterSuccessfully() {

        String username = "user_" + UUID.randomUUID().toString().substring(0, 6);
        String password = "Password123$";

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.openRegisterPage();

        registerPage.fillRegistrationForm(
                "Yusuf",
                "Ibrahim",
                "123 Solana Street",
                "Lagos",
                "Lagos",
                "100001",
                "08012345678",
                "123-45-6789",
                username,
                password
        );

        registerPage.submitRegistration();

        Assert.assertTrue(
                registerPage.isRegistrationSuccessful(),
                "Registration was not successful"
        );
    }
}
