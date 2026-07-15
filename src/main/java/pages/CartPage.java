package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //  check URL 
    public boolean isCartPageDisplayed() {

        try {
            wait.until(ExpectedConditions.urlContains("cart"));
            return driver.getCurrentUrl().contains("cart");

        } catch (Exception e) {
            return false;
        }
    }
}