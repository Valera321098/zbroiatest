import entities.GoodsInCart;
import entities.GoodsTile;
import io.qameta.allure.Description;
import moduls.CatalogToolbar;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pages.FoldingKnivesPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KnivesTest extends BaseTest {


    @Description(value = "We can make sure that user can buys one knife from list and verifies that it is in the cart")
    @Test
    public void buySingleKnife() {
        FoldingKnivesPage foldingKnivesPage = new FoldingKnivesPage(driver);
        List<String> list = new ArrayList<>();

        goToFoldingKnives();
        foldingKnivesPage.catalogToolbar.selectNumberOfItemPerPage(CatalogToolbar.NumberOfItem.NUMBER_12);
        GoodsTile knife = foldingKnivesPage.getRandomKnife();
        foldingKnivesPage
                .chooseKnifeFromList(knife)
                .checkoutKnife()
                .clickBuyBtn()
                .checkoutListByName(list);
    }

    @Test
    @Description(value = "We can make sure that user can buys several random knives from list and verifies that its are in the cart")
    public void buySeveralKnives() {
        FoldingKnivesPage foldingKnivesPage = new FoldingKnivesPage(driver);
        List<String> shoppingList = new ArrayList<>();
        GoodsTile knife;
        Random random = new Random();

        goToFoldingKnives();
        foldingKnivesPage.catalogToolbar.selectNumberOfItemPerPage(CatalogToolbar.NumberOfItem.NUMBER_12);
        List<GoodsTile> knifeList = foldingKnivesPage.getKnifeList();
        for (int i = 0; i < 4; i++) {
            knife = knifeList.get(random.nextInt(knifeList.size() - 1));
            knifeList.remove(knife);
            shoppingList.add(knife.getGoodsName());
            foldingKnivesPage
                    .buyKnifeByTile(knife)
                    .clickContinueShopping();
        }
        header.openCart();
        cartWindow
                .isCartWindowDisplayed()
                .checkoutListByName(shoppingList)
                .clickCheckout();
    }

    @Test
    @Description(value = "The test buys knife by name")
    public void byKnifeByName() {
        FoldingKnivesPage foldingKnivesPage = new FoldingKnivesPage(driver);
        goToFoldingKnives();
        List<GoodsTile> knifeList = foldingKnivesPage.getKnifeList();
        foldingKnivesPage.buyKnifeByName(knifeList, "Cold Steel FGX Balisong Tanto");
    }

    @Test
    @Description(value = "Make sure that user can delete goods from cart")
    public void deleteItemFromCart() {
        FoldingKnivesPage foldingKnivesPage = new FoldingKnivesPage(driver);
        List<String> shoppingList = new ArrayList<>();
        goToFoldingKnives();
        foldingKnivesPage.catalogToolbar.selectNumberOfItemPerPage(CatalogToolbar.NumberOfItem.NUMBER_12);
        List<GoodsTile> knifeList = foldingKnivesPage.getKnifeList();

        knifeList.stream().limit(3).forEach(x -> {
            shoppingList.add(x.getGoodsName());
            foldingKnivesPage
                    .buyKnifeByTile(x)
                    .clickContinueShopping();
        });
        header.openCart();
        cartWindow
                .isCartWindowDisplayed()
                .checkoutListByName(shoppingList)
                .clickDeleteButton(1);
    }

    @Test
    @Description(value = "Make sure that user can click 'In Cart' button and goods is in the cart")
    public void clickInCardButton() {
        FoldingKnivesPage foldingKnivesPage = new FoldingKnivesPage(driver);
        goToFoldingKnives();
        List<GoodsTile>  knivesList = foldingKnivesPage.getKnifeList();
        GoodsTile knife = knivesList.stream().findAny().orElse(null);
        foldingKnivesPage
                .buyKnifeByTile(knife)
                .clickContinueShopping();
        foldingKnivesPage.clickInCartButton(knife);
    }

}
