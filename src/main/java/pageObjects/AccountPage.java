package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{

    //Elements
    By beginnerIcon = By.cssSelector("[id='Beginner']");
    By intermediateIcon = By.cssSelector("[id='Intermediate']");
    By advancedIcon = By.cssSelector("[id='Advanced']");
    By nextButton = By.cssSelector("#next");

    //Constructor
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickIcons() {
        clickElement(driver.findElement(beginnerIcon));
        clickElement(driver.findElement(intermediateIcon));
        clickElement(driver.findElement(advancedIcon));
    }

    public void clickNext() {
        clickElement(driver.findElement(nextButton));
    }

    public boolean accountPageIsDisplayed () {
        return elementIsDisplayed(driver.findElement(beginnerIcon));
    }
}
