package sushantlokhandeacademy.AbstractComponents;



import org.checkerframework.checker.units.qual.A;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.CartPage;

import pageobjects.OrdersPage;



import java.time.Duration;



public class AbstractComponents {

    WebDriver driver;



    public AbstractComponents(WebDriver driver) {

        this.driver = driver;



    }



    @FindBy(css = "[routerlink*='myorders']")

    WebElement ordersHeader;



    @FindBy(css = "[routerlink*='cart']")

    WebElement cartHeader;



    By toast = By.cssSelector("#toast-container");



    // By sd = By.cssSelector("[routerlink*='cart']");





    @FindBy(css = ".ng-animating")

    WebElement spinner;



    public void waitForElementToAppear(By findBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));



    }



    public void waitForWebElementToAppear(WebElement findBy) {



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOf((findBy)));

    }



    public void waitForListofWebElementsToAppear(WebElement findBy){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfAllElements(findBy));





    }



    public void waitForListofWebElementsToAppear(By findBy){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // wait.until(ExpectedConditions.visibilityOfAllElements(findBy));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));



    }

    public void waitForListofWebElementToBeClickable(By findBy){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // wait.until(ExpectedConditions.visibilityOfAllElements(findBy));

        wait.until(ExpectedConditions.elementToBeClickable(findBy));



    }





    public void waitForElementTodisappear(WebElement Ele) throws InterruptedException {

        // Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.invisibilityOf(spinner));



    }



    public OrdersPage goToOrdersPage() {

        ordersHeader.click();

        OrdersPage ordersPage = new OrdersPage(driver);

        return ordersPage;



    }





    public CartPage goToCartPage() throws InterruptedException {

        // cartHeader.click();

        Actions actions = new Actions(driver);

        actions.moveToElement(cartHeader).click().build().perform();

        CartPage cartPage = new CartPage(driver);

        return cartPage;



    }







}

