package pages;

import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static base.PageBase.WAIT_TIME;

public class ProductDetailPage extends TestBase {
    RemoteWebDriver driver;
    public static float PRODUCT_PRICE;

    public ProductDetailPage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIME), this);
    }

    @FindBy(id = "product-name")
    private WebElement productName;

    @FindBy(css = ".addToCartButton button")
    private WebElement addToCardButton;

    @FindBy(id = "notification")
    private WebElement notification;

    @FindBy(id = "shoppingCart")
    private WebElement basketButton;

    @FindBy(css = ".extra-discount-price")
    private WebElement producetPrice;

    public ProductDetailPage assertProductDetailPageIsOpen() {
        System.out.println("assert product etail page is open");
        Assert.assertEquals(productName.getText().trim(), SearchResultPage.PRODUCT_NAME);
        return this;
    }

    public ProductDetailPage clickAddToCardButton() {
        System.out.println("click add to card button");
        waitForElementToBeClickable(driver, addToCardButton);
        addToCardButton.click();
        return this;
    }

    public ProductDetailPage checkNotificationIsDisplayed() {
        System.out.println("check notification was displayed");
        Assert.assertTrue("notifcation wasn't displayed", notification.isDisplayed());
        return this;
    }

    public ProductDetailPage checkAddToBasketSuccessNotificationMessage() {
        System.out.println("check notification message");
        Assert.assertEquals("success message is wrong", "Ürün başarılı bir şekilde sepete eklenmiştir.", notification.getText());
        waitForInvisibilityOfAllElements(driver, notification);
        return this;
    }

    private void setProductPrice() {
        PRODUCT_PRICE = Float.parseFloat(producetPrice.getText()
                .replace(" TL", "")
                .replace(".", "")
                .replace(",", "."));
    }
    public ShoppingCartPage clickBasketButton() {
        setProductPrice();
        System.out.println("click baseket");
        basketButton.click();
        return new ShoppingCartPage(driver);
    }
}
