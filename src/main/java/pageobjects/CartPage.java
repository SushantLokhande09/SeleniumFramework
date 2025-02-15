package pageobjects;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import sushantlokhandeacademy.AbstractComponents.AbstractComponents;


import java.util.List;


public class CartPage extends AbstractComponents {

    WebDriver driver;


    public CartPage(WebDriver driver) {

        super(driver);

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }


    @FindBy(css = ".cartWrap h3")

    List<WebElement> itemInCart;


    @FindBy(css = ".totalRow [class='btn btn-primary']")

    WebElement checkoutButton;


    By cart = By.cssSelector(".cartWrap h3");


    public Boolean verifcationOfItemsInCart(String productName) throws InterruptedException {


        //waitForElementToAppear(cart);

       // waitForListofWebElementsToAppear(cart);

        waitForListofWebElementToBeClickable(cart);

        //Thread.sleep(2000);


        Boolean match = itemInCart.stream().anyMatch(items ->

                items.getText().equalsIgnoreCase(productName));

        return match;


    }


    public PaymentPage clickOnCheckout() {

        Actions actions = new Actions(driver);

        actions.moveToElement(checkoutButton).click().build().perform();

        PaymentPage paymentPage = new PaymentPage(driver);

        return paymentPage;


    }


}



