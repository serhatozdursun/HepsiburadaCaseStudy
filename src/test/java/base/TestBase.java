package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

    public void moveElement(RemoteWebDriver driver, WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
    }

    public WebDriverWait wait(RemoteWebDriver driver) {
        return new WebDriverWait(driver, 15);
    }

    public void waitForInvisibilityOfAllElements(RemoteWebDriver driver, WebElement webElement) {
        wait(driver).until(ExpectedConditions.invisibilityOfAllElements(webElement));
    }

    public boolean isElementPresent(RemoteWebDriver driver, By by, Class page) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 1), page);
        if (driver.findElements(by).size() > 0) {
            PageFactory.initElements(new AjaxElementLocatorFactory(driver, PageBase.WAIT_TIME), page);
            return true;
        } else {
            PageFactory.initElements(new AjaxElementLocatorFactory(driver, PageBase.WAIT_TIME), page);
            return false;
        }
    }

    public boolean isChecked(RemoteWebDriver driver, String cssSelector, int index) {
        JavascriptExecutor javascriptExecutor = driver;
        return Boolean.parseBoolean(javascriptExecutor.executeScript("return document.querySelectorAll(\"" + cssSelector + "\")[" + index + "].checked;").toString());
    }

    public void clickElementWithJS(RemoteWebDriver driver, WebElement element) {
        JavascriptExecutor js = driver;

        js.executeScript("arguments[0].click();", element);
    }
}
