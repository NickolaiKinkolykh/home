package stepDefs;

import desktop.fragments.*;
import dto.CardDerailsDto;
import dto.DeliveryAddressDto;
import dto.MiniBasketDto;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutSteps {

    CheckoutNewUserFragment checkoutNewUserFragment = new CheckoutNewUserFragment();
    MiniBasketFragment miniBasketFragment = new MiniBasketFragment();
    DeliveryAddressFragment deliveryAddressFragment = new DeliveryAddressFragment();
    PaymentFragment paymentFragment = new PaymentFragment();
    PayContainerFragment payContainerFragment = new PayContainerFragment();

    @And("I checkout as a new customer with email {string}")
    public void iCheckoutAsANewCustomerWithEmail(String userNewEmail) {
        checkoutNewUserFragment.enterCustomerEmailAddress(userNewEmail);
    }

    @And("Checkout order summary is as following:")
    public void checkoutOrderSummaryIsAsFollowing(MiniBasketDto miniBasketDto) {
        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(miniBasketDto.subTotal).as("Sub-total is incorrect")
                .isEqualTo(miniBasketFragment.getSubTotalValue());
        soft.assertThat(miniBasketDto.delivery).as("Delivery type is incorrect")
                .isEqualTo(miniBasketFragment.getDeliveryValue());
        soft.assertThat(miniBasketDto.vat).as("VAT value is incorrect")
                .isEqualTo(miniBasketFragment.getVatValue());
        soft.assertThat(miniBasketDto.total).as("Total value is incorrect")
                .isEqualTo(miniBasketFragment.getTotalValue());
        soft.assertAll();
    }

    @And("I fill delivery address information manually:")
    public void iFillDeliveryAddressInformationManually(DeliveryAddressDto deliveryAddressDto) {
        deliveryAddressFragment.fillFullName(deliveryAddressDto.fullName)
                .selectCountry(deliveryAddressDto.deliveryCountry)
                .clickEnterManuallyAddress()
                .fillAddressLine1(deliveryAddressDto.addressLine1)
                .fillAddressLine2(deliveryAddressDto.addressLine2)
                .fillTownCity(deliveryAddressDto.townCity)
                .fillCountryState(deliveryAddressDto.countryState)
                .fillPostcode(deliveryAddressDto.postcode);

    }

    @And("I enter my card details")
    public void iEnterMyCardDetails(@Transpose CardDerailsDto cardDerailsDto) {
        paymentFragment.switchToIFrame();
        payContainerFragment.setMasterCardType()
                .setCartNumber(cardDerailsDto.cardNumber)
                .setMonth(cardDerailsDto.expiryMonth)
                .setYear(cardDerailsDto.expiryYear)
                .setNameOnCard(cardDerailsDto.nameOnCard)
                .setCvvField(cardDerailsDto.cvv)
                .clickSubmitPayment();

    }

    @And("'Payment' section is disabled for editing")
    public void paymentSectionIsDisabledForEditing() {
        assertThat(deliveryAddressFragment.isDisableAttributeExistOnPaymentButton())
                .as("Button does not contains disable attribute").isTrue();
    }

    @When("I press 'Continue to payment' button on checkout")
    public void iPressContinueToPaymentButtonOnCheckout() {
        deliveryAddressFragment.proceedToPayment();
    }

    @And("'Delivery Address' and 'Billing Address' sections are disabled for editing")
    public void deliveryAddressAndBillingAddressSectionsAreDisabledForEditing() {
        assertThat(paymentFragment.checkThatAddressFormIsDisabled()).as("").isTrue();
    }
}
