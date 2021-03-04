package utils;

import driver.SingletonDriver;
import org.openqa.selenium.JavascriptExecutor;

public class WebDriverUtils {


    public static String getCurrentURL() {
        return SingletonDriver.getDriver().getCurrentUrl();
    }

    public static <T> T executeScript(String script, Object... elements) {
        return (T)((JavascriptExecutor) SingletonDriver.getDriver()).executeScript(script, elements);
    }

}
