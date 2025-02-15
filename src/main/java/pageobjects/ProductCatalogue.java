package pageobjects;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import sushantlokhandeacademy.AbstractComponents.AbstractComponents;


import java.util.List;


public class ProductCatalogue extends AbstractComponents {

    WebDriver driver;


    public ProductCatalogue(WebDriver driver) {

        super(driver);

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }


    @FindBy(css = ".col-lg-4")

    List<WebElement> products;


    @FindBy(css = "[routerlink*='cart']")

    WebElement clickonCart;


    @FindBy(css = ".ng-animating")

    WebElement spinner;


    By productsBy = By.cssSelector(".col-lg-4");

    By products1 = By.cssSelector("b");

    By addToCart = By.cssSelector(".card-body button:last-of-type");


    By toast = By.cssSelector("#toast-container");


    By products3 = By.cssSelector(".col-lg-4");


    By sd = By.cssSelector("[routerlink*='cart']");


    @FindBy(css = "[routerlink*='cart']")

    WebElement cartHeader;


    public List<WebElement> getProductList() {


        waitForElementToAppear(productsBy);


        return products;


    }


    public WebElement getProductByName(String productName) {


        // waitForElementToAppear(products3);


        WebElement prod = getProductList().stream().filter(s ->

                s.findElement(products1).getText().contains(productName)).findFirst().orElse(null);

        return prod;


    }


    public void ClickonAddtoCart(String productName) throws InterruptedException {

        WebElement prod = getProductByName(productName);

        WebElement prod1 = prod.findElement(addToCart);

        Actions actions = new Actions(driver);

        actions.moveToElement(prod1).click().build().perform();

        waitForElementToAppear(toast);

        waitForElementTodisappear(spinner);

        // WebElement cart = getProductByName(productName).findElement(addToCart);

        //cart.click();


    }



   /* public CartPage clickOnCart() {

       // waitForElementToAppear(sd);

        //waitForElementTodisappear(ele);

      Actions actions = new Actions(driver);

      actions.moveToElement(clickonCart).click().build().perform();

      //  clickonCart.click();

        CartPage cartPage = new CartPage(driver);

        return cartPage;





    }



*/

/*

    public CartPage goToCartPage() throws InterruptedException {

        waitForElementToAppear(toast);

        waitForElementTodisappear(ele);

        //cartHeader.click();

        Actions actions = new Actions(driver);

        actions.moveToElement(cartHeader).click().build().perform();

        CartPage cartPage = new CartPage(driver);

        return cartPage;



    }



 */


}



