package sushantlokhandeacademy.Tests;

//import junit.framework.Assert;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.*;
import sushantlokhandeacademy.TestComponents.BaseTest;
import sushantlokhandeacademy.TestComponents.Retry;

import java.io.IOException;
import java.util.HashMap;

public class StandAloneTest extends BaseTest {
    //String productName = "IPHONE 13 PRO";

    @Test(dataProvider = "getData", groups = {"Purchase", "Smoke"}, retryAnalyzer = Retry.class)
    public void navigatingBrowser(HashMap<String, String> input) throws IOException, InterruptedException {
        ProductCatalogue productCatalogue = landingPage.LoginToApplication(input.get("email"), input.get("password"));

        productCatalogue.ClickonAddtoCart(input.get("productName"));
        //  productCatalogue.goToCartPage();

        CartPage cartPage = productCatalogue.goToCartPage();
//CartPage cartPage = new CartPage(driver);
        Boolean match = cartPage.verifcationOfItemsInCart(input.get("productName"));

        Assert.assertTrue(match);
        // Assert.assertTrue(cartPage.verifcationOfItemsInCart(input.get("productName")));
        PaymentPage paymentPage = cartPage.clickOnCheckout();
        paymentPage.selectCountryFromDropdown();
        paymentPage.selectCountry();
        BillPage billPage = paymentPage.placeOrder();
        Assert.assertTrue(billPage.successMessage().contains("Thankyou for the order.".toLowerCase()));
        //tearDown();


    }

    @Test(dataProvider = "getData", dependsOnMethods = {"navigatingBrowser"})

    public void orderHistroy(HashMap<String, String> input) {
        ProductCatalogue productCatalogue = landingPage.LoginToApplication(input.get("email"), input.get("password"));
        OrdersPage ordersPage = productCatalogue.goToOrdersPage();
        Assert.assertTrue(ordersPage.verifyOrderDisplay(input.get("productName")));
    }

    @DataProvider
    public Object[][] getData() {

        HashMap<String, String> map = new HashMap<>();

        map.put("email", "sushantlokhande@gmail.com");
        map.put("password", "Window@22");
        map.put("productName", "IPHONE 13 PRO");

        HashMap<String, String> map1 = new HashMap<>();

        map1.put("email", "kapilsharma1199@gmail.com");
        map1.put("password", "Laptop@22");
        map1.put("productName", "IPHONE 13 PRO");
        //  ADIDAS ORIGINAL Banarsi Saree
        return new Object[][]{{map}, {map1}};

        // return new Object[][]{{"sushantlokhande@gmail.com", "Window@22", "IPHONE 13 PRO"}, {"kapilsharma1199@gmail.com", "Laptop@22", "BANARSI SAREE"}};


    }


}









