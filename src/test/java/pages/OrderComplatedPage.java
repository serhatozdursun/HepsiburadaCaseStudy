package pages;

import base.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class OrderComplatedPage {
    RemoteWebDriver driver;
    public static String ORDER_NUMBER;
    public OrderComplatedPage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, PageBase.WAIT_TIME), this);
    }

    @FindBy(css = ".section-header .box-header-title")
    private WebElement title;

    @FindBy(css = ".link-type-one")
    private WebElement orderDetail;

    @FindBy(css = ".order-number strong")
    private WebElement orderNumber;

    public OrderComplatedPage assertOrderComplatedPageIsLoad(){
        System.out.println("assert order complated page is load");
        Assert.assertEquals("Siparişiniz Alındı",title.getText().replace("\n","").trim());
        Assert.assertEquals("https://www.hepsiburada.com/ayagina-gelsin/siparis-tamamlandi",driver.getCurrentUrl());
        return this;
    }

    public OrderDetailPage clickOrderDetail(){
        System.out.println("click order detail");
        orderDetail.click();
        return new OrderDetailPage(driver);
    }


    public OrderComplatedPage setOrderNumber() {
        ORDER_NUMBER = orderNumber.getText();
        return this;
    }

}
