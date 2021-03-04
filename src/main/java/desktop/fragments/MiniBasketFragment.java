package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MiniBasketFragment extends AbstractFragment {
    @FindBy(css = ".sidebar.right")
    private WebElement fragmentRootElement;

    private static final By SUB_TOTAL = By.cssSelector(".mini-basket div.wrapper dl:nth-child(2) dd");
    private static final By DELIVERY = By.cssSelector(".mini-basket div.wrapper dl:nth-child(3) dd");
    private static final By VAT = By.cssSelector(".mini-basket div.wrapper dl:nth-child(4) dd");
    private static final By TOTAL = By.cssSelector(".mini-basket div.wrapper dl:nth-child(5) dd");

    public MiniBasketFragment() {
        setRootElement(fragmentRootElement);
    }

    public String getSubTotalValue(){
        return getElementText(SUB_TOTAL);
    }

    public String getDeliveryValue() {
        return getElementText(DELIVERY);
    }

    public String getVatValue() {
        return getElementText(VAT);
    }

    public String getTotalValue() {
        return getElementText(TOTAL);
    }
}
