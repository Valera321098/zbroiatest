package pages;

import entities.GoodsTile;
import io.qameta.allure.Step;
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

    @Getter
    @FindBy(xpath = "//a[@class='product-cut__title-link']")
    private List<WebElement> knivesList;

    @Step("Buy a knife at the touch of 'BUY' button on the knife list")
    public CartWindow buyKnifeByTile(GoodsTile goodsTile) {
        clickElement(goodsTile.getBuyButton());
        return new CartWindow(driver);
    }

    @Step("Buy knife by name")
    public CartWindow buyKnifeByName(List<GoodsTile> knifeList, String name)  {
        GoodsTile knife = knifeList.stream().filter(x -> x.getGoodsName().contains(name)).findAny().orElse(null);
        clickElement(knife.getBuyButton());
        return new CartWindow(driver);
    }

    @Step("Get the number of elements in the list of knives")
    public int getKnivesListSize(){
        return knivesList.size();
    }

    @Step("Get random knife from knives list")
    public GoodsTile getRandomKnife() {
        List<GoodsTile> listKnife = getKnifeList();
        Random random = new Random();
        return listKnife.get(random.nextInt(listKnife.size()-1));
    }

    @Step("Click the knife and go to view knife page")
    public ViewGoodsPage chooseKnifeFromList(GoodsTile knife) {
        clickElement(knife.getViewLink());
        return new ViewGoodsPage(driver, knife.getGoodsName());
    }

    @Step("Click 'In cart' button")
    public CartWindow clickInCartButton(GoodsTile knife) {
        clickElement(knife.getInCartButton());
        return new CartWindow(driver);
    }

    @Step("Make a list of knives")
    public List<GoodsTile> getKnifeList(){
        return driver.findElements(By.cssSelector(".product-cut ")).stream().map(mapTile()).collect(Collectors.toList());
    }

    private Function<WebElement, GoodsTile> mapTile(){
        return tile -> GoodsTile.builder()
                .goodsName(tile.findElement(By.cssSelector(".product-cut__title-link")).getText())
                .viewLink(tile.findElement(By.cssSelector(".product-cut__title-link")))
                .price(tile.findElement(By.cssSelector(".product-price__item-value")).getText())
                .buyButton(tile.findElement(By.cssSelector(".product-cut-buy__btn.product-cut-buy__btn--buy")))
                .inCartButton(tile.findElement(By.cssSelector(".product-cut-buy__btn.product-cut-buy__btn--in-cart")))
                .build();
    }

}

