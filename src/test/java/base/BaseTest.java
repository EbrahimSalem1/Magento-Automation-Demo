package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import pages.HomePage;
import utils.PropertyReader;

public class BaseTest {

    public WebDriver driver;
    ChromeOptions chromeOptions;
    FirefoxOptions firefoxOptions;

    protected HomePage homePage;


    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        setUpBrowser(browser);
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
    }

    @Parameters("browser")
    public void setUpBrowser(@Optional ("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("headLessChrome")) {
            chromeOptions  = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("headlessFirefox")) {
            firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            driver = new FirefoxDriver(firefoxOptions);
        }
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}