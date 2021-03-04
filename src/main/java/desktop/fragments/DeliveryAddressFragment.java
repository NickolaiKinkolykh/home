package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import driver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DeliveryAddressFragment extends AbstractFragment {

    @FindBy(xpath = ".//div[@id='deliveryAddress']")
    private WebElement fragmentRootElement;

    private static final By FULL_NAME_FIELD = By.xpath(".//input[@name='delivery-fullName']");
    private static final By DELIVERY_COUNTRY = By.cssSelector("#deliveryCountryDropdown");
    private static final By ENTER_ADDRESS_MANUALLY = By.cssSelector("#manualEntryDeliveryAddress");
    private static final By ADDRESS_LINE_1 = By.xpath(".//input[@name='delivery-addressLine1']");
    private static final By ADDRESS_LINE_2 = By.xpath(".//input[@name='delivery-addressLine2']");
    private static final By TOWN_CITY = By.xpath(".//input[@name='delivery-city']");
    private static final By COUNTRY_STATE = By.xpath(".//input[@name='delivery-county']");
    private static final By POSTCODE = By.xpath(".//input[@name='delivery-postCode']");
    private static final By DISABLED_PAYMENT_BUTTON =
            By.xpath(".//parent::form/parent::div/div[@class='disabled-container']" +
                    "//button[@name='buyNow']");
    private static final By PROCEED_TO_PAYMENT_BUTTON = By.xpath(".//parent::form//button[@id='hasSubmittedSameAddresses']");
    private static final String DISABLED = "Disabled";

    public DeliveryAddressFragment() {
        setRootElement(fragmentRootElement);
    }

    public DeliveryAddressFragment fillFullName(String value) {
        setInputValue(FULL_NAME_FIELD,value);
        return this;
    }

    public DeliveryAddressFragment selectCountry(String value) {
        //different type of handling selector - more common way
        clickElement(DELIVERY_COUNTRY);
        Select deliverySelect = new Select(getElement(DELIVERY_COUNTRY));
        deliverySelect.selectByVisibleText(value);
        return this;
    }

    public DeliveryAddressFragment clickEnterManuallyAddress() {
        clickElement(ENTER_ADDRESS_MANUALLY);
        return this;
    }

    public DeliveryAddressFragment fillAddressLine1(String value) {
        setInputValue(ADDRESS_LINE_1, value);
        return this;
    }

    public DeliveryAddressFragment fillAddressLine2(String value) {
        setInputValue(ADDRESS_LINE_2, value);
        return this;
    }

    public DeliveryAddressFragment fillTownCity(String value) {
        setInputValue(TOWN_CITY, value);
        return this;
    }

    public DeliveryAddressFragment fillCountryState(String value) {
        setInputValue(COUNTRY_STATE, value);
        return this;
    }

    public DeliveryAddressFragment fillPostcode(String value) {
        setInputValue(POSTCODE,value);
        return this;
    }

    public DeliveryAddressFragment proceedToPayment() {
        Actions action = new Actions(SingletonDriver.getDriver());
        action.moveToElement(getElement(PROCEED_TO_PAYMENT_BUTTON))
                .click()
                .build()
                .perform();
        return this;
    }

    public boolean isDisableAttributeExistOnPaymentButton() {
        return getElement(DISABLED_PAYMENT_BUTTON).getAttribute(DISABLED).equals("true");
    }
}
