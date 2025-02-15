package sushantlokhandeacademy.Tests;

import org.testng.annotations.Test;
import sushantlokhandeacademy.TestComponents.BaseTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class dffdfdfd extends BaseTest {

@Test
    public void testingOne() {

        driver.get("https://www.google.co.in/");

        Set<String> window = driver.getWindowHandles();

        Iterator<String> windows =window.iterator();
        if (windows.hasNext()){

            windows.next();

        }
        System.out.println((driver.getTitle()));



}




}
