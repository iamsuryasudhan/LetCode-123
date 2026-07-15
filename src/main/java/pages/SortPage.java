 package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SortPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public SortPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    public List<WebElement> getItems() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@draggable='true']")));

        return driver.findElements(By.xpath("//div[@draggable='true']"));
    }
   

    // Print items before/after sorting
    public void printItems() {
        List<WebElement> items = getItems();

        for (WebElement item : items) {
            System.out.println(item.getText());
        }

        System.out.println("----------------------");
    }

    // Drag first item to last position
    public void sortItems() {

        List<WebElement> items = getItems();

        WebElement first = items.get(0);
        WebElement last = items.get(items.size() - 1);

        actions.dragAndDrop(first, last).perform();
    }
}