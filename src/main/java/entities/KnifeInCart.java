package entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;

@Builder
@Getter
@Setter
public class KnifeInCart {
    private String knifeName;
    private String price;
    private WebElement viewLink;
}
