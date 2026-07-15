package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage {

    WebDriver driver;

    public FramePage(WebDriver driver) {
        this.driver = driver;
    }

    // Enter First Name & Last Name
    public void enterUserDetails(String firstName, String lastName) {

        driver.switchTo().frame("firstFr");

        driver.findElement(By.name("fname")).sendKeys(firstName);
        driver.findElement(By.name("lname")).sendKeys(lastName);

        driver.switchTo().defaultContent();
    }

    // Enter Email in Nested Frame
    public void enterEmailInNestedFrame(String email) {

        // Switch to outer frame
        driver.switchTo().frame("firstFr");

        // Switch to inner frame (index used instead of wrong id)
        driver.switchTo().frame(0);

        driver.findElement(By.name("email")).sendKeys(email);

        driver.switchTo().defaultContent();
    }


	}
