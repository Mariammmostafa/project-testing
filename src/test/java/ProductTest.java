import Pages.HomePage;
import Pages.ProductPage;
import Utelities.DriverManger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static Utelities.DriverManger.driver;

public class ProductTest extends BaseTest {

    WebDriver driver;  // لازم يكون هنا عشان تستخدمه في كل الدوال
    HomePage homePage;
    ProductPage productPage;

    @BeforeMethod
    public void setup() {
        driver = DriverManger.getDriver();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        homePage.clickOnProductsLink();
    }

    @Test(groups = "product", dependsOnGroups = "login")
    public void testSearchAndValidateProductDetails() throws InterruptedException {

        productPage.searchForProduct("T-shirt");

        int productCount = productPage.getNumberOfProducts();
        Assert.assertTrue(productCount > 0, "No products found for 'T-shirt'!");

        productPage.openFirstProductFromSearchAndAddToCart();

        // انتظر ظهور العنصر في صفحة المنتج قبل قراءة بياناته
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-information h2")));


        // بعد ما تأكدنا الصفحة جاهزة، نجيب بيانات المنتج
        String name = productPage.getProductName();
        String category = productPage.getProductCategory();
        String price = productPage.getProductPrice();
        String description = productPage.getProductDescription();

        Assert.assertTrue(name.toLowerCase().contains("t-shirt"), "Product name doesn't contain 'T-shirt'");
        Assert.assertFalse(category.isEmpty(), "Category is empty!");
        Assert.assertFalse(price.isEmpty(), "Price is empty!");
        Assert.assertFalse(description.isEmpty(), "Description is empty!");

        System.out.println("Product Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Price: " + price);
        System.out.println("Description: " + description);
        productPage.clickViewCart();

    }
}
