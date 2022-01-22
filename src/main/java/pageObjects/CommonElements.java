package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonElements extends BasePage{

    public CommonElements(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[class='shopping_cart_link']")
    private WebElement openCartButton;

    public void openCart() {
        clickElement(openCartButton);
    }
}
