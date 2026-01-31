package Task.Project4D.ParaBank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    // Locators
    private By firstName = By.id("customer.firstName");
    private By lastName = By.id("customer.lastName");
    private By address = By.id("customer.address.street");
    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By zipCode = By.id("customer.address.zipCode");
    private By phone = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");
    private By username = By.id("customer.username");
    private By password = By.id("customer.password");
    private By confirmPassword = By.id("repeatedPassword");

    private By registerButton = By.xpath("//input[@value='Register']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Direct navigation, no clicking Register link
    public void openRegisterPage() {
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
    }

    public void fillRegistrationForm(
            String first,
            String last,
            String addr,
            String cityValue,
            String stateValue,
            String zip,
            String phoneValue,
            String ssnValue,
            String user,
            String pass
    ) {
        driver.findElement(firstName).sendKeys(first);
        driver.findElement(lastName).sendKeys(last);
        driver.findElement(address).sendKeys(addr);
        driver.findElement(city).sendKeys(cityValue);
        driver.findElement(state).sendKeys(stateValue);
        driver.findElement(zipCode).sendKeys(zip);
        driver.findElement(phone).sendKeys(phoneValue);
        driver.findElement(ssn).sendKeys(ssnValue);
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
    }

    public void submitRegistration() {
        driver.findElement(registerButton).click();
    }

    public boolean isRegistrationSuccessful() {
        return driver.findElement(
                By.xpath("//h1[contains(text(),'Welcome')]")
        ).isDisplayed();
    }
}
