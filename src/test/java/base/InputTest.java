package base;

import org.testng.annotations.Test;

import pages.InputPage;
import utils.ExcelUtils;

public class InputTest extends BaseTest {

    InputPage inputPage;

    @Test
    public void inputTest() throws Exception {

       
        driver.navigate().to("https://letcode.in/edit");

        inputPage = new InputPage(driver);
        String name = ExcelUtils.getCellData("InputTest", 1, 0);
        String text = ExcelUtils.getCellData("InputTest", 1, 1);

        inputPage.input(name, text);
        ExcelUtils.setCellData("InputTest", 1, 2, "Passed");
       
    }
}