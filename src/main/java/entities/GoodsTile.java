package entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;

@Getter
@Setter
@Builder
public class GoodsTile {
    String goodsName;
    String price;
    WebElement viewLink;
    WebElement buyButton;
    WebElement inCartButton;
}
