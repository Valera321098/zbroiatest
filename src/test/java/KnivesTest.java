import entities.KnifeTile;
import moduls.CatalogToolbar;
import pages.FoldingKnivesPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KnivesTest extends BaseTest {

    @Test
    public void chooseAndByFoldingKnife() {
        FoldingKnivesPage foldingKnivesPage = new FoldingKnivesPage(driver);
//        driver.get(testConfig.baseUrl());
//        driver.manage().window().maximize();
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
    public void boughtKnifeFromList() {
        FoldingKnivesPage foldingKnivesPage = new FoldingKnivesPage(driver);
        List<String> list = new ArrayList<>();

        driver.get("https://zbroia.com.ua/shop/category/nozhi-i-instrumenty/nozhi-skladnye-3879");
        driver.manage().window().maximize();
        Assert.assertEquals("Складные ножи — Интернет-магазин ZBROIA", driver.getTitle());

        foldingKnivesPage.catalogToolbar.selectNumberOfItemPerPage(CatalogToolbar.NumberOfItem.NUMBER_48);
        KnifeTile knife = foldingKnivesPage.getKnife();
        foldingKnivesPage
                .chooseKnifeFromList(knife)
                .checkoutKnife()
                .clickBuyBtn()
                .checkoutListByName(list);
    }

    @Test
    public void buySomeKnives() {

        FoldingKnivesPage foldingKnivesPage = new FoldingKnivesPage(driver);
        List<String> shoppingList = new ArrayList<>();
        KnifeTile knife;

        driver.get("https://zbroia.com.ua/shop/category/nozhi-i-instrumenty/nozhi-skladnye-3879");
        driver.manage().window().maximize();
        Assert.assertEquals("Складные ножи — Интернет-магазин ZBROIA", driver.getTitle());

        foldingKnivesPage.catalogToolbar.selectNumberOfItemPerPage(CatalogToolbar.NumberOfItem.NUMBER_48);
        for (int i = 0; i < 3 ; i++) {
            knife = foldingKnivesPage.getKnife();
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

}
