package pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowPage {

    WebDriver driver;
    WebDriverWait wait;

    public WindowPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By homeBtn = By.id("home");

    public void clickHome() {
        driver.findElement(homeBtn).click();
    }

    public void switchToChildWindow() {

        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(windows.get(1));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void closeChildWindow() {
        driver.close();
    }

    public void switchToParentWindow() {

        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(windows.get(0));
    }
}