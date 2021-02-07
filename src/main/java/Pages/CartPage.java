package Pages;

import jdk.internal.org.objectweb.asm.util.CheckClassAdapter;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver)  {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"modal__header-title\"]")
    private WebElement cartTitle;
    @Getter
    @FindBy(linkText = "Нож Mr. Blade Cosmo Green Stonewash")
    private WebElement boughtKnife;
    @FindBy(linkText = "Оформить заказ")
    private WebElement checkoutBtn;

    public CartPage isCartPageDisplayed() {
         Assert.assertTrue(isElementDisplayed(cartTitle));
         return this;
    }

    public CartPage goodsInCart(WebElement element) {
        Assert.assertTrue(isElementDisplayed(element));
        return this;
    }

    public CheckoutPage clickCheckout() {
        clickElement(checkoutBtn);
        return new CheckoutPage(driver);
    }
}
