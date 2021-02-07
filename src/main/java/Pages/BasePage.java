package Pages;

import Moduls.Catalog;
import Moduls.CatalogToolbar;
import Moduls.Footer;
import Moduls.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions  actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        actions = new Actions(driver);
    }

    public void waitElement(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElement(By locator) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public boolean isElementDisplayed(WebElement element)  {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }
}