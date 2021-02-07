package Moduls;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogToolbar extends BasePage {

    public enum CatalogSort {
        ACTION("action"),
        PRICE("price"),
        PRICE_DESC("price_desc"),
        HIT("hit"),
        HOT("hot"),
        NAME("name");
        private String action;
        CatalogSort(String action) {
            this.action = action;
        }
        public String getAction() {
            return action;
        }
    }

    public CatalogToolbar(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="catalog-sort-by")
    private WebElement catalogSortBy;

    @FindBy(id="catalog-per-page")
    private WebElement catalogPerPage;

    public void selectCatalogSort(CatalogSort catalogSort) {
        Select select = new Select(catalogSortBy);
        select.selectByValue(catalogSort.getAction());
    }
}
