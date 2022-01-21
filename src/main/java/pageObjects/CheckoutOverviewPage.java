package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage{

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(css = "[id='finish']")
    private WebElement finishButton;

    //Methods
    public void finishCheckout() {
        clickElement(finishButton);
    }
}
