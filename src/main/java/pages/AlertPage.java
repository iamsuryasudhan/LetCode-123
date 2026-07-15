  package pages;

import org.openqa.selenium.*;

public class AlertPage {

    WebDriver driver;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    public void handlePromptAlert(String text) {

        // Click prompt alert button
        driver.findElement(By.id("prompt")).click();

        // Switch to alert
        Alert alert = driver.switchTo().alert();

        // Send text
        alert.sendKeys(text);

        // Accept
        alert.accept();
    }
}
