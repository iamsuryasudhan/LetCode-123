package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitPage {

    WebDriver driver;
    WebDriverWait wait;

    public WaitPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Wait until the button becomes clickable
    public void clickSimpleAlert() {
        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Simple Alert')]")));

        btn.click();
    }

    // Wait until success message appears
    public String getSuccessMessage() {
        WebElement msg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className("title")));

        return msg.getText();
    }
}