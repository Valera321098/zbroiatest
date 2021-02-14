package pages;

import entities.KnifeInCart;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CartWindow extends BasePage{
    public CartWindow(WebDriver driver)  {
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
    @FindBy(xpath = "//button[text()='Продолжить покупки']")
    private  WebElement continueShopping;

    public CartWindow isCartWindowDisplayed() {
         Assert.assertTrue(isElementDisplayed(cartTitle));
         return this;
    }

    public CartWindow goodsInCart(WebElement element) {
        Assert.assertTrue(isElementDisplayed(element));
        return this;
    }

    public CheckoutPage clickCheckout() {
        clickElement(checkoutBtn);
        return new CheckoutPage(driver);
    }

    public void clickContinueShopping() {
        clickElement(continueShopping);
    }

    public CartWindow checkoutListByName(List<String> listKnifeName) {
        List<KnifeInCart>  knifeInCart = getListOfKnivesInCart();
        Set<String> knifeInCartName = new HashSet<>();
        knifeInCart.stream().forEach(x -> knifeInCartName.add(x.getKnifeName()));
        Assert.assertTrue(knifeInCartName.containsAll(listKnifeName));
        return this;
    }

    public List<KnifeInCart> getListOfKnivesInCart() {
        return driver.findElements(By.cssSelector(".cart-summary__row")).stream().map(mapCart()).collect(Collectors.toList());
    }

    private Function<WebElement, KnifeInCart> mapCart()  {
        return cart -> KnifeInCart.builder()
                .knifeName(cart.findElement(By.cssSelector(".cart-product__link")).getText())
                .price(cart.findElement(By.cssSelector(".cart-price__main-value")).getText())
                .viewLink(cart.findElement(By.cssSelector(".cart-product__link")))
                .build();
    }
}
