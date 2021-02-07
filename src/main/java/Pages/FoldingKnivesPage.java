package Pages;

import Moduls.CatalogToolbar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FoldingKnivesPage extends BasePage {

    public CatalogToolbar catalogToolbar;

    public FoldingKnivesPage(WebDriver driver) {
        super(driver);
        catalogToolbar = new CatalogToolbar(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href=\"https://zbroia.com.ua/shop/product/nozh-mr-blade-cosmo-sleipner-green-s-w\"]")
    WebElement knife;

    public KnifeBladeCosmoGreenStonewashPage chooseKnife() {
        clickElement(knife);
        return new KnifeBladeCosmoGreenStonewashPage(driver);
    }
}
