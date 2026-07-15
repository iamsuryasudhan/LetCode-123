package base;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.WindowPage;
import utils.ExcelUtils;

public class WindowTest extends BaseTest {

    @Test
    public void windowTest() throws Exception {

        driver.get("https://letcode.in/window");

        WindowPage page = new WindowPage(driver);

        String button = ExcelUtils.getCellData("WindowTest", 1, 0);
        String expectedTitle = ExcelUtils.getCellData("WindowTest", 1, 1);

        if (button.equalsIgnoreCase("Home")) {
            page.clickHome();
        }

        page.switchToChildWindow();

        String actualTitle = page.getPageTitle();

        if (actualTitle.equals(expectedTitle)) {

        }
        if (actualTitle.contains(expectedTitle)) {
            ExcelUtils.setCellData("WindowTest", 1, 2, "PASS");
        } else {
            ExcelUtils.setCellData("WindowTest", 1, 2, "FAIL");
        }
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        page.closeChildWindow();

        page.switchToParentWindow();
    }
}