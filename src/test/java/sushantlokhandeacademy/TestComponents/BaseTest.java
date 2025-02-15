package sushantlokhandeacademy.TestComponents;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
public class BaseTest {


    public LandingPage landingPage;
    public WebDriver driver;

    public WebDriver InitializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fil = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\sushantlokhandeacademy\\resources\\GlobalData.properties");

        prop.load(fil);
        String browserName = prop.getProperty("browser");


        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();


        } else if (browserName.equalsIgnoreCase("fireFox")) {

            //firefox

        } else if (browserName.equalsIgnoreCase("edge")) {

            //edge

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        return driver;


    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;

        File source =ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
    }




    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {
        driver = InitializeDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}



