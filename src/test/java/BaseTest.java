import Moduls.Catalog;
import Moduls.Footer;
import Moduls.Header;
import Pages.CartPage;
import Settings.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public ChromeDriver driver;
    public Header header;
    public Footer footer;
//    public CatalogToolbar catalogToolbar;
    public Catalog catalog;
    public TestConfig testConfig;
    public CartPage cartPage;

    @Before
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver87.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        catalogToolbar = PageFactory.initElements(driver, CatalogToolbar.class);
        header = PageFactory.initElements(driver,  Header.class);
        footer =  PageFactory.initElements(driver, Footer.class);
        catalog = PageFactory.initElements(driver, Catalog.class);
        cartPage =PageFactory.initElements(driver, CartPage.class);
        testConfig = ConfigFactory.create(TestConfig.class);
    }

    @After
    public void closeDriver() {
//        driver.quit();
    }
}
