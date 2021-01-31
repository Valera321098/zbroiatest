package Pages;

import Moduls.CatalogToolbar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FoldingKnivesPage extends CatalogToolbar {

    WebDriver driver;
    WebDriverWait wait;
    public FoldingKnivesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@href=\"https://zbroia.com.ua/shop/product/nozh-mr-blade-cosmo-sleipner-green-s-w\"]")
    WebElement knife;

    public KnifeBladeCosmoGreenStonewashPage chooseKnife() {
        wait.until(ExpectedConditions.visibilityOf(knife)).click();
        return new KnifeBladeCosmoGreenStonewashPage(driver);
    }
}
