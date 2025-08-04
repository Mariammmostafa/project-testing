package Pages;

import Utelities.DriverManger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class CheckOutPage {

  WebDriver driver = DriverManger.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));






    By checkoutButton = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    public void clickOnCheckoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Proceed To Checkout')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutButton);
    }

    }
