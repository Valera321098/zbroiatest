package pages;

import entities.KnifeTile;
import moduls.CatalogToolbar;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FoldingKnivesPage extends BasePage {

    public CatalogToolbar catalogToolbar;

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

    public CartWindow buyKnifeFromList(KnifeTile knifeTile) {
        clickElement(knifeTile.getBuyButton());
        return new CartWindow(driver);
    }

    public int getKnivesListSize(){
        return knivesList.size();
    }

    public KnifeTile getKnife() {
        List<KnifeTile> listKnife = getListOfKnives();
        Random random = new Random();
        return listKnife.get(random.nextInt(listKnife.size()-1));
    }

    public ViewKnifePage chooseKnifeFromList(KnifeTile knife) {
        clickElement(knife.getViewLink());
        return new ViewKnifePage(driver, knife.getKnifeName());
    }

    public List<KnifeTile> getListOfKnives(){
        return driver.findElements(By.cssSelector(".product-cut ")).stream().map(mapTile()).collect(Collectors.toList());
    }

    private Function<WebElement, KnifeTile> mapTile(){
        return tile -> KnifeTile.builder()
                .knifeName(tile.findElement(By.cssSelector(".product-cut__title-link")).getText())
                .viewLink(tile.findElement(By.cssSelector(".product-cut__title-link")))
                .price(tile.findElement(By.cssSelector(".product-price__item-value")).getText())
                .buyButton(tile.findElement(By.cssSelector(".product-buy")))
                .build();
    }
}

