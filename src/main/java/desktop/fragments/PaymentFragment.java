package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import driver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PaymentFragment extends AbstractFragment {
    @FindBy(xpath = ".//div[@class='chase-container']/div[@class='iframe-container']")
    private WebElement fragmentRootElement;

    private static final By PAYMENT_IFRAME = By.cssSelector("iframe.global-checkout-chase");
    //not an issue with div[@class='block-overlay '] space was made in promise
    private static final By DISABLED_ADDRESS_BLOCK = By.xpath(".//parent::div/parent::div//div[@class='block-overlay ']");


    public PaymentFragment() {
        setRootElement(fragmentRootElement);
    }

    public PaymentFragment switchToIFrame() {
        wait.pollingEvery(Duration.ofSeconds(2))
                .withTimeout(Duration.ofSeconds(30))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.presenceOfElementLocated(PAYMENT_IFRAME));
        SingletonDriver.getDriver().switchTo().frame(getElement(PAYMENT_IFRAME));
        return this;
    }

    public boolean checkThatAddressFormIsDisabled() {
        return getElement(DISABLED_ADDRESS_BLOCK).getAttribute("onclick").equals("showDeliveryAddress();");
    }
}
