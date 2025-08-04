

import Pages.HomePage;
import Utelities.DriverManger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest {

    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        driver = DriverManger.getDriver();
        homePage = new HomePage(driver);    }

    @Test(groups = "logout", dependsOnGroups = {"login", "checkout"})
    public void testUserCanLogout() {
        // كود الاختبار



        homePage.clickLogoutButton();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login") || currentUrl.contains("signup"),
                " لم يتم تسجيل الخروج بنجاح.");
        System.out.println(" تم تسجيل الخروج بنجاح.");
    }
}
