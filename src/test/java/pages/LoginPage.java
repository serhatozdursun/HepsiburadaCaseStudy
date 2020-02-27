package pages;

import base.PageBase;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static enums.LoginInfo.PASSWORD;
import static enums.LoginInfo.EMAIL;

public class LoginPage {
    public RemoteWebDriver driver;

    public LoginPage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, PageBase.WAIT_TIME), this);
    }

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = ".btn-login-submit")
    private WebElement btnLoginSubmit;

    public LoginPage assertLoginPageIsLoaded() {
        Assert.assertTrue("email input is not displayed", emailInput.isDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("giris"));
        return this;
    }

    public LoginPage typeEmail() {
        System.out.println("typing email");
        emailInput.sendKeys(EMAIL.getLoginInfo());
        return this;
    }

    public LoginPage typePassword() {
        System.out.println("typing password");
        passwordInput.sendKeys(PASSWORD.getLoginInfo());
        return this;
    }

    public HomePage clickBtnLoginSubmit(){
        System.out.println("clicking btnLoginSubmit button");
        btnLoginSubmit.click();
        return new HomePage(driver);
    }
}
