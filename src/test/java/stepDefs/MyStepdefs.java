package stepDefs;

import driver.SingletonDriver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class MyStepdefs {
    @Given("I am an anonymous customer with clear cookies")
    public void iAmAnAnonymousCustomerWithClearCookies() {
        Set<Cookie> allCookies = SingletonDriver.getDriver().manage().getCookies();
        if (allCookies.size() > 0) {
            for (Cookie cookie : allCookies) {
                SingletonDriver.getDriver().manage().deleteCookieNamed(cookie.getName());
            }
        }
        SingletonDriver.getDriver().navigate().refresh();
    }
}
