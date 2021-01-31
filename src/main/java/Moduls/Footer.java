package Moduls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Footer {

    WebDriver driver;
    WebDriverWait wait;

    public Footer(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    @FindBy(css = "a.footer__link[href=\"https://zbroia.com.ua/auth/logout\"]")
    private WebElement logoutItem;

    public boolean isLogined() {
        wait.until(ExpectedConditions.visibilityOf(logoutItem));
        return true;
    }

}
