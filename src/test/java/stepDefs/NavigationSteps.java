package stepDefs;

import com.codeborne.selenide.WebDriverRunner;
import desktop.pages.Navigator;
import driver.SingletonDriver;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;
import static utils.WebDriverUtils.getCurrentURL;

public class NavigationSteps {

    MyCucumberHooks cucumberHooks = new MyCucumberHooks();

    @And("I open the {string}")
    public void iOpenThe(String pageName) {
        Navigator.visitPageByName(pageName);
    }

    @And("I am redirected to a {string}")
    public void iAmRedirectedToA(String page) {
        assertThat(getCurrentURL()).as("Page URL is not equal to expected page")
                .contains(Navigator.getPageURLByName(page));
    }

    @And("I open the direct URL {string}")
    public void iOpenTheDirectURL(String arg0) {
        SingletonDriver.getDriver().get(arg0);
    }

    @And("I type {string} into search input")
    public void iTypeIntoSearchInput(String arg0) {
        SingletonDriver.getDriver().findElement(By.xpath(".//input[@name='q']")).sendKeys(arg0);
    }
}
