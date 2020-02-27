package pages;

import base.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

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

    public OrderSummaryPage assertOrderSummaryPageIsLoad() {
        System.out.println("assert order summary pageIsLoad");
        Assert.assertEquals("Sipariş Özeti", title.getText());
        Assert.assertEquals("https://www.hepsiburada.com/ayagina-gelsin/siparis-ozeti", driver.getCurrentUrl());
        return this;
    }

    public OrderComplatedPage clickConfirmOrder(){
        System.out.println("click confirm order");
        confrimbtn.click();
        return new OrderComplatedPage(driver);
    }


}
