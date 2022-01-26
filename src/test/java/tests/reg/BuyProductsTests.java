package tests.reg;

import com.aventstack.extentreports.Status;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import tests.BaseTest;

public class BuyProductsTests extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify login with different Credentials")
    @Epic("E01")
    @Feature("Feature2: Login")
    @Story("Story:PRO-45262")
    @Test(testName = "Choosing products via product page")
    public void test_01() {
        extentTest = extentReports.createTest("Choosing products via product page");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        //Products Page
        ProductsPage productsPage = new ProductsPage(driver);
        try {
            Assert.assertEquals(productsPage.getTitle(), "PRODUCTS", "Wrong page title");
            extentTest.log(Status.PASS, "The title is correct");
        }
        catch (Exception e) {
            e.printStackTrace();
            extentTest.log(Status.FAIL, "The title is incorrect");
        }
        productsPage.chooseProduct("Sauce Labs Backpack");

        //Product Page
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        productPage.backToProductsPage();

        //Products Page
        productsPage.chooseProduct("Sauce Labs Bike Light");

        //Product Page
        productPage.addToCart();
        productPage.backToProductsPage();

        //Products Page
        productsPage.openCart();

        //Your Cart Page
        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.performCheckout();

        //Checkout
        CheckOutYourInformationPage checkOutYourInformationPage = new CheckOutYourInformationPage(driver);
        checkOutYourInformationPage.fillCheckoutForm("Alex", "Komanov", "20100");

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.finishCheckout();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertEquals(checkoutCompletePage.getThankYouMessage(), "THANK YOU FOR YOUR ORDER");
        checkoutCompletePage.goBackToProductsPage();
        Assert.assertTrue(productsPage.isUrlCorrect("https://www.saucedemo.com/inventory.html"));
        extentTest.log(Status.PASS, "Test 'Choosing products via product page' Passed");

    }

    @Test(testName = "Choosing products from the products page")
    public void test_02(){
        extentTest = extentReports.createTest("Choosing products from the products page");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        //Products Page
        ProductsPage productsPage = new ProductsPage(driver);
        try {
            Assert.assertEquals(productsPage.getTitle(), "PRODUCTS", "Wrong page title");
            extentTest.log(Status.PASS, "The title is correct");
        }
        catch (Exception e) {
            e.printStackTrace();
            extentTest.log(Status.FAIL, "The title is incorrect");
        }
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.openCart();

        //Your Cart Page
        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.performCheckout();

        //Checkout
        CheckOutYourInformationPage checkOutYourInformationPage = new CheckOutYourInformationPage(driver);
        checkOutYourInformationPage.fillCheckoutForm("Alex", "Komanov", "20100");

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.finishCheckout();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertEquals(checkoutCompletePage.getThankYouMessage(), "THANK YOU FOR YOUR ORDER");
        checkoutCompletePage.goBackToProductsPage();
        Assert.assertTrue(productsPage.isUrlCorrect("https://www.saucedemo.com/inventory.html"));
        extentTest.log(Status.PASS, "Test 'Choosing products from the products page' Passed");
    }
}
