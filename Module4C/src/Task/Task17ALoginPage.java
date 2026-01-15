package Task;

public abstract class Task17ALoginPage {

    public void usernameField() {
        System.out.println("Username field displayed");
    }

    public void passwordField() {
        System.out.println("Password field displayed");
    }

    public void forgotPasswordLink() {
        System.out.println("Forgot password link displayed");
    }

    public void signInButton() {
        System.out.println("Sign in button displayed");
    }

    // Elements that vary by product
    public abstract void rememberMeCheckbox();
    public abstract void oauthLogin();
    public abstract void continueToHomePage();
}
