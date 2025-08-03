package Pages;

import Utelities.DriverManger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.security.auth.Subject;
import java.time.Duration;


public class ContactUsPage {

    WebDriver driver = DriverManger.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    By Name = By.name("name");
    By Email = By.name("email");

    By Subject = By.name("subject");
    By Message = By.name("message");
    By File = By.name("upload_fil");
    By SubmitClick = By.name("submit");









    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(name);

    }
    public void enterEmail(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).sendKeys(name);

    }
    public void enterSubject(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Subject)).sendKeys(name);

    }


    public void enterMessage(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Message)).sendKeys(name);

    }
    public void enterUploadfile(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(File)).sendKeys(name);

    }
    public void enterSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement viewCartBtn = wait.until(ExpectedConditions.elementToBeClickable(SubmitClick));

        try {
            viewCartBtn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCartBtn);
        }
    }
}