package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KnifeBladeCosmoGreenStonewashPage extends BasePage{

    public KnifeBladeCosmoGreenStonewashPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "h1[text()=\"Нож Mr. Blade Cosmo Green Stonewash\"]")
    private WebElement knifeTitle;
    @FindBy(css = ".product-buy__btn.product-buy__btn--buy")
    private WebElement byBtn;

    public CartWindow clickBuyBtn() {
        clickElement(byBtn);
        return new CartWindow(driver);
    }
}
