import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    ChromeDriver driver;
    WebDriverWait wait;

    @Before
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver87.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void closeDriver() {
//        driver.quit();
    }
}
