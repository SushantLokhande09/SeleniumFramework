package pageobjects;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import sushantlokhandeacademy.AbstractComponents.AbstractComponents;


public class BillPage extends AbstractComponents {

    WebDriver driver;


    public BillPage(WebDriver driver) {

        super(driver);

        this.driver = driver;

        PageFactory.initElements(driver, this);


    }


    @FindBy(tagName = "h1")

    WebElement orderSuccessmMessage;

    By successMessge1 = By.tagName("h1");


    public String successMessage() {

        waitForElementToAppear(successMessge1);

        String successMessageOfOrders = orderSuccessmMessage.getText().toLowerCase();

        return successMessageOfOrders;


    }


}
