package desktop.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.withText;
import static utils.WebDriverUtils.executeScript;


public class PayContainerFragment extends PaymentFragment{
    @FindBy(css = "#payInputContainer")
    private WebElement fragmentRootElement;

    public PayContainerFragment() {
        setRootElement(fragmentRootElement);
    }

    private static final String CARD_TYPE = "#brandSelected";
    private static final String CARD_FIELD = "#visacardNumber";
    private static final String MONTH_FIELD= "#mastercardValidToMonth";
    private static final String YEAR_FIELD= "#mastercardValidToYear";
    private static final String HOLDER_NAME_ON_CARD_FIELD= "#mastercardName";
    private static final String CVV_FIELD= "#mastercardCvv";
    private static final String SUBMIT_PAYMENT = "#submitButton";

    private static final String MASTERCARD = "MasterCard";


    public PayContainerFragment setCartNumber(String cardNumber) {
        executeScript("$('"+CARD_FIELD+"').val('"+cardNumber+"')");
        return this;
    }

    public PayContainerFragment setNameOnCard(String cardHolderName) {
        executeScript("$('"+HOLDER_NAME_ON_CARD_FIELD+"').val('"+cardHolderName+"')");
        return this;
    }

    public PayContainerFragment setCvvField(String cvv) {
        executeScript("$('"+CVV_FIELD+"').val('"+cvv+"')");
        return this;
    }

    public PayContainerFragment setMasterCardType() {
        getElement(By.cssSelector(CARD_TYPE)).find(withText(MASTERCARD)).click();
        return this;
    }

    public PayContainerFragment setMonth(String month) {
        getElement(By.cssSelector(MONTH_FIELD)).find(withText(month)).click();
        return this;
    }

    public PayContainerFragment setYear(String year) {
        getElement(By.cssSelector(YEAR_FIELD)).find(withText(year)).click();
        return this;
    }

    public PayContainerFragment clickSubmitPayment() {
        executeScript("$('"+SUBMIT_PAYMENT+"').click()");
        return this;
    }
}
