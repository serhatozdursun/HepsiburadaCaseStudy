package pages;

import base.PageBase;
import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;
import java.util.Random;

public class SearchResultPage extends TestBase {
    RemoteWebDriver driver;

    public SearchResultPage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, PageBase.WAIT_TIME), this);
    }

    public static String PRODUCT_NAME;

    @FindBy(css = ".sibling")
    private WebElement sibling;

    @FindBy(css = ".search-item .product")
    private List<WebElement> productList;

    @FindBy(id = "notification")
    private WebElement notification;

    @FindBy(id = "shoppingCart")
    private WebElement shoppingCart;

    public SearchResultPage assertBookAndMagazineCategoryIsLoad() {
        System.out.println("confirming the BookAndMagazine page is loading");
        Assert.assertTrue(sibling.getText().contains("Kitap"));
        return this;
    }

    public SearchResultPage clickRandomProductOnProductList() {
        System.out.println("click random product on product list");
        Random random = new Random();

        WebElement selectedProduct = productList.get(random.nextInt(productList.size() - 1));
        moveElement(driver, selectedProduct);

        selectedProduct.findElement(By.cssSelector(".add-to-basket")).click();
        PRODUCT_NAME = selectedProduct.findElement(By.cssSelector(".product-title")).getText();
        return this;
    }

    public SearchResultPage checkNotificationIsDisplayed() {
        System.out.println("check notification was displayed");
        Assert.assertTrue("notifcation wasn't displayed", notification.isDisplayed());
        return this;
    }

    public SearchResultPage checkAddToBasketSuccessNotificationMessage() {
        System.out.println("check notification message");
        Assert.assertEquals("success message is wrong", "Ürün başarılı bir şekilde sepete eklenmiştir.", notification.getText());
        waitForInvisibilityOfAllElements(driver,notification);
        return this;
    }

    public ShoppingCartPage clickShoppingCart() {
        System.out.println("click shopping cart");
        moveElement(driver, shoppingCart);
        shoppingCart.click();
        return new ShoppingCartPage(driver);
    }
}
