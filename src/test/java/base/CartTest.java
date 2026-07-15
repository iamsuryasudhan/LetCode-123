package base;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductsPage;
import pages.CartPage;
import utils.ExcelUtils;

public class CartTest extends BaseTest {

    @Test
    public void cartTest() throws Exception {

        driver.get("https://letcode.in/home");

        ProductsPage productPage = new ProductsPage(driver);

        // Excel (only for selection)
        String productName = ExcelUtils.getCellData("CartTest", 1, 0);

        productPage.openProductByName(productName);
        productPage.addToCart();
        productPage.openCart();

        CartPage cartPage = new CartPage(driver);

      
        Assert.assertTrue(
            cartPage.isCartPageDisplayed(),
            "Cart page not opened"
        );

        // Write result
        ExcelUtils.setCellData("CartTest", 1, 1, "Passed");
    }
}