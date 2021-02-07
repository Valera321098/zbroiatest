import Moduls.CatalogToolbar;
import Pages.FoldingKnivesPage;
import org.junit.Assert;
import org.junit.Test;

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
                .clickByBtn()
                .isCartPageDisplayed()
                .goodsInCart(cartPage.getBoughtKnife())
                .clickCheckout()
                .isCheckoutPageDisplayed();
    }

    @Test
    public void test() {
        driver.get("https://zbroia.com.ua/shop/category/nozhi-i-instrumenty/nozhi-skladnye-3879");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        FoldingKnivesPage foldingKnivesPage = new FoldingKnivesPage(driver);
        System.out.println(foldingKnivesPage.getKnivesListSize());
        System.out.println(foldingKnivesPage.getKnife(1).getText());
    }

}
