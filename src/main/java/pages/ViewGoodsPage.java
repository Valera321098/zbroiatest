package pages;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewGoodsPage extends BasePage {

    public ViewGoodsPage(WebDriver driver, String goodsTitle) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.goodsTitle = goodsTitle;
    }

    String goodsTitle;
    @FindBy(xpath = "//h1[@class='content__title']")
    private WebElement pageTitle;
    @FindBy(css = ".product-buy__btn.product-buy__btn--buy")
    private WebElement byBtn;

    @Step("Click 'Buy' button")
    public CartWindow clickBuyBtn() {
        clickElement(byBtn);
        return new CartWindow(driver);
    }

    @Step("Check the opened page have the correct goods")
    public ViewGoodsPage checkoutKnife() {
        Assertions.assertThat(goodsTitle).isEqualTo(pageTitle.getText());
        return this;
    }
}
