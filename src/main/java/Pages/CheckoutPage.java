package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href=\"https://zbroia.com.ua/shop/product/nozh-mr-blade-cosmo-sleipner-green-s-w\"]")
    private WebElement knife;

    public boolean isCheckoutPageDisplayed() {
        if (driver.getTitle().equals("Корзина")) {
            return true;
        } else {
            return false;
        }
    }

}
