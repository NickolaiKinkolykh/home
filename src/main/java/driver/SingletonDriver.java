package driver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static constants.Constants.IMPLICITLY_WAIT_TIMEOUT;
import static driver.CapabilitiesHelper.getChromeOptions;
import static driver.ConfigurationService.getTestProperty;

public class SingletonDriver {

    private static WebDriver createDriver() {

        String browser = getTestProperty("selenium.browser");

        switch (browser) {
            case "Chrome":
                WebDriverManager.chromedriver().browserVersion("88.0.4324.104").setup();
                return new ChromeDriver(getChromeOptions());
            case "Firefox":
                WebDriverManager.firefoxdriver().browserVersion("78.7.0esr").setup();
                return new FirefoxDriver();
            default:
                throw new IllegalStateException("This driver is not supported");
        }
    }

    private static ThreadLocal <WebDriver> instance = new ThreadLocal<WebDriver>(){
        @Override
        protected WebDriver initialValue()
        {
            WebDriver driver = createDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS);
            return driver;
        }
    };


    public static WebDriver getDriver() {
        if (instance.get() == null) {
            instance.set(new ChromeDriver(getChromeOptions()));
        }
        return instance.get();
    }
}
