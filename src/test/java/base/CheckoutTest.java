package base;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductsPage;
import pages.CartPage;
import pages.CheckoutPage;
import utils.ExcelUtils;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() throws Exception {

        driver.get("https://letcode.in/home");

        ProductsPage productPage = new ProductsPage(driver);

        // Read from Excel
        String productName = ExcelUtils.getCellData("CheckoutTest", 1, 0);

        //  Add product
        productPage.openProductByName(productName);
        productPage.addToCart();
        productPage.openCart();

        CartPage cartPage = new CartPage(driver);

        boolean isCart = cartPage.isCartPageDisplayed();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        boolean clicked = checkoutPage.clickCheckoutIfPresent();

        boolean isCheckout = false;

        if (clicked) {
            isCheckout = checkoutPage.isCheckoutPageDisplayed();
        }

        //  Final assert
        Assert.assertTrue(isCart, "Cart not opened");

        //  Write result
        ExcelUtils.setCellData("CheckoutTest", 1, 1, "Passed");
    }
}