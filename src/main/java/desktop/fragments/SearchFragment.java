package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchFragment extends AbstractFragment {

    private static final By SEARCH_BAR = By.name("searchTerm");
    private static final By SUBMIT_SEARCH_BUTTON = By.cssSelector(".header-search-btn");

    @FindBy(css = "#book-search-form")
    private WebElement fragmentRootElement;

    public SearchFragment() {
        setRootElement(fragmentRootElement);
    }

    public SearchFragment setValueToSearchInput(String value) {
        clickElement(SEARCH_BAR);
        setInputValue(SEARCH_BAR,value);
        return this;
    }

    public SearchFragment clickOnSubmitSearch() {
        clickElement(SUBMIT_SEARCH_BUTTON);
        return this;
    }

}
