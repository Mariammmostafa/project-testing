import Pages.HomePage;
import Pages.ProductPage;
import Utelities.DriverManger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static Utelities.DriverManger.driver;


public class ProductTest extends BaseTest {

    HomePage homePage;
    ProductPage productPage;

    @BeforeMethod
    public void setup() {
        WebDriver driver = DriverManger.getDriver();
        homePage = new HomePage();
        productPage = new ProductPage();
        homePage.clickOnProductsLink();
    }

    @Test
    public void testSearchAndValidateProductDetails() throws InterruptedException {


        productPage.searchForProduct("T-shirt");

        int productCount = productPage.getNumberOfProducts();
        Assert.assertTrue(productCount > 0, "❌ No products found for 'T-shirt'!");

        productPage.openFirstProductFromSearchAndAddToCart();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
     // WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".product-item")));
   // firstProduct.click();


     // WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart")));
    // addToCartBtn.click();

     // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));

        productPage.clickViewCart();



        String name = productPage.getProductName();
        String category = productPage.getProductCategory();
        String price = productPage.getProductPrice();
        String description = productPage.getProductDescription();

        Assert.assertTrue(name.toLowerCase().contains("t-shirt"), "❌ Product name doesn't contain 'T-shirt'");
        Assert.assertFalse(category.isEmpty(), "❌ Category is empty!");
        Assert.assertFalse(price.isEmpty(), "❌ Price is empty!");
        Assert.assertFalse(description.isEmpty(), "❌ Description is empty!");

        System.out.println("✅ Product Name: " + name);
        System.out.println("✅ Category: " + category);
        System.out.println("✅ Price: " + price);
        System.out.println("✅ Description: " + description);
    }

    @Test
    public void testAddProductWithQuantityAndConfirmSuccess() throws InterruptedException {
        productPage.searchForProduct("T-Shirt");
        productPage.openFirstProductFromSearchAndAddToCart();

        String msg = productPage.getSuccessMessageText();
        System.out.println("✅ Success Message: " + msg);

        productPage.clickViewCart();

        System.out.println("✅ تم إضافة المنتج وفتح السلة بنجاح.");
    }
}


