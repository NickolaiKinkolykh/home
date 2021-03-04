package abstractClasses.fragment;

import abstractClasses.AbstractFragmentInterface;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverWaiter;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static driver.SingletonDriver.getDriver;

public abstract class AbstractFragment extends WebDriverWaiter implements AbstractFragmentInterface {

    private WebElement rootElement;

    public AbstractFragment() {
        PageFactory.initElements(getDriver(), this);
    }

    public void setRootElement(WebElement element) {
        this.rootElement = element;
    }

    public WebElement getRootElement() {
        return rootElement;
    }



    protected SelenideElement getElement(By byLocator) {
        return $(rootElement).$(byLocator).shouldBe(exist);
    }

    @Override
    public AbstractFragmentInterface clickElement(By locator) {
        getElement(locator).click();
        return this;
    }

    @Override
    public AbstractFragmentInterface setInputValue(By locator, String value) {
        if (value != null) {
            getElement(locator).clear();
            getElement(locator).setValue(value);
        }
        return this;
    }

    @Override
    public String getElementText(By locator) {
        return getElement(locator).getText();
    }

    protected List<WebElement> getChildElements(By byLocator) {
        return new ArrayList<>(getChildSelenideElements(byLocator));
    }

    protected List<SelenideElement> getChildSelenideElements(By byLocator) {
        return $(rootElement).$$(byLocator).shouldBe(sizeGreaterThan(0));
    }

    public static void jsSetInputValue() {

    }
}
