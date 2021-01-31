package Moduls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;
    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver= driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 20);
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

    public Header openSignUpDialog() {
        actions.moveToElement(menuInner).perform();
        wait.until(ExpectedConditions.visibilityOf(innerItem));
        innerItem.click();
        return new Header(driver);
    }

    public Header inputLogin(String userEmail) {
        emailField.sendKeys(userEmail);
        return new Header(driver);
    }

    public Header inputPassword(String userPassword) {
        passwordField.sendKeys(userPassword);
        return new Header(driver);
    }

    public void submitLogin() {
        submitLoginBtn.click();
    }

//    public boolean isLogined() {
//        wait.until(ExpectedConditions.(logoutItem));
//        return true;
//    }

}
