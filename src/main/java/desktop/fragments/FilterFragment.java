package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.withText;

public class FilterFragment extends AbstractFragment {
    @FindBy(css = ".sidebar-section.search-filter")
    private WebElement fragmentRootElement;

    private static final By PRICE_RANGE_SELECTOR = By.cssSelector("#filterPrice");
    private static final By AVAILABILITY_SELECTOR = By.cssSelector("#filterAvailability");
    private static final By LANGUAGE_SELECTOR = By.cssSelector("#filterLang");
    private static final By FORMAT_SELECTOR = By.cssSelector("#filterFormat");
    private static final By REFINE_RESULT_BUTTON = By.cssSelector(".form-group.padded-btn-wrap .btn.btn-primary");


    public FilterFragment() {
        setRootElement(fragmentRootElement);
    }

    public FilterFragment setPriceRange(String priceRangeValue) {
        getElement(PRICE_RANGE_SELECTOR).find(withText(priceRangeValue)).click();
        return this;
    }

    public FilterFragment setAvailabilityFilter(String availability) {
        getElement(AVAILABILITY_SELECTOR).find(withText(availability)).click();
        return this;
    }

    public FilterFragment setLanguageFilter(String languageValue) {
        getElement(LANGUAGE_SELECTOR).find(withText(languageValue)).click();
        return this;
    }

    public FilterFragment setFormatFilter(String formatValue) {
        getElement(FORMAT_SELECTOR).find(withText(formatValue)).click();
        return this;
    }

    public FilterFragment submitFilters() {
        clickElement(REFINE_RESULT_BUTTON);
        return this;
    }
}
