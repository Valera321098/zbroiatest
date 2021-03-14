package pages;

import entities.GoodsInCart;
import entities.GoodsTile;
import io.qameta.allure.Step;
import lombok.Getter;


import org.assertj.core.api.Assertions;
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

    @FindBy(css = ".modal--lg")
    private WebElement cart;
    @Getter
    @FindBy(css = ".btn-primary")
    private WebElement checkoutButton;
    @FindBy(css = "button[type='reset'")
    private  WebElement continueShoppingButton;

    @Step("Check the cart window is displayed")
    public CartWindow isCartWindowDisplayed() {
        Assertions.assertThat(isElementDisplayed(cart)).isTrue();
         return this;
    }

    @Step("Check the goods is in the cart")
    public CartWindow goodsInCart(WebElement element) {
        Assertions.assertThat(isElementDisplayed(element)).isTrue();
        return this;
    }

    @Step("Click checkout button and go to checkout page")
    public CheckoutPage clickCheckout() {
        clickElement(checkoutButton);
        return new CheckoutPage(driver);
    }

    @Step("Click continue shopping button and back to knives list")
    public void clickContinueShopping() {
        clickElement(continueShoppingButton);
    }

    @Step("Checkout goods list in the cart")
    public CartWindow checkoutListByName(List<String> listGoodsName) {
        List<GoodsInCart> goodsInCart = getListOfGoodsInCart();
        Set<String> goodsInCartName = new HashSet<>();
        goodsInCart.stream().forEach(x -> goodsInCartName.add(x.getGoodsName()));
        Assertions.assertThat(goodsInCartName.containsAll(listGoodsName)).isTrue();
        return this;
    }

    @Step("Check the goods is in the cart")
    public CartWindow checkOneGoodsIsInCart(GoodsTile oneGoods) {
        List<String> goodsNameList = getListOfGoodsInCart().stream().map(x -> x.getGoodsName()).collect(Collectors.toList());
        Assertions.assertThat(goodsNameList.contains(oneGoods.getGoodsName())).isTrue();
        return this;
    }

    @Step("Delete goods from cart")
    public CartWindow clickDeleteButton(int item) {
        List<GoodsInCart> goodsList = getListOfGoodsInCart();
        GoodsInCart g = goodsList.get(item);
        g.getDeleteButton().click();
        isNotGoodsInCart(g);
        return this;
    }

    @Step("Check that element is not in cart")
    public CartWindow isNotGoodsInCart(GoodsInCart goods) {
        List<GoodsInCart> goodsList = getListOfGoodsInCart();
        Assertions.assertThat(!goodsList.contains(goods)).isTrue();
        return this;
    }

    @Step("Make goods list from the cart")
    public List<GoodsInCart> getListOfGoodsInCart() {
        return driver.findElements(By.cssSelector(".cart-summary__row")).stream().map(mapCart()).collect(Collectors.toList());
    }

    private Function<WebElement, GoodsInCart> mapCart()  {
        return cart -> GoodsInCart.builder()
                .goodsName(cart.findElement(By.cssSelector(".cart-product__link")).getText())
                .brand(cart.findElement(By.cssSelector(".cart-product__brand")).getText())
                .price(cart.findElement(By.cssSelector(".cart-price__main-value")).getText())
                .viewLink(cart.findElement(By.cssSelector(".cart-product__link")))
                .deleteButton(cart.findElement(By.cssSelector(".cart-summary__delete")))
                .quantity(cart.findElement(By.cssSelector(".form-input__control--quantity")).getAttribute("value"))
                .minusButton(cart.findElement(By.cssSelector(".form-input__group-btn[data-form-quantity-control='minus']")))
                .plusButton(cart.findElement(By.cssSelector(".form-input__group-btn[data-form-quantity-control='plus']")))
                .build();
    }
}
