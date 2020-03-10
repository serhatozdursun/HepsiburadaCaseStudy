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
import java.util.NoSuchElementException;

public class OrderDetailPage extends TestBase {
    RemoteWebDriver driver;

    public OrderDetailPage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, PageBase.WAIT_TIME), this);
    }

    @FindBy(css = ".main__container__title")
    private WebElement title;

    @FindBy(css = ".hb-button--secondary")
    private List<WebElement> clickCancelBtn;

    @FindBy(css = ".cancel-line-item__list .item")
    private List<WebElement> items;

    @FindBy(css = ".selectbox-placeholder")
    private List<WebElement> cancelReasonSelectBox;

    @FindBy(css = ".selectbox-result__list [tabindex]")
    private List<WebElement> reasonOpitions;

    @FindBy(css = ".cancel-line-item__footer .hb-button--primary")
    private WebElement cancelSelectedItems;

    @FindBy(css = ".alert-inner-bar__text")
    private WebElement alertText;

    @FindBy(css = ".modal__body__close-button")
    private WebElement detailModalCloseButton;

    public OrderDetailPage assertOrderDetailPageIsLoad() {
        System.out.println("assert order detail page is load");
        Assert.assertEquals("Sipariş Detayı", title.getText().replace("\n", "").trim());

        Assert.assertEquals("https://www.hepsiburada.com/siparislerim/detay/" + OrderComplatedPage.ORDER_NUMBER, driver.getCurrentUrl());
        return this;
    }

    public OrderDetailPage clickCancelPage() {
        System.out.println("click cancel");
        clickCancelBtn.get(0).click();
        return this;
    }

    public OrderDetailPage clickReasonForCancellation() throws InterruptedException {
        System.out.println("all item is canceling");
        for (int i = 0; i < items.size(); i++) {
            if (!isChecked(driver, ".hb-form-checkbox__input", i)) {
                WebElement checkBox = items.get(i).findElement(By.cssSelector(".hb-form-checkbox__input"));
                scrollToElement(driver, checkBox);
                clickElementWithJS(driver, checkBox);
            }
            for (int j = 0; j < 5; i++) {
                Thread.sleep(10);
                if (isElementPresent(driver, By.cssSelector(".selectbox-placeholder"), OrderDetailPage.class)) {
                    break;
                }
            }

            clickElementWithJS(driver, cancelReasonSelectBox.get(i));
            clickElementWithJS(driver, reasonOpitions.get(2));
        }
        clickElementWithJS(driver,cancelSelectedItems);
        return this;
    }

    public OrderDetailPage assertItemsCancelMessage() throws Exception {
        System.out.println("assert cancel item message");
        String text = new String();
        try{
            text =alertText.getText();
        }catch (NoSuchElementException e){
            throw new Exception("this item can't canceld"+ " "+e.getMessage());
        }
        Assert.assertTrue(text.contains("iptal edildi"));
        return this;
    }

    public OrderDetailPage closemodel(){
        System.out.println("click close modal");
        detailModalCloseButton.click();
        return this;
    }
}
