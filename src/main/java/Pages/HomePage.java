package Pages;

import Utelities.DriverManger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    By signup_Login = By.linkText("Signup / Login");
    By Product_page = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
    By Contact_UsBtn = By.xpath("//a[@href='/contact_us']");

   By Logout = By.xpath("//a[contains(text(),'Logout')]");



    public HomePage(WebDriver driver) {
        this.driver = DriverManger.getDriver();
    }

    public void clickOnsignup_LoginBtn() {
        driver.findElement(signup_Login).click();
    }

    public void ClickOnContactUs() {
        driver.findElement(Contact_UsBtn).click();
    }

    public void clickOnProductsLink() {
        driver.findElement(Product_page).click();

    }
        public void clickLogoutButton() {
            WebElement logoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
            logoutBtn.click();
        }

    }

