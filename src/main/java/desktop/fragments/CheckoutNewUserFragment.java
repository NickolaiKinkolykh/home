package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutNewUserFragment extends AbstractFragment {
    @FindBy(xpath = ".//div[contains(@class,'checkout-page')]/div[@class='block-wrap']")
    private WebElement fragmentRootElement;

    private static final By NAME_FIELD = By.xpath(".//input[@name='emailAddress']");

    public CheckoutNewUserFragment() {
        setRootElement(fragmentRootElement);
    }

    public CheckoutNewUserFragment enterCustomerEmailAddress(String emailAddress) {
        setInputValue(NAME_FIELD, emailAddress);
        return  this;
    }

}
