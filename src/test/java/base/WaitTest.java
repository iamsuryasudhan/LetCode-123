package base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import pages.WaitPage;
import utils.ExcelUtils;

public class WaitTest extends BaseTest {

    @Test
    public void waitTest() throws Exception {

        driver.get("https://letcode.in/waits");

        WaitPage page = new WaitPage(driver);

        // Read expected alert text from Excel
        String expected = ExcelUtils.getCellData("WaitTest", 1, 0);

        page.clickSimpleAlert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String actual = alert.getText();

        if (actual.equals(expected)) {
        	if (actual.equals(expected)) {
        	    ExcelUtils.setCellData("WaitTest", 1, 1, "PASS");
        	} else {
        	    ExcelUtils.setCellData("WaitTest", 1, 1, "FAIL");
        	}

        	Assert.assertEquals(actual, expected);

        Assert.assertEquals(actual, expected);

        alert.accept();
    }
}
}