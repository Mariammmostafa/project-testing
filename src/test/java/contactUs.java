import Pages.ContactUsPage;
import Pages.HomePage;

import Utelities.DriverManger;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;

import static Utelities.DriverManger.driver;



public class contactUs {

    HomePage homePage;


    @BeforeMethod
    public void setup() {
        driver = DriverManger.getDriver();
        homePage = new HomePage(driver);
    }
    @Test(dependsOnMethods = {"testUserCanCheckout"})



    void testClickContactUs() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        homePage.ClickOnContactUs();
        Assert.assertTrue(driver.getCurrentUrl().contains("contact_us"));

        ContactUsPage contact = new ContactUsPage();

        contact.enterName("Mariam");
        contact.enterEmail("Mariam@gmail.com");
        contact.enterSubject("..");
        contact.enterMessage("..");
        contact.enterSubmit();

    }
}