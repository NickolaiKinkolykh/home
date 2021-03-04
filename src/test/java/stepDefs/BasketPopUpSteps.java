package stepDefs;

import desktop.fragments.BasketPopupFragment;
import io.cucumber.java.en.And;

public class BasketPopUpSteps {

    BasketPopupFragment basketPopupFragment = new BasketPopupFragment();

    @And("I select {string} in basket pop-up")
    public void iSelectBasketCheckoutInBasketPopUp(String buttonName) {
        basketPopupFragment.waitUntilPopUpAppeared().clickCheckoutButton(buttonName);
    }
}
