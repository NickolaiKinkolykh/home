package abstractClasses;

import org.openqa.selenium.By;

public interface AbstractFragmentInterface {

    AbstractFragmentInterface clickElement(By locator);
    AbstractFragmentInterface setInputValue(By locator, String Value);
    String getElementText(By locator);
}
