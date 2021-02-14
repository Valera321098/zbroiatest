package entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;

@Getter
@Setter
@Builder
public class KnifeTile {
    String knifeName;
    String price;
    WebElement viewLink;
    WebElement buyButton;
}
