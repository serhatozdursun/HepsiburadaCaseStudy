package pages;

import base.PageBase;

import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static enums.LoginInfo.USER_NAME;

public class HomePage extends TestBase {
    private RemoteWebDriver driver;

    public HomePage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, PageBase.WAIT_TIME), this);
    }

    @FindBy(css = ".logo-hepsiburada")
    private WebElement logoHepsiburada;

    @FindBy(id = "myAccount")
    private WebElement myAccount;

    @FindBy(id = "login")
    private WebElement login;

    @FindBy(css = ".user-name")
    private WebElement userName;

    @FindBy(id = "kitap-muzik-film-hobi")
    private WebElement kitapMuzikFilmHobi;

    @FindBy(css = "[data-categoryid='2147483645']")
    private WebElement books;

    @FindBy(id = "elektronik")
    private WebElement electronicMenu;

    @FindBy(css = "[data-categoryid='2147483646']")
    private WebElement laptopOption;

    @FindBy(css = "[data-categoryid='98']")
    private WebElement computerTabletItem;

    public HomePage assertHomeIsLoaded() {
        System.out.println("confirming the page is loading");
        Assert.assertTrue("logo is not displayed on homepage", logoHepsiburada.isDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.hepsiburada.com/"));
        return this;
    }

    public HomePage moveToMyAccount() throws InterruptedException {
        System.out.println("move to myAccount menue");
        moveElement(driver, myAccount);
        return this;
    }

    public LoginPage clickLogin() {
        System.out.println("click login button");
        login.click();
        return new LoginPage(driver);
    }

    public HomePage assertIsLoggedIn() {
        System.out.println("confirming user was logged in");
        waitForDOMLoad(driver);
        Assert.assertEquals(USER_NAME.getLoginInfo(), userName.getText());
        return this;
    }

    public HomePage moveToKitapMuzikFilmHobi() throws InterruptedException {
        System.out.println("move to kitapMuzikFilmHobi");
        moveElement(driver, kitapMuzikFilmHobi);
        return this;
    }

    public SearchResultPage clickRandomBooksSubMenu() throws InterruptedException {
        System.out.println("click books submenue");
        books.click();
        return new SearchResultPage(driver);
    }

    public HomePage moveElectronicMenu() throws InterruptedException {
        System.out.println("move to electronic menu");
        moveElement(driver,electronicMenu);
        return this;
    }

    public HomePage moveLaptopOption() throws InterruptedException {
        System.out.println("move to laptop option menu");
        moveElement(driver,laptopOption);
        return this;
    }

    public SearchResultPage clickComputerTabletItem() throws InterruptedException {
        System.out.println("click computer tablet item");
        waitForElementToBeClickable(driver,computerTabletItem);
        clickElementWithJS(driver,computerTabletItem);
        return new SearchResultPage(driver);
    }
}
