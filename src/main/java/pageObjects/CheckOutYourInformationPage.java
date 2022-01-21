package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutYourInformationPage extends BasePage{

    public CheckOutYourInformationPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(css = "[id='first-name']")
    private WebElement firstNameField;
    @FindBy(css = "[id='last-name']")
    private WebElement lastNameField;
    @FindBy(css = "[id='postal-code']")
    private WebElement zipCodeField;
    @FindBy(css = "[id='continue']")
    private WebElement continueButton;


    public void fillCheckoutForm(String firstname, String lastname, String zipCode) {
        fillText(firstNameField, firstname);
        fillText(lastNameField, lastname);
        fillText(zipCodeField, zipCode);
        clickElement(continueButton);
    }

}
