package Task.tests;

import Task.base.BaseTest;
import Task.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task18OrderItemTest extends BaseTest {

    @Test
    public void orderItemEndToEndTest() {

        Task18LoginPage loginPage = new Task18LoginPage(driver);
        Task18InventoryPage inventoryPage =
                loginPage.login("standard_user", "secret_sauce");

        String selectedItem =
                inventoryPage.getItemName();

        Task18CartPage cartPage =
                inventoryPage.addItemToCartAndGoToCart();

        Assert.assertEquals(
                cartPage.getCartItemName(),
                selectedItem,
                "Item in cart does not match selected item"
        );

        Task18CheckoutInfoPage infoPage =
                cartPage.clickCheckout();

        Task18CheckoutOverviewPage overviewPage =
                infoPage.enterDetailsAndContinue(
                        "Qahharat", "Ibrahim", "900103");

        Assert.assertEquals(
                overviewPage.getOverviewItemName(),
                selectedItem,
                "Item on overview page does not match"
        );

        Task18CheckoutCompletePage completePage =
                overviewPage.clickFinish();

        Assert.assertEquals(
                completePage.getSuccessMessage(),
                "Thank you for your order!",
                "Order success message not displayed"
        );
    }
}
