package pages;

import base.PageBase;
import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;
import java.util.Random;

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

    @FindBy(css = "[href*='kitaplar']")
    private List<WebElement> books;

    public HomePage assertHomeIsLoaded() {
        System.out.println("confirming the page is loading");
        Assert.assertTrue("logo is not displayed on homepage", logoHepsiburada.isDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.hepsiburada.com/"));
        return this;
    }

    public HomePage moveTomMAccount() {
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
        String username = userName.getText();
        Assert.assertEquals(USER_NAME.getLoginInfo(), userName.getText());
        return this;
    }

    public HomePage moveToKitapMuzikFilmHobi() {
        System.out.println("move to kitapMuzikFilmHobi");
        moveElement(driver, kitapMuzikFilmHobi);
        return this;
    }

    public SearchResultPage clickRandomBooksSubMenu(){
        System.out.println("click books submenue");
        Random random = new Random();
        books.get(random.nextInt(books.size()-1)).click();
        return new SearchResultPage(driver);
    }
}
