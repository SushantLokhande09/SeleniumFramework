package sushantlokhandeacademy.Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sushantlokhandeacademy.TestComponents.BaseTest;

import java.util.List;
import java.util.stream.Collectors;

public class testDemoOne extends BaseTest {


    public void runTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.cssSelector(".sort-icon.sort-descending")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> originalList = elements.stream().map(s -> s.getText()).collect(Collectors.toList());

        //store webelemnts in list
        //sort it
        //compare with existing list

        List<String> sortedList = elements.stream().map(s -> s.getText()).sorted().collect(Collectors.toList());


        System.out.println(originalList.equals(sortedList));
        Assert.assertTrue(originalList.equals(sortedList));

        //tr/td[1]/following-sibling::td[1]
        //find the vegitable called banana

        //now find strawberry


        List<String> StrawberryPrice;// serach strberry


        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            StrawberryPrice = rows.stream().filter(s -> s.getText().contains("Strawberry")).map(s -> getVeggeiePrice(s)).collect(Collectors.toList());
            StrawberryPrice.forEach(s -> System.out.println(s));
            if (StrawberryPrice.size() < 1) {
                driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
            }

        } while (StrawberryPrice.size() < 1);


    }

    private String getVeggeiePrice(WebElement s) {
        String priceStrawberryVeggie = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        // System.out.println(priceStrawberryVeggie);

        return priceStrawberryVeggie;
    }


    public class TestingTwo {
        @Test
        public void demo1() {

            WebDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

            driver.findElement(By.id("search-field")).sendKeys("Rice");

            List<WebElement> vggiees = driver.findElements(By.xpath("//tr/td[1]"));

            List<WebElement> veg = vggiees.stream().filter(s -> s.getText().contains("Rice")).collect(Collectors.toList());


            Assert.assertEquals(vggiees.size(), veg.size());


        }


    }


}

















