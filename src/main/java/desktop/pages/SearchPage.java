package desktop.pages;

import abstractClasses.page.AbstractPage;

public class SearchPage extends AbstractPage {
    private static final String pageUrl = "https://www.bookdepository.com/search?searchTerm=";

    public SearchPage() {
        setPageUrl(pageUrl);
    }
}
