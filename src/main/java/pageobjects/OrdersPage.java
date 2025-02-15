package pageobjects;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import sushantlokhandeacademy.AbstractComponents.AbstractComponents;


import java.util.List;


public class OrdersPage extends AbstractComponents {

    WebDriver driver;


    public OrdersPage(WebDriver driver) {

        super(driver);

        this.driver = driver;

        PageFactory.initElements(driver, this);


    }


    @FindBy(css = "tbody tr td:nth-child(3)")

    List<WebElement> listOfOrders;


    public Boolean verifyOrderDisplay(String productName) {


        Boolean match = listOfOrders.stream().anyMatch(products -> products.getText().equalsIgnoreCase(productName));

        return match;


    }


}