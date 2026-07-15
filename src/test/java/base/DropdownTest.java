package base;

import org.testng.annotations.Test;

import pages.DropdownPage;
import utils.ExcelUtils;

public class DropdownTest extends BaseTest {

    @Test
    public void dropdownTest() throws Exception {   // ✅ FIX HERE

        driver.get("https://letcode.in/dropdowns");

        DropdownPage page = new DropdownPage(driver);

        //  Excel Data
        String fruit = ExcelUtils.getCellData("DropdownTest", 1, 0);
        String hero1 = ExcelUtils.getCellData("DropdownTest", 1, 1);
        String hero2 = ExcelUtils.getCellData("DropdownTest", 1, 2);

        //  Actions
        page.selectFruit(fruit);
        page.selectHeroes(hero1, hero2);
        page.selectLastLanguage();
        page.printAllLanguages();
        page.selectCountry("India");
        page.printSelectedCountry();

        //  Result
        ExcelUtils.setCellData("DropdownTest", 1, 3, "Passed");
    }
}