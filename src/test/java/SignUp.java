
import Pages.HomePage;
import Pages.SignUpPage;
import Utelities.CVSReader;
import Utelities.DriverManger;
import Utelities.Global;


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
    CVSReader cvsReader;

    @BeforeMethod
    public void setup() {
        homePage = new HomePage(
                DriverManger.getDriver()
        );
        signUpPage = new SignUpPage();
//        global = new Global();
        cvsReader = new CVSReader();

        WebDriver driver = DriverManger.getDriver();


        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // close الاعلان
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fc-dialog-overlay")));
        } catch (Exception e) {
            System.out.println("الإعلان لم يظهر أو اختفى بسرعة.");
        }
    }

    @Test()

    public void signUp(
    ) {


        homePage.clickOnsignup_LoginBtn();
        signUpPage.enterName(cvsReader.getUser().getName()).
                enterEmail(cvsReader.getUser().getEmail()).
                clickSignupButton().
                enterPassword(cvsReader.getUser().getPassword()).
                entertitle("Mrs").
                daysSelect(cvsReader.getUser().getDay()).
                monthSelect(cvsReader.getUser().getMonth()).
                yearsSelect(cvsReader.getUser().getYear()).
                checkNewsletter().
                clickSpecialoffer().
                enterFirstName(cvsReader.getUser().getFirstName()).
                enterLastName(cvsReader.getUser().getLastName()).
                enterAddress(cvsReader.getUser().getAddress()).
                selectCountry(cvsReader.getUser().getCountry()).
                enterState(cvsReader.getUser().getState()).
                enterCity(cvsReader.getUser().getCity()).
                enterZipcode(cvsReader.getUser().getZipcode()).
                enterMobileNumber(cvsReader.getUser().getMobileNumber()).
                clickCreateAccountButton();



    }
}