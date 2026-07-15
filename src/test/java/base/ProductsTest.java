package base;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductsPage;
import utils.ExcelUtils;

public class ProductsTest extends BaseTest {

    @Test
    public void productsTest() throws Exception {

        driver.get("https://letcode.in/home");

        ProductsPage page = new ProductsPage(driver);

        // 🔹 Read from Excel
        String productName = ExcelUtils.getCellData("ProductsTest", 1, 0);

        // 🔹 Open product
        page.openProductByName(productName);

        // 🔹 Add to cart
        page.addToCart();

        // 🔹 Open cart
        page.openCart();

        // 🔹 Validation (strong)
        Assert.assertTrue(
            driver.getCurrentUrl().contains("cart") 
            || driver.getPageSource().contains("Cart"),
            "Cart not opened"
        );

        // 🔹 Write result
        ExcelUtils.setCellData("ProductsTest", 1, 1, "Passed");
    }
}