package sushantlokhandeacademy.Tests;


import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;
import pageobjects.CartPage;
import pageobjects.ProductCatalogue;
import sushantlokhandeacademy.TestComponents.BaseTest;
import sushantlokhandeacademy.TestComponents.Retry;

public class ErrorValidationsTest extends BaseTest {

    @Test(groups = "ErrorValidationsTest")
    public void failedTests() {

        landingPage.LoginToApplication("sushantlokhande@gmail.com", "Window@2");
        landingPage.getErrorMessage();
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

    }

    @Test(retryAnalyzer = Retry.class)
    public void validation() throws InterruptedException {

        String productName = "IPHONE 13 PRO";
        ProductCatalogue productCatalogue = landingPage.LoginToApplication("kapilsharma1199@gmail.com", "Laptop@22");

        productCatalogue.ClickonAddtoCart(productName);
        CartPage cartPage = productCatalogue.goToCartPage();

        Assert.assertFalse(cartPage.verifcationOfItemsInCart("IPHONE 13 PRO1"));

    }



}

