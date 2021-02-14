import moduls.Catalog;
import moduls.Footer;
import moduls.Header;
import pages.CartWindow;
import settings.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public ChromeDriver driver;
    public Header header;
    public Footer footer;
    public Catalog catalog;
    public TestConfig testConfig;
    public CartWindow cartWindow;

    @Before
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver87.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        header = PageFactory.initElements(driver,  Header.class);
        footer =  PageFactory.initElements(driver, Footer.class);
        catalog = PageFactory.initElements(driver, Catalog.class);
        cartWindow =PageFactory.initElements(driver, CartWindow.class);
        testConfig = ConfigFactory.create(TestConfig.class);
    }

    @After
    public void closeDriver() {
//        driver.quit();
    }

    public void login() {

        driver.get(testConfig.baseUrl());
        driver.manage().window().maximize();
        header
                .openSignUpDialog()
                .inputLogin(testConfig.email())
                .inputPassword(testConfig.password())
                .submitLogin();
        Assert.assertTrue(footer.isLogined());
    }
}
