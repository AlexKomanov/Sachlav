package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends CommonElements {


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(css = "[class='btn btn_primary btn_small btn_inventory']")
    private WebElement addToCartButton;
    @FindBy(css = "[id='back-to-products']")
    private WebElement backToProductsButton;


    //Methods
    public void addToCart() {
        clickElement(addToCartButton);
    }

    public void backToProductsPage() {
        clickElement(backToProductsButton);
    }
}
