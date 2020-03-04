package pages;

import base.PageBase;
import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;
import java.util.Random;

public class PaymentPage extends TestBase {
    RemoteWebDriver driver;

    public PaymentPage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, PageBase.WAIT_TIME), this);
    }

    @FindBy(css = "[data-bind*=paymentTypeList]")
    private WebElement paymentTypeList;

    @FindBy(css = ".paymentType-2")
    private WebElement clickMonyTransfer;

    @FindBy(css = ".input-select")
    private List<WebElement> selectBankSelect;

    @FindBy(css = ".iban-eft")
    private WebElement ibanEft;

    @FindBy(css = ".proceed-container .btn-primary")
    private WebElement continueBtonOnProceedContainer;

    @FindBy(css = ".eft-info-container .long")
    private  WebElement continueButtonOnFancyBox;

    public PaymentPage assertPaymentPageIsLoad() {
        System.out.println("assert payment page is load");
        Assert.assertTrue("payment type list wasn't displayed", paymentTypeList.isDisplayed());

        Assert.assertEquals("https://www.hepsiburada.com/ayagina-gelsin/odeme", driver.getCurrentUrl());
        return this;
    }

    public PaymentPage clickMoneyTransfer() throws InterruptedException {
        System.out.println("click money transfer");
        waitForElementToBeClickable(driver,clickMonyTransfer);
        Thread.sleep(200);
        clickMonyTransfer.click();
        return this;
    }

    public PaymentPage clickRandomBank(){
        System.out.println("click random bank");
        Random random = new Random();
        clickElementWithJS(driver,selectBankSelect.get(random.nextInt(selectBankSelect.size()-1)));
        return this;
    }

    public PaymentPage chooseMoneyTransferOpiton(){
        if (isElementPresent(driver, By.cssSelector("[data-bind*='setInstantEft']"), PaymentPage.class))
            clickElementWithJS(driver, ibanEft);
        return this;
    }

    public PaymentPage clickContiuonProceedContainer(){
        System.out.println("click continue");
        clickElementWithJS(driver,continueBtonOnProceedContainer);
        return this;
    }

    public OrderSummaryPage clickContiuonFancyBox(){
        System.out.println("click continue");
        waitForElementToBeClickable(driver,continueButtonOnFancyBox);
        clickElementWithJS(driver,continueButtonOnFancyBox);
        return new OrderSummaryPage(driver);
    }




}
