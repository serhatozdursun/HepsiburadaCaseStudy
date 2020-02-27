package pages;

import base.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class ShippingPage {
    RemoteWebDriver driver;
    public ShippingPage(RemoteWebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, PageBase.WAIT_TIME),this);
    }

    @FindBy(css = ".delivery-addresses")
    private List<WebElement> deliveryAddresses;

    @FindBy(css = ".btn-primary")
    private WebElement btnPrimary;

    public ShippingPage assertShippingPageIsLoad(){
        System.out.println("assert shipping page isLoad");
        Assert.assertTrue("shipping page wasn't loaded",deliveryAddresses.get(0).isDisplayed());

        Assert.assertEquals("https://www.hepsiburada.com/ayagina-gelsin/teslimat",driver.getCurrentUrl());
        return this;
    }

    public PaymentPage clickContinue(){
        System.out.println("click continue");
        btnPrimary.click();
        return new PaymentPage(driver);
    }
}
