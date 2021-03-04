package stepDefs;

import desktop.fragments.FilterFragment;
import desktop.fragments.SearchFragment;
import desktop.fragments.SearchResultFragment;
import dto.FilterDto;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchSteps {

    private SearchFragment searchFragment = new SearchFragment();
    private SearchResultFragment searchResultFragment = new SearchResultFragment();
    private FilterFragment filterFragment = new FilterFragment();

    @And("I search for {string}")
    public void iSearchFor(String searchValue) {
        searchFragment.setValueToSearchInput(searchValue).clickOnSubmitSearch();
    }

    @And("Search results contain the following products")
    public void searchResultsContainTheFollowingProducts(List<String> expectedItems) {
       assertThat(searchResultFragment.getAllBookNamesInSearchResult().containsAll(expectedItems))
               .as("books are not displayed in Result Page").isTrue();
    }

    @And("I apply the following search filters:")
    public void iApplyTheFollowingSearchFilters(@Transpose FilterDto filterDto) {
        filterFragment.setPriceRange(filterDto.priceRange).setAvailabilityFilter(filterDto.availability)
                .setLanguageFilter(filterDto.language).setFormatFilter(filterDto.format)
                .submitFilters();
    }

    @And("Search results contain only the following products")
    public void searchResultsContainOnlyTheFollowingProducts(List<String> expectedItems) {
        assertThat(expectedItems).as("books are not displayed in Result Page")
                .isEqualTo(searchResultFragment.getAllBookNamesInSearchResult());
    }

    @And("I click 'Add to basket' button for product with name {string}")
    public void iClickAddToBasketButtonForProductWithName(String bookName) {
        searchResultFragment.addBookToBasket(bookName);
    }
}
