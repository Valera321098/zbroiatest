import moduls.Catalog;
import moduls.Footer;
import moduls.Header;
import org.junit.jupiter.api.*;
import pages.CartWindow;
import settings.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class BaseTest {
    public ChromeDriver driver;
    public Header header;
    public Footer footer;
    public Catalog catalog;
    public TestConfig testConfig;
    public CartWindow cartWindow;


    @BeforeEach
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver88.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        header = PageFactory.initElements(driver,  Header.class);
        footer =  PageFactory.initElements(driver, Footer.class);
        catalog = PageFactory.initElements(driver, Catalog.class);
        cartWindow =PageFactory.initElements(driver, CartWindow.class);
        testConfig = ConfigFactory.create(TestConfig.class);
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    public BaseTest login() {
        driver.get(testConfig.baseUrl());
        driver.manage().window().maximize();
        header
                .openSignUpDialog()
                .inputLogin(testConfig.email())
                .inputPassword(testConfig.password())
                .submitLogin();

        Assertions.assertTrue(footer.isLogined());
        return this;
    }

    public void goToFoldingKnives() {
        driver.get("https://zbroia.com.ua/shop/category/nozhi-i-instrumenty/nozhi-skladnye-3879");
        driver.manage().window().maximize();
    }

}
