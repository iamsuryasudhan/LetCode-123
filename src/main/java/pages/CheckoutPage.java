package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //  Click checkout 
    public boolean clickCheckoutIfPresent() {

        List<WebElement> buttons = driver.findElements(
            By.xpath("//button[contains(.,'Checkout')] | //a[contains(.,'Checkout')]")
        );

        if (buttons.size() > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(buttons.get(0)));
            buttons.get(0).click();
            return true;
        } else {
            System.out.println("Checkout button not available");
            return false;
        }
    }

    //  Validate checkout page
    public boolean isCheckoutPageDisplayed() {

        try {
            wait.until(ExpectedConditions.urlContains("checkout"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}