package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KnifeBladeCosmoGreenStonewashPage {

    WebDriver driver;
    WebDriverWait wait;

    public KnifeBladeCosmoGreenStonewashPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
        this.driver = driver;
    }

    @FindBy(xpath = "h1[text()=\"Нож Mr. Blade Cosmo Green Stonewash\"]")
    private WebElement knifeTitle;
    @FindBy(css = ".product-buy__btn.product-buy__btn--buy")
    private WebElement byBtn;

    public void clickByBtn() {
        wait.until(ExpectedConditions.visibilityOf(byBtn)).click();
    }
}
