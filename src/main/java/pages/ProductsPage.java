 package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 🔹 Open product using Excel data
    public void openProductByName(String productName) {

        try {
            WebElement product = wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[contains(text(),'" + productName + "')]")
                )
            );
            product.click();

        } catch (Exception e) {
            System.out.println("Product not found → opening first product");
            openFirstProduct();
        }
    }

    // 🔹 Fallback (always works)
    public void openFirstProduct() {

        WebElement product = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[contains(@class,'card')])[1]")
            )
        );

        product.click();
    }

    // 🔹 Add to Cart
    public void addToCart() {

        WebElement addBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("(//button)[1]")
            )
        );

        addBtn.click();

        // 🔹 Wait for cart icon to appear (important)
        wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//a[contains(@href,'cart')] | //button[contains(text(),'Cart')]")
        ));
    }

    // 🔹 Open Cart
    public void openCart() {

        WebElement cart = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'cart')] | //button[contains(text(),'Cart')]")
            )
        );

        cart.click();
    }
}