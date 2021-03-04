package desktop.pages;

import abstractClasses.page.AbstractPage;

import java.util.function.Supplier;

import static java.util.Arrays.stream;

public enum Navigator {

    HOME_PAGE("Initial home page", HomePage::new), SEARCH_PAGE("Search page", SearchPage::new),
    BASKET_PAGE("Basket page", BasketPage::new), CHECKOUT("Checkout page", CheckoutPage::new);

    private String name;
    private AbstractPage page;
    private static String PAGE_ERROR_MESSAGE = "No Page can be found by this name";

    Navigator(String pageName, Supplier<AbstractPage> pageSupplier) {
        this.name = pageName;
        this.page = pageSupplier.get();
    }

    public static AbstractPage visitPageByName(String givenPageName) {
        return getNavigatorPageByName(givenPageName).visit();
    }

    private static Navigator getNavigatorPageByName(String pageName) {
        return stream(Navigator.values())
                .filter(page -> page.name.equals(pageName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(PAGE_ERROR_MESSAGE));
    }

    public AbstractPage visit() {
        page.visit();
        return page;
    }

    private static AbstractPage getPage(String pageName) {
        return getNavigatorPageByName(pageName).page;
    }

    public static String getPageURLByName(String pageName) {
        return getPage(pageName).getPageUrl();
    }
}
