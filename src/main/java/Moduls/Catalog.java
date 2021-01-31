package Moduls;

import Pages.FoldingKnivesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Catalog {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    public Catalog(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
        actions = new Actions(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class=\"uh__main-menu__button\"]")
    private WebElement catalog;
    @FindBy(xpath = "//a[@href=\"https://zbroia.com.ua/shop/category/nozhi-i-instrumenty-3467\"]")
    private WebElement knifeAndInstrument;
        @FindBy(xpath = "//a[@href=\"https://zbroia.com.ua/shop/category/nozhi-i-instrumenty/nozhi-skladnye-3879\"]")
        private WebElement foldingKnives;

    public Catalog chooseKnifeMenu() {
        wait.until(ExpectedConditions.visibilityOf(catalog));
        actions.moveToElement(catalog).moveToElement(knifeAndInstrument).build().perform();
        return new Catalog(driver);
    }

    public FoldingKnivesPage chooseFoldingKnives() {
        wait.until(ExpectedConditions.visibilityOf(foldingKnives)).click();
        return new FoldingKnivesPage(driver);
    }
}
