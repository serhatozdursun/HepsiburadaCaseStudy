package pages;

import base.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ShoppingCartPage {
    RemoteWebDriver driver;

    public ShoppingCartPage(RemoteWebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, PageBase.WAIT_TIME),this);
    }

    @FindBy(css = ".btn-primary")
    private WebElement btnPrimary;

    @FindBy(css = ".product-name")
    private WebElement productName;

    public ShoppingCartPage assertShoppingCartPageIsLoaded(){
        System.out.println("assert shopping cart page is loaded");
        Assert.assertTrue("btnPrimary wasn't displayed",btnPrimary.isDisplayed());

        Assert.assertEquals("https://www.hepsiburada.com/ayagina-gelsin/sepetim",driver.getCurrentUrl());
        return this;
    }

    public ShippingPage clickBtnPrimary(){
        System.out.println("click BtnPrimary");
        btnPrimary.click();
        return new ShippingPage(driver);
    }

    public LoginPage clickBtnPrimaryWithoutSignIn(){
        System.out.println("click BtnPrimary");
        btnPrimary.click();
        return new LoginPage(driver);
    }

    public ShoppingCartPage checkProduct(){
        System.out.println("check product");
        Assert.assertEquals(SearchResultPage.PRODUCT_NAME,productName.getText());
        return this;
    }
}
