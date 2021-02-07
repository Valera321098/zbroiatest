package Pages;

import Moduls.CatalogToolbar;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FoldingKnivesPage extends BasePage {

    public CatalogToolbar catalogToolbar;
//    List<WebElement> knivesList;

    public FoldingKnivesPage(WebDriver driver) {
        super(driver);
        catalogToolbar = new CatalogToolbar(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href=\"https://zbroia.com.ua/shop/product/nozh-mr-blade-cosmo-sleipner-green-s-w\"]")
    WebElement knife;
    @Getter
    @FindBy(xpath = "//a[@class=\"product-cut__title-link\"]")
    private List<WebElement> knivesList;

    public KnifeBladeCosmoGreenStonewashPage chooseKnife() {
        clickElement(knife);
        return new KnifeBladeCosmoGreenStonewashPage(driver);
    }

    public int getKnivesListSize(){
        return knivesList.size();
    }

    public WebElement getKnife(int number) {
        if (number < knivesList.size()) {
            return knivesList.get(number);
        } else {
            return knivesList.get(0);
        }
    }

    public ViewKnifePage chooseKnifeFromList(WebElement element) {
        String knifeTitle = element.getText();
        clickElement(element);
        return new ViewKnifePage(driver, knifeTitle);
    }
}
