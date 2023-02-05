package base;

import org.junit.jupiter.api.AfterEach;

public abstract class BaseTest {

    public void open(String url) {
        BaseDriver.getDriver().get(url);
    }

    public void open(String url, String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            BaseDriver.instantiateWebDriverChrome();
        } else if (browser.equalsIgnoreCase("firefox")) {
            BaseDriver.instantiateWebDriverFirefox();
        }
        open(url);
    }


    @AfterEach
    public void afterTestMethod() {
        System.out.println("afterTestMethod");
        BaseDriver.getDriver().quit();
    }
}

