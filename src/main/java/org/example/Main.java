package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();

        WebElement Signup_Login = driver.findElement(By.linkText("Signup / Login"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fc-dialog-overlay")));
        Signup_Login.click();

        WebElement Signup_EmailAddress = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        Signup_EmailAddress.sendKeys("Mariam6@gmail.com");


        WebElement Signup_Name = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        Signup_Name.sendKeys("Mariam");

        WebElement Signup_button = driver.findElement(By.xpath("//button[text()='Signup']"));
        Signup_button.click();

//**************************************************************************************************************
        WebElement radioButon = driver.findElement(By.id("id_gender1"));
        radioButon.click();
        WebElement Password = driver.findElement(By.xpath("//input[@data-qa='password']"));
   Password.sendKeys("123349");


   Select DaysDropDown = new Select(driver.findElement(By.id("days")));
   DaysDropDown.selectByIndex(0);

        Select country = new Select(driver.findElement(By.id("country")));country.selectByValue("United States");
        country.selectByIndex(0);



        WebElement newsLetter = driver.findElement(By.xpath("//input[@name='newsletter']"));
       newsLetter.click();


        WebElement specialoffer = driver.findElement(By.xpath("//input[@name='optin']"));
        specialoffer.click();



        WebElement SignUp_Firstname = driver.findElement(By.xpath("//input[@data-qa='first_name']"));
        SignUp_Firstname.sendKeys("Mariam");


        WebElement SignUp_Lastname = driver.findElement(By.xpath("//input[@data-qa='last_name']"));
        SignUp_Lastname.sendKeys("Moustafa");


        WebElement SignUp_company = driver.findElement(By.xpath("//input[@data-qa='company']"));
        SignUp_company.sendKeys("Atos");


        WebElement Signup_address = driver.findElement(By.id("address1"));
        Signup_address.sendKeys("faisal");



        Select country1 = new Select(driver.findElement(By.id("country")));
        country.selectByValue("United States");


        WebElement SignUp_State= driver.findElement(By.xpath("//input[@data-qa='state']"));
        SignUp_State.sendKeys("Cairo");


        WebElement SignUp_city = driver.findElement(By.xpath("//input[@data-qa='city']"));
  SignUp_city.sendKeys("co");





        WebElement mobile = driver.findElement(By.xpath("//input[@data-qa='mobile_number']"));
        mobile.sendKeys("01154789536");

        WebElement SignUp_zipcode = driver.findElement(By.xpath("//input[@data-qa='zipcode']"));
        SignUp_zipcode.sendKeys("12345");




        WebElement SignUp_Create= driver.findElement(By.xpath("//button[text()='Create Account']"));
        SignUp_Create.click();





// دلوقتي استنى زر المنتجات يكون قابل للضغط واضغط عليه
        WebElement productsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/products']")));
        productsBtn.click();

// تأكد ظهور أول منتج
        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-image-wrapper")));
        System.out.println("✅ المنتجات ظهرت بنجاح");

  String ActualURL= driver.getCurrentUrl();
  String ExpectedURL = "https://www.automationexercise.com/account_created";


        //   driver.quit();

    }
    }