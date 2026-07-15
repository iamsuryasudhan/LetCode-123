package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class ButtonPage {

    WebDriver driver;

    public ButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    By position = By.id("position");
    By color = By.id("color");
    By size = By.id("property");
    By disabled = By.id("isDisabled");

    // Get button position
    public void getPosition() {
        Point point = driver.findElement(position).getLocation();
        System.out.println("X: " + point.getX() + " Y: " + point.getY());
    }

    // Get button color
    public void getColor() {
        String bgColor = driver.findElement(color).getCssValue("background-color");
        System.out.println("Color: " + bgColor);
    }

    // Get button size
    public void getSize() {
        Dimension dim = driver.findElement(size).getSize();
        System.out.println("Height: " + dim.getHeight() + " Width: " + dim.getWidth());
    }

    // Check if button is enabled
    public boolean isButtonEnabled() {
        return driver.findElement(disabled).isEnabled();
    }
}