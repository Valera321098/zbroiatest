package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewKnifePage extends BasePage {

    public ViewKnifePage(WebDriver driver, String knifeTitle) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.knifeTitle = knifeTitle;
    }

    String knifeTitle;
    @FindBy(xpath = "//h1[@class=\"content__title\"]")
    private WebElement pageTitle;

    public ViewKnifePage checkoutKnife() {
        Assert.assertEquals(knifeTitle, pageTitle.getText());
        System.out.println(knifeTitle);
        return this;
    }
}
