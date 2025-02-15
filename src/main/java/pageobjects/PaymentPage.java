package pageobjects;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import sushantlokhandeacademy.AbstractComponents.AbstractComponents;


import java.util.List;


public class PaymentPage extends AbstractComponents {


    WebDriver driver;


    public PaymentPage(WebDriver driver) {

        super(driver);

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }


    @FindBy(css = "[placeholder*='Country']")

    WebElement countryField;


    @FindBy(css = ".ta-item.list-group-item.ng-star-inserted")

    List<WebElement> listOfCountires;


    @FindBy(css = ".action__submit")

    WebElement placeOrderButton;


    By countryfiled = By.cssSelector("[placeholder*='Country']");

    By selectCountry = By.cssSelector(".ta-item.list-group-item.ng-star-inserted");


    public void selectCountryFromDropdown() {

        //waitForElementToAppear(countryfiled);

        countryField.sendKeys("ind");


    }


    public void selectCountry() {


        waitForElementToAppear(selectCountry);

        WebElement country = listOfCountires.stream().filter(s -> s.findElement(By.cssSelector("span")).getText().equals("India")).findFirst().orElse(null);

        country.click();

    }


    public BillPage placeOrder() {

        Actions actions = new Actions(driver);

        actions.moveToElement(placeOrderButton).click().build().perform();

        BillPage billPage = new BillPage(driver);

        return billPage;

    }


}





