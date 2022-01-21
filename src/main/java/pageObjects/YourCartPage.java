package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends BasePage{

    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(css = "[id='checkout']")
    private WebElement checkoutButton;


    public void performCheckout() {
        clickElement(checkoutButton);
    }
}
