package moduls;

import pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage {

    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.list-nav__link[href=\"https://zbroia.com.ua\"]")
    private WebElement navLinkMain;
    @FindBy(css = "a.list-nav__link[href=\"https://zbroia.com.ua/o-nas\"]")
    private WebElement navLinkOnas;
    @FindBy(css = "a.list-nav__link[href=\"https://zbroia.com.ua/kontaktnaia-informatsiia\"]")
    private WebElement navLinkContact;
    @FindBy(css = "a.list-nav__link[href=\"https://zbroia.com.ua/delivery\"]")
    private WebElement navLinkDelivery;
    @FindBy(css = "a.list-nav__link[href=\"https://zbroia.com.ua/magaziny\"]")
    private WebElement navLinkShops;

    @FindBy(xpath = "//div[@class=\"uh__main-menu__button\"]")
    private WebElement menuCatalog;
    @FindBy(xpath = "//a[@href=\"https://zbroia.com.ua/news\"]")
    private WebElement menuNews;
    @FindBy(xpath = "//a[@href=\"https://zbroia.com.ua/media\"]")
    private WebElement menuMedia;

    @FindBy(xpath = "//button[@class=\"btn-search-new btn btn-default\"]")
    private WebElement searchBtn;
    @FindBy(xpath = "//input[@class=\"search-denys form-control ui-autocomplete-input\"]")
    private WebElement searchInput;

    @FindBy(xpath = "//span[@class=\"u-p-zbroia__item-inner u\"]")
    private WebElement menuInner;
    @FindBy(xpath = "//span[@class=\"u-p-zbroia__item-inner u\"]//a[@href=\"https://zbroia.com.ua/auth\"]")
    private WebElement innerItem;
    @FindBy(xpath = "//span[@class=\"u-p-zbroia__item-inner u\"]//a[@href=\"https://zbroia.com.ua/auth/register\"]")
    private WebElement registerItem;
    @FindBy(xpath = "//div[@class=\"mfp-content\"]")
    WebElement loginForm;
    @FindBy(css = "input[name=\"email\"]")
    WebElement emailField;
    @FindBy(css = "input[name=\"password\"]")
    WebElement passwordField;
    @FindBy(css = "input[value=\"Войти\"]")
    WebElement submitLoginBtn;
    @FindBy(css = "button[type=\"reset\"]")
    WebElement closeLoginBtn;
    @FindBy(css = "a.overlay__link[href=\"https://zbroia.com.ua/auth/logout\"]")
    WebElement logoutItem;

    @FindBy(xpath = "//a[@class=\"under-header__item-link\"]")
    private WebElement menuCompare;
    @FindBy(xpath = "//div[@data-ajax-inject=\"cart-header\"]")
    private WebElement menuCart;
    @FindBy(css = ".u-p-zbroia__cart-subtitle-title")
    private WebElement numberItemInCart;

    public void openCart() {
        if (!numberItemInCart.getText().equals("0")) {
            clickElement(menuCart);
        }
    }

    public Header openSignUpDialog() {
        actions.moveToElement(menuInner).perform();
        clickElement(innerItem);
        return this;
    }

    public Header inputLogin(String userEmail) {
        emailField.sendKeys(userEmail);
        return this;
    }

    public Header inputPassword(String userPassword) {
        passwordField.sendKeys(userPassword);
        return this;
    }

    public void submitLogin() {
        clickElement(submitLoginBtn);
    }


}
