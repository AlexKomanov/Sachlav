package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends CommonElements {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    //Elements

    @FindBy(css = "[class='inventory_item_name']")
    private List<WebElement> productsTitles;
    @FindBy(css = "[class='title']")
    private WebElement titleOfPage;
    @FindBy(css = "[class='inventory_item']")
    private List<WebElement> listOfProducts;



    public void chooseProduct(String product) {

        for (WebElement productTitle : productsTitles) {
            if (productTitle.getText().equalsIgnoreCase(product)){
                productTitle.click();
                break;
            }
        }
    }



    public String getTitle() {
        return getElementText(titleOfPage);
    }

    public void addToCart(String productName) {

        for (WebElement productAreaElement : listOfProducts) {
            String title = productAreaElement.findElement(By.cssSelector("[class='inventory_item_name']")).getText();
            if(title.equals(productName)) {
                WebElement addButton = productAreaElement.findElement(By.cssSelector(".btn"));
                clickElement(addButton);
                break;
            }
        }
    }
}
