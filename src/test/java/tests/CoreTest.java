package tests;

import base.PageBase;
import org.junit.Test;
import pages.HomePage;

public class CoreTest extends PageBase {

    @Test
    public void test() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.assertHomeIsLoaded()
                .moveTomMAccount()
                .clickLogin()
                .assertLoginPageIsLoaded()
                .typeEmail()
                .typePassword()
                .clickBtnLoginSubmit()
                .assertIsLoggedIn()
                .moveToKitapMuzikFilmHobi()
                .clickRandomBooksSubMenu()
                .assertBookAndMagazineCategoryIsLoad()
                .clickRandomProductOnProductList()
                .checkNotificationIsDisplayed()
                .checkAddToBasketSuccessNotificationMessage()
                .clickShoppingCart()
                .assertShoppingCartPageIsLoaded()
                .clickBtnPrimary()
                .assertShippingPageIsLoad()
                .clickContinue()
                .assertPaymentPageIsLoad()
                .clickMoneyTransfer()
                .clickRandomBank()
                .clickContiuonProceedContainer()
                .chooseMoneyTransferOpiton()
                .clickContiuonFancyBox()
                .assertOrderSummaryPageIsLoad()
                .clickConfirmOrder()
                .assertOrderComplatedPageIsLoad()
                .setOrderNumber()
                .clickOrderDetail()
                .assertOrderDetailPageIsLoad()
                .clickCancelPage()
                .clickReasonForCancellation()
                .assertItemsCancelMessage()
                .closemodel();
    }
}
