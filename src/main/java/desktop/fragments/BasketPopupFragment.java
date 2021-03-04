package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class BasketPopupFragment extends AbstractFragment {

    @FindBy(css = ".modal-content")
    private WebElement fragmentRootElement;

    public BasketPopupFragment() {
        setRootElement(fragmentRootElement);
    }

    private static final String BASKET_POPUP_BUTTON = ".//a[.='%s']";

    public BasketPopupFragment waitUntilPopUpAppeared(){
        wait.pollingEvery(Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(getRootElement()));
        return this;
    }

    public BasketPopupFragment clickCheckoutButton(String buttonName) {
        clickElement(xpath(format(BASKET_POPUP_BUTTON, buttonName)));
        return this;
    }
}
