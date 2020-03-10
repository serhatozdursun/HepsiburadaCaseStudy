package pages;

import base.PageBase;
import base.TestBase;
import enums.Delivery;
import enums.EasyPoint;
import enums.ShippmentType;
import org.junit.Assert;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class ShippingPage extends TestBase {
    RemoteWebDriver driver;

    public ShippingPage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, PageBase.WAIT_TIME), this);
    }

    @FindBy(css = ".delivery-addresses")
    private List<WebElement> deliveryAddresses;

    @FindBy(css = ".btn-primary")
    private List<WebElement> btnPrimary;

    @FindBy(css = "[data-bind*='deliveryName']")
    private List<WebElement> shippmentPoint;

    @FindBy(css = ".easy-point-name")
    private List<WebElement> easyPoint;

    @FindBy(css = ".delivery-icon")
    private WebElement deliveryIcon;

    @FindBy(id = "ep-first-name")
    private WebElement epFirstName;

    @FindBy(id = "ep-last-name")
    private WebElement epLastName;

    @FindBy(id = "easy-point-phone")
    private WebElement easyPointPhone;

    @FindBy(css = ".btn-add-new")
    private WebElement addNewAddress;

    @FindBy(id = "first-name")
    private WebElement addressFirstName;

    @FindBy(id = "last-name")
    private WebElement addressLastName;

    @FindBy(css = "button[data-id='city'")
    private WebElement addressCity;

    @FindBy(id = "address")
    private WebElement address;

    @FindBy(id = "address-name")
    private WebElement addressName;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(css = "#add-address-container .btn-primary")
    private WebElement addressSave;

    @FindBy(id = "add-address-container")
    private WebElement addresContainer;

    @FindBy(css = ".selectpicker[style*='auto'] li")
    private List<WebElement> options;

    @FindBy(css = "[data-id='town']")
    private WebElement selectTown;

    @FindBy(xpath = "//*[@data-id='town']/following-sibling::div//a")
    private List<WebElement> townOptions;

    @FindBy(css = "[data-id='district']")
    private WebElement selectDistrict;

    @FindBy(xpath = "//*[@data-id='district']/following-sibling::div//a")
    private List<WebElement> districtOptions;

    @FindBy(xpath = "//button[contains(.,'Devam Et')]")
    private List<WebElement> contiunue;

    public ShippingPage assertShippingPageIsLoad() {
        System.out.println("assert shipping page isLoad");
        Assert.assertTrue("shipping page wasn't loaded", deliveryIcon.isDisplayed());

        Assert.assertEquals("https://www.hepsiburada.com/ayagina-gelsin/teslimat", driver.getCurrentUrl());
        return this;
    }

    public PaymentPage clickContinue() throws InterruptedException {
        System.out.println("click continue");
        Thread.sleep(500);
        clickElementWithJS(driver, btnPrimary.get(0));
        return new PaymentPage(driver);
    }

    public ShippingPage clickEasyPointContinue() throws InterruptedException {
        clickContinue();
        System.out.println("click continue");
        waitForElementToBeClickable(driver, btnPrimary.get(1));
        clickElementWithJS(driver,btnPrimary.get(1));
        return this;
    }


    public ShippingPage clickShippmentPoint(ShippmentType shippmentType) {
        System.out.println("click shippment point");
        shippmentPoint.get(shippmentType.getShippmentType()).click();
        return this;
    }

    public ShippingPage clickEasyPoint(EasyPoint easyPoint) {
        System.out.println("click easy point");
        this.easyPoint.get(easyPoint.getEasyPointIndex()).click();
        return this;
    }

    public ShippingPage typeEasyPointFirstName(Delivery firstName) throws InterruptedException {
        System.out.println("type easy point first name");
        moveElement(driver, epFirstName);
        epFirstName.sendKeys(firstName.getDeliveryInfo());
        return this;
    }

    public ShippingPage typeEasyPointLastName(Delivery lastName) throws InterruptedException {
        System.out.println("type easy point last name");
        moveElement(driver, epLastName);
        epLastName.sendKeys(lastName.getDeliveryInfo());
        return this;
    }

    public ShippingPage typeEasyPointPhonenumber(Delivery phoneNumber) throws InterruptedException {
        System.out.println("type easy point phone number");
        moveElement(driver, easyPointPhone);
        easyPointPhone.sendKeys(phoneNumber.getDeliveryInfo());
        return this;
    }

    public ShippingPage clickAddInvoiceInfo() {
        System.out.println("click Add Invoice Info");
        addNewAddress.click();
        return this;
    }

    public ShippingPage typeFirstName(Delivery firstName) {
        System.out.println("type First Name");
        addressFirstName.sendKeys(firstName.getDeliveryInfo());
        return this;
    }

    public ShippingPage typeLastName(Delivery lastName) {
        System.out.println("type last Name");
        addressLastName.sendKeys(lastName.getDeliveryInfo());
        return this;
    }

    public ShippingPage selectCity() throws InterruptedException {
        addressCity.click();
        Thread.sleep(100);
        options.get(1).click();
        return this;
    }

    public ShippingPage typeAdress() {
        System.out.println("type adress");
        address.sendKeys("adres adres adress");
        return this;
    }

    public ShippingPage typeAddressName() {
        System.out.println("type address name");
        addressName.sendKeys("deneme");
        return this;
    }

    public ShippingPage clickAddresSaveBtn() {
        System.out.println("click addres aave btn");
        addressSave.click();
        return this;
    }



    public ShippingPage selectTown() throws InterruptedException {
        System.out.println("click town");
        selectTown.click();
        Thread.sleep(100);
        townOptions.get(4).click();
        return this;
    }

    public ShippingPage selectDistrict() throws InterruptedException {
        System.out.println("click District");
        selectDistrict.click();
        Thread.sleep(100);
        districtOptions.get(4).click();
        return this;
    }

    public ShippingPage typePhoneNumber(Delivery phoneNumber){
        System.out.println("type phone number");
        phone.sendKeys(phoneNumber.getDeliveryInfo());
        return this;
    }

    public PaymentPage clickContiune(){
        System.out.println("click continue");
       contiunue.get(1).click();
        return new PaymentPage(driver);
    }
}
