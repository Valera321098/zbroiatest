package moduls;

import io.qameta.allure.Step;
import pages.BasePage;
import pages.FoldingKnivesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Catalog extends BasePage {

    public Catalog(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class=\"uh__main-menu__button\"]")
    private WebElement catalogMenu;
    @FindBy(xpath = "//a[@href=\"https://zbroia.com.ua/shop/category/nozhi-i-instrumenty-3467\"]")
    private WebElement knifeAndInstrument;
    @FindBy(xpath = "//a[@href=\"https://zbroia.com.ua/shop/category/nozhi-i-instrumenty/nozhi-skladnye-3879\"]")
    private WebElement foldingKnives;

    @Step("Choose knife menu")
    public Catalog chooseKnifeMenu() {
        waitElement(catalogMenu);
        actions.moveToElement(catalogMenu).moveToElement(knifeAndInstrument).build().perform();
        return this;
    }

    @Step("Choose folding knives page")
    public FoldingKnivesPage chooseFoldingKnives() {
        clickElement(foldingKnives);
        return new FoldingKnivesPage(driver);
    }
}
