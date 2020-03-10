package tests;

import base.PageBase;
import org.junit.Test;
import pages.HomePage;

import static enums.Delivery.*;
import static enums.EasyPoint.ISTANBUL_KANYON;
import static enums.LoginInfo.*;
import static enums.ShippmentType.SEND_TO_EASY_POINT;

public class CoreTest extends PageBase {

    @Test
    public void addToShoppingCardAndCancelOrderTest() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.assertHomeIsLoaded()
                .moveToMyAccount()
                .clickLogin()
                .assertLoginPageIsLoaded()
                .typeEmail(MEMBER_EMAIL)
                .typePassword(PASSWORD)
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

    @Test
    public void complateOrderWithoutSingUp() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.assertHomeIsLoaded()
                .moveElectronicMenu()
                .moveLaptopOption()
                .clickComputerTabletItem()
                .assertComputerCategoryIsLoad()
                .clickProduct(6)
                .assertProductDetailPageIsOpen()
                .clickAddToCardButton()
                .checkNotificationIsDisplayed()
                .checkAddToBasketSuccessNotificationMessage()
                .clickBasketButton()
                .assertShoppingCartPageIsLoaded()
                .checkProduct()
                .clickBtnPrimaryWithoutSignIn()
                .clickGuest()
                .typelazyEmail(EMAIL)
                .clickBtnLoginForGuestSubmit()
                .assertShippingPageIsLoad()
                .clickShippmentPoint(SEND_TO_EASY_POINT)
                .clickEasyPoint(ISTANBUL_KANYON)
                .typeEasyPointFirstName(FIRST_NAME)
                .typeEasyPointLastName(LAST_NAME)
                .typeEasyPointPhonenumber(PHONE_NUMBER)
                .clickAddInvoiceInfo()
                .typeFirstName(FIRST_NAME)
                .typeLastName(LAST_NAME)
                .selectCity()
                .selectTown()
                .selectDistrict()
                .typeAdress()
                .typeAddressName()
                .typePhoneNumber(PHONE_NUMBER)
                .clickAddresSaveBtn()
                .clickContinue()
                .assertPaymentPageIsLoad()
                .assertPaymentPageIsLoad()
                .clickMoneyTransfer()
                .clickRandomBank()
                .clickContiuonProceedContainer()
                .chooseMoneyTransferOpiton()
                .clickContiuonFancyBox()
                .assertOrderSummaryPageIsLoad()
                .assertProductInfo()
                .clickConfirmOrder();
    }

}
