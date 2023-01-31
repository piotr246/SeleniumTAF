package base;

import org.junit.jupiter.api.AfterEach;

public abstract class BaseTest {

    public void open(String url) {
        BaseDriver.getDriver().get(url);
    }

                      // TUTAJ PROBY IFOLOGIA

//    @BeforeEach
//    public void beforeTestMethod(String browser, String url) {
//        if (browser.equalsIgnoreCase("chrome")) {
//            BaseDriver.instantiateWebDriverChrome();
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            BaseDriver.instantiateWebDriverFirefox();
//        }
//        BaseDriver.getDriver().get(url);
//    }

    @AfterEach
    public void afterTestMethod() {
        System.out.println("afterTestMethod");
        BaseDriver.getDriver().quit();
    }
}

