package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutPage extends BasePage {

    //Next Lesson
//    @FindBy(css = "[id='firstname']")
//    WebElement field;

    //Elements
    By firstNameTextField = By.cssSelector("[id='firstname']");
    By lastNameTextField = By.cssSelector("[id='lastname']");
    By emailTextField = By.cssSelector("[name='email']");
    By firstNameError = By.cssSelector("[id='firstname-error']");
    By lastNameError = By.cssSelector("[id='lastname-error']");
    By emailError = By.cssSelector("[id='email-error']");
    By nextButton = By.cssSelector("#next");

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    //Methods

    public void fillWithElement(WebElement element, String text) {
        fillText(element, text);
    }

    public void fillForm(String firstName, String lastName, String email) {
        fillText(driver.findElement(firstNameTextField), firstName);
        fillLastName(lastName);
        fillEmail(email);
        clickNext();
    }

    public void fillForm2(String firstName, String lastName) {
        fillFirstName(firstName);
        fillLastName(lastName);
        clickNext();
    }

    public void fillFirstName(String text) {
        fillText(driver.findElement(firstNameTextField), text);
    }

    public String getFirstNameError() {
        return getElementText(driver.findElement(firstNameError));
    }

    public void fillLastName(String text) {
        fillText(driver.findElement(lastNameTextField), text);
    }

    public String getLastNameError() {
        return getElementText(driver.findElement(lastNameError));
    }

    public void fillEmail(String text) {
        fillText(driver.findElement(emailTextField), text);
    }

    public String getEmailError() {
        return getElementText(driver.findElement(emailError));
    }

    public void clickNext() {
        clickElement(driver.findElement(nextButton));
    }

}
