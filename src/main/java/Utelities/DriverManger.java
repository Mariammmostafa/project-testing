package Utelities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class DriverManger {

    public static WebDriver driver;
    static Wait<WebDriver> wait;

    static String BroswerName= LoadProperties.Browser;
    static String URL = LoadProperties.URL;

    public static void initiation() {
        if (BroswerName.trim().equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (BroswerName.trim().equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (BroswerName.trim().equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            System.out.println("Browser not correct: " + BroswerName);
            return;
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().deleteAllCookies();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initiation();
        }
        return driver;
    }

    public static void closeDriver() {

         driver.quit();
        }
    }

