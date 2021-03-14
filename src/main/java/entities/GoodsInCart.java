package entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;

@Builder
@Getter
@Setter
public class GoodsInCart {
    private String goodsName;
    private String brand;
    private String price;
    private WebElement viewLink;
    private WebElement deleteButton;
    private String quantity;
    private WebElement minusButton;
    private WebElement plusButton;
}
