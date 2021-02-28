import entities.KnifeTile;
import io.qameta.allure.Description;
import moduls.CatalogToolbar;
import pages.FoldingKnivesPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KnivesTest extends BaseTest {

    @Test
    @Description (value = "The test login, buys knife 'Mr. Blade Cosmo Green Stonewash' and check that it is in the cart")
    public void chooseAndBuyFoldingKnife() {
        FoldingKnivesPage foldingKnivesPage = new FoldingKnivesPage(driver);

        login();

        foldingKnivesPage = catalog.chooseKnifeMenu().chooseFoldingKnives();
        foldingKnivesPage.catalogToolbar.selectCatalogSort(CatalogToolbar.CatalogSort.PRICE_DESC);
        foldingKnivesPage
                .chooseKnife()
                .clickBuyBtn()
                .isCartWindowDisplayed()
                .goodsInCart(cartWindow.getBoughtKnife())
                .clickCheckout()
                .isCheckoutPageDisplayed();
    }

    @Test
    @Description (value = "The test buys one random knife from list and verifies that it is in the cart")
    public void buySingleKnife() {
        FoldingKnivesPage foldingKnivesPage = new FoldingKnivesPage(driver);
        List<String> list = new ArrayList<>();

        goToFoldingKnives();

        foldingKnivesPage.catalogToolbar.selectNumberOfItemPerPage(CatalogToolbar.NumberOfItem.NUMBER_12);
        KnifeTile knife = foldingKnivesPage.getRandomKnife();
        foldingKnivesPage
                .chooseKnifeFromList(knife)
                .checkoutKnife()
                .clickBuyBtn()
                .checkoutListByName(list);
    }

    @Test
    @Description (value = "The test buys several random knives from list and verifies that its are in the cart")
    public void buySeveralKnives() {

        FoldingKnivesPage foldingKnivesPage = new FoldingKnivesPage(driver);
        List<String> shoppingList = new ArrayList<>();
        KnifeTile knife;
        Random random = new Random();

        goToFoldingKnives();

        foldingKnivesPage.catalogToolbar.selectNumberOfItemPerPage(CatalogToolbar.NumberOfItem.NUMBER_12);
        List<KnifeTile> knifeList = foldingKnivesPage.getKnifeList();
        for (int i = 0; i < 5; i++) {
            knife = knifeList.get(random.nextInt(knifeList.size()-1));
            knifeList.remove(knife);
            shoppingList.add(knife.getKnifeName());
            foldingKnivesPage
                    .buyKnifeFromList(knife)
                    .clickContinueShopping();
        }
        header.openCart();
        cartWindow
                .isCartWindowDisplayed()
                .checkoutListByName(shoppingList)
                .clickCheckout();

    }

    @Test
    @Description (value = "The test buys knife by name")
    public void testByKnifeByName() {
        FoldingKnivesPage foldingKnivesPage = new FoldingKnivesPage(driver);
        goToFoldingKnives();
        List<KnifeTile> knifeList = foldingKnivesPage.getKnifeList();
        foldingKnivesPage.buyKnifeByName(knifeList, "Cold Steel FGX Balisong Tanto");
    }

}
