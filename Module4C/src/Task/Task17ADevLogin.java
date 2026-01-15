package Task;

public class Task17ADevLogin extends Task17ALoginPage {

    @Override
    public void rememberMeCheckbox() {
        System.out.println("Remember me checkbox enabled");
    }

    @Override
    public void oauthLogin() {
        System.out.println("Login with Google enabled");
    }

    @Override
    public void continueToHomePage() {
        System.out.println("Redirecting to home page");
    }

    public static void main(String[] args) {
        Task17ADevLogin login = new Task17ADevLogin();

        login.usernameField();
        login.passwordField();
        login.forgotPasswordLink();
        login.signInButton();
        login.rememberMeCheckbox();
        login.oauthLogin();
        login.continueToHomePage();
    }
}
