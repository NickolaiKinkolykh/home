package stepDefs;

import desktop.fragments.BasketTotalsFragment;
import dto.BasketSummaryDto;
import io.cucumber.java.en.And;
import org.assertj.core.api.SoftAssertions;

public class BasketSteps {
    BasketTotalsFragment basketTotalsFragment = new BasketTotalsFragment();

    @And("Basket order summary is as following:")
    public void basketOrderSummaryIsAsFollowing(BasketSummaryDto basketSummaryDto) {
        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(basketSummaryDto.deliveryCost).as("delivery type is incorrect")
                .isEqualTo(basketTotalsFragment.getDeliveryType());
        soft.assertThat(basketSummaryDto.total).as("delivery type is incorrect")
                .isEqualTo(basketTotalsFragment.getTotalPrice());
        soft.assertAll();
    }

    @And("I click 'Checkout' button on 'Basket' page")
    public void iClickCheckoutButtonOnBasketPage() {
        basketTotalsFragment.clickOnCheckoutButton();
    }
}
