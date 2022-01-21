package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class BuyProductsTests extends BaseTest{

    @Test(testName = "Choosing products via product page")
    public void test_01(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        //Products Page
        ProductsPage productsPage = new ProductsPage(driver);
        String productPageTitle = productsPage.getTitle();
        Assert.assertEquals(productPageTitle, "PRODUCTS", "Wrong page title");
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
        Assert.assertEquals(productsPage.getPageUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(testName = "Choosing products from the products page")
    public void test_02(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        //Products Page
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getTitle(), "PRODUCTS", "Wrong page title");
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
        Assert.assertEquals(productsPage.getPageUrl(), "https://www.saucedemo.com/inventory.html");
    }
}
