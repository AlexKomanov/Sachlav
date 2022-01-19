package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    //Elements
    WebDriver driver;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public void fillText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(WebElement element) {
        //HighLight
        element.click();
    }

    public String getElementText(WebElement element){
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
        return element.isDisplayed();
    }

    public void tearDown(){
        driver.quit();
    }



}
