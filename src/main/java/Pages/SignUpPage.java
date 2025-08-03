
package Pages;

import Utelities.DriverManger;
import Utelities.ElementHelper;
import Utelities.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {

    WebDriver driver;


    // Locators باستخدام XPath
    By signupName = By.xpath("//input[@data-qa='signup-name']");
    By signupEmail = By.xpath("//input[@data-qa='signup-email']");
    By signupButton = By.xpath("//button[text()='Signup']");
    By signUptitle = By.xpath("//input[@id='id_gender1']");
    By genderRadio = By.xpath("//input[@id='id_gender1']");
    By password = By.xpath("//input[@data-qa='password']");

    By daysSelect = By.xpath("//select[@id='days']");
    By monthSelect = By.xpath("//select[@id='months']");
    By yearsSelect = By.xpath("//select[@id='years']");
    By countrySelect = By.xpath("//select[@id='country']");

    By newsletter = By.xpath("//input[@id='newsletter']");
    By specialoffer = By.xpath("//input[@id='optin']");

    By firstName = By.xpath("//input[@data-qa='first_name']");
    By lastName = By.xpath("//input[@data-qa='last_name']");
    By company = By.xpath("//input[@data-qa='company']");
    By address = By.xpath("//input[@id='address1']");
    By state = By.xpath("//input[@data-qa='state']");
    By city = By.xpath("//input[@id='city']");
    By zipcode = By.xpath("//input[@data-qa='zipcode']");
    By mobileNumber = By.xpath("//input[@id='mobile_number']");

    By createAccountButton = By.xpath("//button[@data-qa='create-account']");
    By accountMessage = By.xpath("//h2[@data-qa='account-created']");

    public SignUpPage() {
        this.driver = DriverManger.getDriver();
    }

    public SignUpPage enterName(String name) {
        ElementHelper.sendText(name, driver, signupName);
        return this;
    }

    public SignUpPage enterEmail(String email) {
        Global global = new Global();
        global.setEmail();
        driver.findElement(signupEmail).sendKeys(email);
        return this;
    }

    public SignUpPage entertitle(String mr) {
        WebElement radio = driver.findElement(signUptitle); // ده لازم يكون نوعه radio
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radio);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radio);
        return this;
    }

    public SignUpPage clickSignupButton() {
        driver.findElement(signupButton).click();
        return this;
    }

    public SignUpPage selectGender() {
        driver.findElement(genderRadio).click();
        return this;
    }

    public SignUpPage enterPassword(String pass) {
        ElementHelper.sendText(pass, driver, password);
        return this;
    }

    public SignUpPage daysSelect(String dayValue) {
        Select select = new Select(driver.findElement(daysSelect));
        select.selectByValue(dayValue);
        return this;
    }

    public SignUpPage monthSelect(String monthValue) {
        Select select = new Select(driver.findElement(monthSelect));
        select.selectByVisibleText(monthValue);
        return this;
    }

    public SignUpPage yearsSelect(String yearValue) {
        Select select = new Select(driver.findElement(yearsSelect));
        select.selectByValue(yearValue);
        return this;
    }

    public SignUpPage selectCountry(String country) {
        new Select(driver.findElement(countrySelect)).selectByVisibleText(country);
        return this;
    }

    public SignUpPage checkNewsletter() {
        WebElement checkbox = driver.findElement(By.xpath("//input[@id='newsletter']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        return this;
    }

    public SignUpPage clickSpecialoffer() {
        driver.findElement(specialoffer).click();
        return this;
    }

    public SignUpPage enterFirstName(String fName) {
        ElementHelper.sendText(fName, driver, firstName);
        return this;
    }

    public SignUpPage enterLastName(String lName) {
        ElementHelper.sendText(lName, driver, lastName);
        return this;
    }

    public SignUpPage enterCompany(String comp) {
        ElementHelper.sendText(comp, driver, company);
        return this;
    }

    public SignUpPage enterAddress(String addr) {
        ElementHelper.sendText(addr, driver, address);
        return this;
    }

    public SignUpPage enterState(String st) {
        ElementHelper.sendText(st, driver, state);
        return this;
    }

    public SignUpPage enterCity(String c) {
        ElementHelper.sendText(c, driver, city);
        return this;
    }

    public SignUpPage enterZipcode(String zip) {
        ElementHelper.sendText(zip, driver, zipcode);
        return this;
    }

    public SignUpPage enterMobileNumber(String mobile) {
        ElementHelper.sendText(mobile, driver, mobileNumber);
        return this;
    }

    public SignUpPage clickCreateAccountButton() {
        WebElement createBtn = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", createBtn);

        return this;
    }
}