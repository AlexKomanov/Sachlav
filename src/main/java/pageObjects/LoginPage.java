package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(css = "[id='user-name']")
    WebElement usernameField;

    @FindBy(css = "[id='password']")
    WebElement passwordField;

    @FindBy(css = "[id='login-button']")
    WebElement loginButton;

    //Methods
    public void login(String username, String password) {
        fillText(usernameField, username);
        fillText(passwordField, password);
        clickElement(loginButton);
    }
}
