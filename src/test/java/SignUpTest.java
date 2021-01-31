import Moduls.Catalog;
import Moduls.CatalogToolbar;
import Moduls.Footer;
import Moduls.Header;
import Pages.FoldingKnivesPage;
import org.junit.Test;
import org.openqa.selenium.By;

public class SignUpTest extends WebDriverSettings {

//    //Игорь
//    //igor123@gmail.com
//    //0997775533
//    //igor1234
//    //igor1234
    Header header;
    Footer footer;
    Catalog catalog;
    FoldingKnivesPage foldingKnivesPage;

    @Test
    public void signUpPositiveTest() {
        String userEmail = "igor123@gmail.com";
        String userPassword = "igor1234";

        driver.get("https://www.zbroia.com.ua");
        header = new Header(driver);
        footer = new Footer(driver);
        driver.manage().window().maximize();
        header
                .openSignUpDialog()
                .inputLogin(userEmail)
                .inputPassword(userPassword)
                .submitLogin();
        footer.isLogined();
    }

    @Test
    public void chooseAndByFoldingKnife() {
        driver.get("https://www.zbroia.com.ua");
        driver.manage().window().maximize();
        catalog = new Catalog(driver);
        foldingKnivesPage = catalog.chooseKnifeMenu().chooseFoldingKnives();
        foldingKnivesPage.selectCatalogSort(CatalogToolbar.CatalogSort.PRICE_DESC);
        foldingKnivesPage.chooseKnife().clickByBtn();
    }

}
