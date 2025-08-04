import Pages.HomePage;
import Pages.SignInPage;

import Utelities.CVSReader;
import Utelities.DriverManger;
import Utelities.Global;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class Signin extends BaseTest {
    SignInPage signInPage;
    HomePage homePage;
    WebDriverWait wait;
    Global global;
    CVSReader cvsReader;

    @BeforeTest
    public void setup() {
        WebDriver driver = DriverManger.getDriver();
        homePage = new HomePage(driver);
        signInPage = new SignInPage();
        cvsReader = new CVSReader();

        global = Global.getInstance();


        global.setEmail();
        global.setPassword();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fc-dialog-overlay")));
        } catch (Exception e) {
            System.out.println("الإعلان لم يظهر أو اختفى بسرعة.");
        }
    }


    @Test(groups = "login")



    public void signIn() {
        homePage.clickOnsignup_LoginBtn();
        signInPage.enterEmail(cvsReader.getUser().getEmail());
        signInPage.enterPassword(cvsReader.getUser().getPassword());
        signInPage.clickLoginBtn();

    }
}
