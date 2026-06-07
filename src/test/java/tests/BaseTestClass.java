package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.TestData;

import java.io.IOException;
import java.time.Duration;

public class BaseTestClass {

    WebDriver driver;
    static TestData testData;

    @BeforeMethod
    public void beforeMethod() throws IOException {
        testData = new TestData();

        String browser = testData.properties.getProperty("browser");

        switch (browser) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                ChromeOptions opts = new ChromeOptions();
                // Required on Linux CI runners regardless of headless mode
                opts.addArguments("--no-sandbox", "--disable-dev-shm-usage");
                driver = new ChromeDriver(opts);
                break;
            }
            case "chrome-headless": {
                WebDriverManager.chromedriver().setup();
                ChromeOptions opts = new ChromeOptions();
                // --headless=new is the modern flag (Chrome 112+); setHeadless(true) is removed in Selenium 4
                opts.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
                driver = new ChromeDriver(opts);
                break;
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            case "firefox-headless": {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions ffOpts = new FirefoxOptions();
                // Use addArguments instead of deprecated setHeadless(true)
                ffOpts.addArguments("-headless");
                driver = new FirefoxDriver(ffOpts);
                break;
            }
            case "ie": {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            }
            case "edge": {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            }
            case "safari": {
                WebDriverManager.getInstance(SafariDriver.class).setup();
                driver = new SafariDriver();
                break;
            }
        }

        driver.manage().window().setSize(new Dimension(1600, 1100));
        driver.manage().window().setPosition(new Point(0, 0));

        // Use Duration overload — implicitlyWait(long, TimeUnit) is deprecated in Selenium 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
