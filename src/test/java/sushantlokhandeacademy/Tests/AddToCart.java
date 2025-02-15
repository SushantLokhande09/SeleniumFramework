package sushantlokhandeacademy.Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LandingPage;
import sushantlokhandeacademy.TestComponents.BaseTest;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class AddToCart extends BaseTest {

    WebDriver driver = new ChromeDriver();


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    Actions actions = new Actions(driver);

    @Test
    public void navigatingBrowser() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client");

        LandingPage landingPage = new LandingPage(driver);

        driver.findElement(By.id("userEmail")).sendKeys("sushantlokhande@gmail.com");

        driver.findElement(By.id("userPassword")).sendKeys("Window@22");

        driver.findElement(By.id("login")).click();

        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector(".col-lg-4"))));

        List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));

        //IPHONE 13 PRO


        WebElement prod = products.stream().filter(s ->
                s.findElement(By.cssSelector("b")).getText().contains("IPHONE 13 PRO")).findFirst().orElse(null);

//.card-body button[class='btn w-10 rounded']


        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        List<WebElement> itemsInCart = driver.findElements(By.cssSelector(".cartWrap h3"));

        Boolean match = itemsInCart.stream().anyMatch(items -> items.getText().equalsIgnoreCase("IPHONE 13 PRO"));

        Assert.assertTrue(match);

        // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".totalRow [class='btn btn-primary']")));


        WebElement element = driver.findElement(By.cssSelector(".totalRow [class='btn btn-primary']"));
        actions.moveToElement(element).click().perform();

        //  driver.findElement(By.cssSelector(".totalRow [class='btn btn-primary']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder*='Country']")));

        driver.findElement(By.cssSelector("[placeholder*='Country']")).sendKeys("ind");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item.list-group-item.ng-star-inserted")));


        List<WebElement> countries = driver.findElements(By.cssSelector(".ta-item.list-group-item.ng-star-inserted"));


        WebElement cou = countries.stream().filter(s -> s.findElement(By.cssSelector("span")).getText().equals("India")).findFirst().orElse(null);

        actions.moveToElement(cou).click().build().perform();

        // cou.click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/a[text()='Place Order ']")));
        WebElement placeordre=driver.findElement(By.cssSelector(".action__submit"));

        actions.moveToElement(placeordre).click().build().perform();

        String s = driver.findElement(By.tagName("h1")).getText();
        Assert.assertTrue(s.equals("THANKYOU FOR THE ORDER."));
        //System.out.println(s);

        driver.quit();

    }
}









