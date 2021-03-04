package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;

public class SearchResultItem extends AbstractFragment {

    private static final By BOOK_NAME = By.cssSelector("div.item-info h3.title");
    private static final By BOOK_AUTHOR = By.xpath(".//p[@class='author']/span/a/span[@itemprop='name']");
    private static final By ADD_TO_BASKET = By.xpath(".//div[@class='item-actions']/div/a");

    public String getAuthorName() {
        return getElementText(BOOK_AUTHOR);
    }

    public String getBookName()  {
        return getElementText(BOOK_NAME);
    }

    public void clickAddToBasketBook() {
        clickElement(ADD_TO_BASKET);
    }

}
