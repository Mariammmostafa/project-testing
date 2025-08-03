package Pages;

import Utelities.DriverManger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {

    WebDriver driver = DriverManger.getDriver();

    // Elements
    By searchField = By.id("search_product");
    By searchButton = By.id("submit_search");
    By productItems = By.cssSelector(".features_items .product-image-wrapper");
    By firstProductViewBtn = By.cssSelector(".features_items .product-image-wrapper a[href*='product_details']");

    // Product details
    By productName = By.cssSelector(".product-information h2");
    By productCategory = By.xpath("//div[@class='product-information']//p[contains(text(),'Category')]");
    By productPrice = By.cssSelector(".product-information span span");
    By productDescription = By.cssSelector(".product-information p:not([style])");

    By quantityInput = By.xpath("//input[@id='quantity']");


    By addToCartButton = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");


    By successMessage = By.cssSelector(".alert-success");
    By CartView = By.cssSelector("a[href='/view_cart']");


    public void setQuantity(int qty) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement qtyElement = wait.until(ExpectedConditions.elementToBeClickable(quantityInput));
        qtyElement.clear();
        qtyElement.sendKeys(String.valueOf(qty));


    }


    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public Object waitForSuccessMessageAndGetText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return message.getText();
        } catch (Exception e) {
            return null;
        }
    }

    public String getSuccessMessageText() {
        return driver.findElement(successMessage).getText();
    }

    // Actions
    public void searchForProduct(String keyword) {
        driver.findElement(searchField).sendKeys(keyword);
        driver.findElement(searchButton).click();
    }

    public int getNumberOfProducts() {
        return driver.findElements(productItems).size();
    }

    public void closeAdIframeIfPresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            // الانتقال لإطار الإعلان
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("aswift_1")));

            // البحث عن زر الإغلاق (غير السلكتور حسب الصفحة)
            WebElement closeBtn = driver.findElement(By.cssSelector("button.close"));

            closeBtn.click();

            // العودة للصفحة الرئيسية
            driver.switchTo().defaultContent();

            System.out.println("Ad iframe closed successfully.");
        } catch (TimeoutException | NoSuchElementException e) {
            // في حالة عدم وجود iframe أو زر الإغلاق
            driver.switchTo().defaultContent();
            System.out.println("No ad iframe or close button found.");
        }
    }
    public void openFirstProductFromSearchAndAddToCart() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement element = driver.findElement(firstProductViewBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500); // تأخير بسيط بعد التمرير
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        wait.until(ExpectedConditions.visibilityOfElementLocated(productName));

        int quantity = 5;
        WebElement qtyElement = wait.until(ExpectedConditions.elementToBeClickable(quantityInput));
        qtyElement.clear();
        qtyElement.sendKeys(String.valueOf(quantity));

        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addButton.click();

        // انتظار ظهور المودال (مثلاً)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartModal")));

        // انتظار ظهور رسالة النجاح داخل المودال
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
    }


    public int CartBadge() {
        try {
            String badgeText = driver.findElement(By.cssSelector("a[href='/view_cart'] .badge")).getText();
            return Integer.parseInt(badgeText.trim());
        } catch (NoSuchElementException e) {
            return 0; // لو
        }
    }

    public String getProductName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        return productNameElement.getText();
    }

    public String getProductCategory() {
        return driver.findElement(productCategory).getText();
    }

    public String getProductPrice() {
        return driver.findElement(productPrice).getText();
    }

    public String getProductDescription() {
        return driver.findElement(productDescription).getText();
    }

    public void clickViewCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement viewCartBtn = wait.until(ExpectedConditions.elementToBeClickable(CartView));

        try {
            viewCartBtn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCartBtn);
        }
    }

}
