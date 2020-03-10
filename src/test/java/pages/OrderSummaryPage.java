package pages;

import base.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static pages.ProductDetailPage.PRODUCT_PRICE;
import static pages.SearchResultPage.PRODUCT_NAME;

public class OrderSummaryPage {
    RemoteWebDriver driver;

    public OrderSummaryPage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, PageBase.WAIT_TIME), this);
    }

    @FindBy(css = ".box-header-title")
    private WebElement title;

    @FindBy(css = "#frm-save-order .btn-primary")
    private WebElement confrimbtn;

    @FindBy(css = ".price")
    private WebElement orderProductPrice;

    @FindBy(css = ".col-product-name")
    private WebElement productName;


    public OrderSummaryPage assertOrderSummaryPageIsLoad() {
        System.out.println("assert order summary pageIsLoad");
        Assert.assertEquals("Sipariş Özeti", title.getText());
        Assert.assertEquals("https://www.hepsiburada.com/ayagina-gelsin/siparis-ozeti", driver.getCurrentUrl());
        return this;
    }

    public OrderSummaryPage assertProductInfo() {
        float orderSummaryPrice = Float.parseFloat(orderProductPrice.getText().replace(" TL", "")
                .replace(".", "")
                .replace(",", "."));
        Assert.assertTrue(PRODUCT_PRICE == orderSummaryPrice);
        String orderSummaryProductName = productName.getText();
        Assert.assertEquals(PRODUCT_NAME, orderSummaryProductName);
        return this;
    }

    public OrderComplatedPage clickConfirmOrder() {
        System.out.println("click confirm order");
        confrimbtn.click();
        return new OrderComplatedPage(driver);
    }


}
