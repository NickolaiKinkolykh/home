package driver;

import org.openqa.selenium.chrome.ChromeOptions;

import static driver.ConfigurationService.getTestProperty;

public class CapabilitiesHelper {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(getTestProperty("test.type"));
        chromeOptions.addArguments(getTestProperty("ignore.cert"));
        return chromeOptions;
    }
}
