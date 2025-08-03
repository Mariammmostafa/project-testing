
import Pages.HomePage;
import Pages.SignUpPage;
import Utelities.DriverManger;
import Utelities.Global;

import Utelities.TestDataProvider;
import org.openqa.selenium.*;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.testng.annotations.*;

import java.time.Duration;




public class SignUp {

    WebDriverWait wait;
    HomePage homePage;
    SignUpPage signUpPage;
    Global global;
    WebDriverWait webDriverWait;

    @BeforeMethod
    public void setup() {
        homePage = new HomePage();
        signUpPage = new SignUpPage();
        global = new Global();

        WebDriver driver = DriverManger.getDriver();




        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // close الاعلان
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fc-dialog-overlay")));
        } catch (Exception e) {
            System.out.println("الإعلان لم يظهر أو اختفى بسرعة.");
        }
    }
    @Test(dataProvider = "userData", dataProviderClass = TestDataProvider.class)

    public void signUp(
            String name,
            String email,
            String password,
            String day,
            String month,
            String year,
            String firstName,
            String lastName,
            String address,
            String country,
            String state,
            String city,
            String zipcode,
            String mobile
    ) {


        homePage.clickOnsignup_LoginBtn();
        signUpPage.enterName(name).
                enterEmail(email).


                clickSignupButton().
                enterPassword(password).
                entertitle("Mrs").

                daysSelect(day).
                monthSelect(month).
                yearsSelect(year).
                checkNewsletter().
                clickSpecialoffer().
                enterFirstName(firstName).
                enterLastName(lastName).
                enterAddress(address).
                selectCountry(country).
                enterState(state).
                enterCity(city).
                enterZipcode(zipcode).
                enterMobileNumber(mobile).
                clickCreateAccountButton();

//@Test
//public void signIn (){
        //  homePage.clickOnsignup_LoginBtn();
        //  signInPage.enterEmail("mm@gmail.com");
        // signInPage.enterPassword("12345");
//  signInPage.clickLoginBtn();

//Hard assertion.
        // String ActualURL = driver.getCurrentUrl();
        //   String ExpectedURL = "https://www.automationexercise.com/account_created";
        //   Assert.assertEquals(ActualURL, ExpectedURL, "Account not created !!");

        //Soft assertion.

        //   String ActualMessage = driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
        //  String ExpectedMessage = "Account Created!";
        //  SoftAssert softAssert = new SoftAssert();
        //   softAssert.assertEquals(ActualMessage, ExpectedMessage, "Account not created !!");


        // driver.findElement(By.linkText("Signup / Login")).click();

        //  driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("mar");
        //  driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("mm@gmail.com");
        //  driver.findElement(By.xpath("//button[text()='Signup']")).click();

        // driver.findElement(By.id("id_gender1")).click();
        // driver.findElement(By.xpath("//input[@data-qa='password']")).sendKeys("12345");

        //  new Select(driver.findElement(By.id("days"))).selectByIndex(0);
        //   new Select(driver.findElement(By.id("country"))).selectByValue("United States");

        //  driver.findElement(By.name("newsletter")).click();
        //  driver.findElement(By.name("optin")).click();


        // driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("Mariam");
        //  driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("Moustafa");
        //  driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("Atos");
        // driver.findElement(By.id("address1")).sendKeys("faisal");
        // driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Cairo");
        //  driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("co");
        //  driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("12345");
        //  driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("01154789536");
        //  WebElement createButton = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", createButton);

//Hard assertion.
        //  String ActualURL = driver.getCurrentUrl();
        //  String ExpectedURL = "https://www.automationexercise.com/account_created";
        //  Assert.assertEquals(ActualURL, ExpectedURL, "Account not created !!");

        //Soft assertion.

        //  String ActualMessage = driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
        //  String ExpectedMessage = "Account Created!";
        //  SoftAssert softAssert = new SoftAssert();
        //  softAssert.assertEquals(ActualMessage, ExpectedMessage, "Account not created !!");


        //Implicit wait
        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Explicit

        //  WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        // WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampledId")));


        //  driver.quit();
        // }
        // @AfterMethod

        //  public void tearDown() {
        // driver.quit();
        // }


    }
}