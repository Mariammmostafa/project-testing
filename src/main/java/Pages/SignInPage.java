package Pages;


import Utelities.DriverManger;
import Utelities.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SignInPage {
    WebDriver driver;

    By SignIn_EmailAddress = By.xpath("//input[@data-qa='login-email']");
    By SignIn_Password = By.xpath("//input[@data-qa='login-password']");

    By LoginBtn = By.xpath("//button[text()='Login']");

    public SignInPage() {
        this.driver = DriverManger.getDriver();
    }

    public void enterEmail(String Email) {
        ElementHelper.sendText(Email, driver, SignIn_EmailAddress);
    }

    public void enterPassword(String password) {

        ElementHelper.sendText(password, driver, SignIn_Password);
    }

    public void clickLoginBtn() {
        ElementHelper.click(driver, LoginBtn);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(), 'Logout')]")
        ));
    }
}
