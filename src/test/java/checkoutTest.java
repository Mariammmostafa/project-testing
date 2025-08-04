import Pages.*;
import Utelities.CVSReader;
import Utelities.DriverManger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class checkoutTest {

    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    CheckOutPage checkOutPage;
    SignInPage signInPage;
    CVSReader cvsReader;
    ContactUsPage contactUsPage;

    @BeforeMethod
    public void setup() {
        driver = DriverManger.getDriver();
        homePage = new HomePage(driver);
        signInPage = new SignInPage();
        cvsReader = new CVSReader();
        productPage = new ProductPage(driver);
        checkOutPage = new CheckOutPage();
        contactUsPage = new ContactUsPage();

    }


    @Test(groups = "checkout", dependsOnGroups = "product")
    public void testUserCanCheckout() throws InterruptedException {


        //  homePage.clickOnProductsLink();
        //  productPage.closeAdIframeIfPresent();
        //  productPage.searchForProduct("tshirt");
        //  productPage.openFirstProductFromSearchAndAddToCart();
        //  productPage.clickViewCart();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-default check_out']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutBtn);
        checkoutBtn.click();

        checkOutPage.clickOnCheckoutButton();
        //  homePage.ClickOnContactUs();

        //  contactUsPage.enterName("Mariam");
        //  contactUsPage.enterEmail("Mariam@gmail.com");
        //  contactUsPage.enterSubject("Support Needed");
        //  contactUsPage.enterMessage("I have an issue with my recent order.");
        //  contactUsPage.enterSubmit();


        String url = driver.getCurrentUrl();
        assert url.contains("checkout") || url.contains("payment") : "Checkout page not reached.";


    }
}

