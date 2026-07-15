package base;

import org.testng.annotations.Test;

import pages.SortPage;

public class SortTest extends BaseTest {

    @Test
    public void sortTest() throws Exception {

        driver.get("https://letcode.in/sortable");

        SortPage page = new SortPage(driver);

        System.out.println("Before Sorting");
        page.printItems();

        Thread.sleep(2000);

        page.sortItems();

        Thread.sleep(2000);

        System.out.println("After Sorting");
        page.printItems();
    }
}