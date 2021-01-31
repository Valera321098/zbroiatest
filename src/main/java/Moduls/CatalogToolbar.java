package Moduls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogToolbar {

    WebDriver driver;
    WebDriverWait wait;

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
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
        this.driver = driver;
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
