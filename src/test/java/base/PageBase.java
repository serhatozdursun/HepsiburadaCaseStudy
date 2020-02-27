package base;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PageBase {
    public RemoteWebDriver driver;
    public static String browser;
    public static int WAIT_TIME =15;

    @Before
    public void initialize() throws Exception {
        browser = System.getProperty("browser");
        if (browser == null)
          throw new Exception("undefined browser name, please set a -Dbrowser parameter" );
        switch (browser) {
            case "Chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--ignore-certifcate-errors");
                chromeOptions.addArguments("--disable-popup-blocking");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-plugins");
                chromeOptions.addArguments("--disable-plugins-discovery");
                chromeOptions.addArguments("--disable-preconnect");
                chromeOptions.addArguments("'--dns-prefetch-disable'");
                chromeOptions.setAcceptInsecureCerts(true);
                chromeOptions.addArguments("test-type");
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
        }
        Configuration configuration = new Configuration();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(configuration.getBaseUrl());

    }

    @Rule
    public final TestRule watchman = new TestWatcher() {
        @Override
        public Statement apply(Statement base, Description description) {
            return super.apply(base, description);
        }

        @Override
        protected void failed(Throwable e, Description description) {

            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                File currPath = new File(System.getProperty("user.dir")
                        + "\\src\\test\\resources\\failImages\\" + browser + "-" + driver.getSessionId() + "-screenshot.png");
                System.out.println("Screenshot at: " + currPath.toString());
                FileHandler.copy(scrFile, currPath);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        @Override
        protected void finished(Description description) {
            if (driver != null)
                driver.quit();
            System.out.println("Test bitti");
        }
    };
}
