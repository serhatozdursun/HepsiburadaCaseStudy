package pages;

import base.PageBase;
import base.TestBase;
import enums.LoginInfo;
import org.junit.Assert;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class LoginPage extends TestBase {
    public RemoteWebDriver driver;
    public LoginPage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, PageBase.WAIT_TIME), this);
    }

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "lazy-email")
    private WebElement lazyEmail;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = ".btn-login-submit")
    private List<WebElement> btnLoginSubmit;

    @FindBy(css = "[for='select-guest']")
    private WebElement selectGuest;

    public LoginPage assertLoginPageIsLoaded() {
        Assert.assertTrue("email input is not displayed", emailInput.isDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("giris"));
        return this;
    }

    public LoginPage typeEmail(LoginInfo mail) {
        System.out.println("typing email");
        emailInput.sendKeys(mail.getLoginInfo());
        return this;
    }

    public LoginPage typePassword(LoginInfo password) {
        System.out.println("typing password");
        passwordInput.sendKeys(password.getLoginInfo());
        return this;
    }

    public HomePage clickBtnLoginSubmit() {
        System.out.println("clicking btnLoginSubmit button");
        clickElementWithJS(driver,btnLoginSubmit.get(0));
        return new HomePage(driver);
    }

    public ShippingPage clickBtnLoginForGuestSubmit() {
        System.out.println("clicking btnLoginSubmit button");
        clickElementWithJS(driver,btnLoginSubmit.get(1));
        return new ShippingPage(driver);
    }

     public LoginPage clickGuest() {
        System.out.println("click guest");
        selectGuest.click();
        return this;
    }

    public LoginPage typelazyEmail(LoginInfo email) {
        System.out.println("type lazy email");
        lazyEmail.sendKeys(email.getLoginInfo());
        return this;
    }
}
