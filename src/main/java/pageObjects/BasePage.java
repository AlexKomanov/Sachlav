package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    //Elements
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, 30);
    }

    //Methods
    public void fillText(WebElement element, String text){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(WebElement element) {
        //HighLight
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public String getElementText(WebElement element){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean elementIsDisplayed(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public boolean isUrlCorrect(String url) {
        return driver.getCurrentUrl().equals(url);
    }





}
