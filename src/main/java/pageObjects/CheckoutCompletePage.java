package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage{

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    //Elements

    @FindBy(css = "h2[class='complete-header']")
    private WebElement thankYouMessage;
    @FindBy(css = "[id='back-to-products']")
    private WebElement backHomeButton;

    //Methods
    public String getThankYouMessage() {
        return getElementText(thankYouMessage);
    }

    public void goBackToProductsPage() {
        clickElement(backHomeButton);
    }
}
