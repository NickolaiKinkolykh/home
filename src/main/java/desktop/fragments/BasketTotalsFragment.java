package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketTotalsFragment extends AbstractFragment {
    @FindBy(css = ".basket-totals-wrap")
    private WebElement fragmentRootElement;

    private static final By DELIVERY_OPTION = By.cssSelector("dl.delivery-text dd");
    private static final By TOTAL = By.cssSelector("dl.total dd");
    private static final By CHECKOUT_BUTTON = By.cssSelector(".checkout-btns-wrap a");

    public BasketTotalsFragment() {
        setRootElement(fragmentRootElement);
    }

    public String getTotalPrice(){
        return getElementText(TOTAL);
    }

    public String getDeliveryType() {
        return getElementText(DELIVERY_OPTION);
    }

    public BasketTotalsFragment clickOnCheckoutButton() {
        clickElement(CHECKOUT_BUTTON);
        return this;
    }
}
