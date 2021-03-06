package moduls;

import io.qameta.allure.Step;
import pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CatalogToolbar extends BasePage {

    public enum NumberOfItem {
        NUMBER_12("12"),
        NUMBER_24("24"),
        NUMBER_48("48");
        private String action;
        NumberOfItem(String action) {
            this.action = action;
        }
        public String getAction() {
            return action;
        }
    }

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
    private WebElement catalogNumberOfItemPerPage;

    @Step("Select sort goods catalog")
    public void selectCatalogSort(CatalogSort catalogSort) {
        Select select = new Select(catalogSortBy);
        select.selectByValue(catalogSort.getAction());
    }

    @Step("Select number of item per page")
    public void selectNumberOfItemPerPage(NumberOfItem numbrOfItem) {
        Select select = new Select(catalogNumberOfItemPerPage);
        select.selectByValue(numbrOfItem.getAction());
    }
}
