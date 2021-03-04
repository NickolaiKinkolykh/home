package abstractClasses.page;

import driver.SingletonDriver;
import org.openqa.selenium.TimeoutException;

import static driver.SingletonDriver.getDriver;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public abstract class AbstractPage {

    private String pageUrl;
    private String pageUrlPattern;
    private String PAGE_COUDNT_BE_REACHED = "Timeout loading";

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public String setPageUrlPattern(String pageUrlPattern) {
        return this.pageUrlPattern = pageUrlPattern;
    }

    public String getPageUrlPattern() {
        return pageUrlPattern;
    }

    public boolean checkUrl() {
        boolean result = pageUrl.equals(getDriver().getCurrentUrl());
        if (!result && isNotEmpty(pageUrlPattern)) {
            return getDriver().getCurrentUrl().matches(pageUrlPattern);
        }
        return result;
    }

    public void visit() {
        final String pageUrl = getPageUrl();
        try {
            SingletonDriver.getDriver().navigate().to(pageUrl);
        } catch (TimeoutException e) {
           throw new TimeoutException(PAGE_COUDNT_BE_REACHED);
        }
    }
}
