package desktop.pages;

import abstractClasses.fragment.AbstractFragment;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class WebComponentFactory {

    private WebComponentFactory() {
    }

    public static <T extends AbstractFragment> T createFragment(Class<T> type) {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
        }
        throw new IllegalStateException("Unable to create an instance of class " + type.getSimpleName());
    }

    public static <T extends AbstractFragment> T createFragment(WebElement rootElement, Class<T> type) {
        T instance = createFragment(type);
        instance.setRootElement(rootElement);
        return instance;
    }

    public static <T extends AbstractFragment> List<T> createFragments(List<SelenideElement> elements, Class<? extends T> type) {
        return elements.stream()
                .map(element -> createFragment(element, type))
                .collect(Collectors.toList());
    }
}
