package base;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ButtonPage;
import utils.ExcelUtils;

public class ButtonTest extends BaseTest {

    ButtonPage buttonPage;

    @Test
    public void buttonTest() throws Exception {

        driver.navigate().to("https://letcode.in/button");

        buttonPage = new ButtonPage(driver);

        // Perform actions
        buttonPage.getPosition();
        buttonPage.getColor();
        buttonPage.getSize();

        // Write click/action result
        ExcelUtils.setCellData("ButtonTest", 1, 2, "Passed");

        // Check enabled status
        boolean enabled = buttonPage.isButtonEnabled();

        // Assertion (expected: button should be disabled)
        Assert.assertFalse(enabled);

        // Write result to Excel
        if (!enabled) {
            ExcelUtils.setCellData("ButtonTest", 2, 2, "Passed");
        } else {
            ExcelUtils.setCellData("ButtonTest", 2, 2, "Failed");
        }
    }
}