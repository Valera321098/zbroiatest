package Moduls;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Footer extends BasePage{

    public Footer(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.footer__link[href=\"https://zbroia.com.ua/auth/logout\"]")
    private WebElement logoutItem;

    public boolean isLogined() {
        if (logoutItem.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

}
