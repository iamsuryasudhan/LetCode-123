package base;

import org.testng.annotations.Test;
import pages.AlertPage;
import utils.ExcelUtils;

public class AlertTest extends BaseTest {

    @Test
    public void alertTest() throws Exception {

        driver.get("https://letcode.in/alert");

        AlertPage page = new AlertPage(driver);

        for (int i = 1; i <= 2; i++) {

            String input = null;

            try {
                input = ExcelUtils.getCellData("AlertTest", i, 0);
            } catch (Exception e) {
                continue; // skip empty row
            }

            if (input == null || input.trim().isEmpty()) {
                continue;
            }

            page.handlePromptAlert(input);

            ExcelUtils.setCellData("AlertTest", i, 1, "PASS");
        }
    }
}