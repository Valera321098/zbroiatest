import Moduls.CatalogToolbar;
import Pages.FoldingKnivesPage;
import org.junit.Assert;
import org.junit.Test;

public class SignUpTest extends BaseTest {

    FoldingKnivesPage foldingKnivesPage;

    @Test
    public void signUpPositiveTest() {

        driver.get(testConfig.baseUrl());
        driver.manage().window().maximize();
        header
                .openSignUpDialog()
                .inputLogin(testConfig.email())
                .inputPassword(testConfig.password())
                .submitLogin();
        Assert.assertTrue(footer.isLogined());
    }

    @Test
    public void chooseAndByFoldingKnife() {
//        driver.get(testConfig.baseUrl());
//        driver.manage().window().maximize();
        foldingKnivesPage = catalog.chooseKnifeMenu().chooseFoldingKnives();
        foldingKnivesPage.catalogToolbar.selectCatalogSort(CatalogToolbar.CatalogSort.PRICE_DESC);
//        catalogToolbar.selectCatalogSort(CatalogToolbar.CatalogSort.PRICE_DESC);
        foldingKnivesPage
                .chooseKnife()
                .clickByBtn()
                .isCartPageDisplayed()
                .goodsInCart(cartPage.getBoughtKnife())
                .clickCheckout()
                .isCheckoutPageDisplayed();
//        cartPage.goodsInCart(cartPage.getBoughtKnife());
    }

    @Test
    public void test() {
        signUpPositiveTest();
        chooseAndByFoldingKnife();
    }

//    @Test
//    public void test2() {
//        driver.get("https://zbroia.com.ua/shop/cart");
//        driver.manage().window().maximize();
//        System.out.println(driver.getTitle());
//        if (driver.getTitle().equals("Корзина")) {
//            System.out.println("Ok!");
//        }
//    }

}
