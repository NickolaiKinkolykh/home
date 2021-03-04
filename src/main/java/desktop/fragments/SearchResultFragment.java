package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static desktop.pages.WebComponentFactory.createFragments;

public class SearchResultFragment extends AbstractFragment {

    @FindBy(css = ".tab.search")
    private WebElement fragmentRootElement;

    public SearchResultFragment() {
        setRootElement(fragmentRootElement);
    }

    private static final By SEARCH_RESULT_ITEM = By.cssSelector("div.book-item");

    public List<SearchResultItem> getAllSearchResultsItems(){
        return createFragments(getChildSelenideElements(SEARCH_RESULT_ITEM), SearchResultItem.class);
    }

    public List<String> getAllBookNamesInSearchResult() {
        return getAllSearchResultsItems().stream()
                .map(SearchResultItem::getBookName)
                .collect(Collectors.toList());
    }

    public void addBookToBasket(String bookName) {
        List<SearchResultItem> booksInSearchList = getAllSearchResultsItems();
        booksInSearchList.stream()
                .filter(item -> item.getBookName().equals(bookName))
                .findFirst()
                .get()
                .clickAddToBasketBook();
    }
}
