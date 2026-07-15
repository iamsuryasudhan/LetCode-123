package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {

    WebDriver driver;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    // Select Fruit
    public void selectFruit(String fruit) {
        Select select = new Select(driver.findElement(By.id("fruits")));
        select.selectByVisibleText(fruit);
    }

    // Multi-select Heroes
    public void selectHeroes(String hero1, String hero2) {
        Select select = new Select(driver.findElement(By.id("superheros")));
        select.selectByVisibleText(hero1);
        select.selectByVisibleText(hero2);
    }

    // Select last programming language
    public void selectLastLanguage() {
        Select select = new Select(driver.findElement(By.id("lang")));
        List<WebElement> options = select.getOptions();
        select.selectByIndex(options.size() - 1);
    }

    // Print all programming languages
    public void printAllLanguages() {
        Select select = new Select(driver.findElement(By.id("lang")));
        List<WebElement> options = select.getOptions();

        for (WebElement opt : options) {
            System.out.println(opt.getText());
        }
    }

    // Select Country
    public void selectCountry(String country) {
        Select select = new Select(driver.findElement(By.id("country")));
        select.selectByVisibleText(country);
    }

    // Print Selected Country
    public void printSelectedCountry() {
        Select select = new Select(driver.findElement(By.id("country")));
        System.out.println("Selected Country: " +
                select.getFirstSelectedOption().getText());
    }
}