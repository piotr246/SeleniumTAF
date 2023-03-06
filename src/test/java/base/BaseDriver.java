package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.util.Properties;


public class BaseDriver {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void instantiateWebDriver() {
        Properties prop = new Properties();
        try {
            prop.load(BaseDriver.class.getClassLoader().getResourceAsStream("MyProject.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String browserName = prop.getProperty("browserName");

        if (browserName.equalsIgnoreCase("chrome")) {
            BaseDriver.instantiateWebDriverChrome();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            BaseDriver.instantiateWebDriverFirefox();
        }
    }

    public static void instantiateWebDriverChrome() {
        setWebDriver(new ChromeDriver(setChromeOptions()));
    }

    public static void quitDriver() {
        webDriver.get().quit();
    }

    public static void instantiateWebDriverFirefox() {
        setWebDriver(new FirefoxDriver(setFirefoxOptions()));
        BaseDriver.getDriver().manage().window().maximize();
    }

    private static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    private static ChromeOptions setChromeOptions() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
//        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("credentials_enable_service", false);
//        prefs.put("profile.password_manager_enabled", false);
//        options.setExperimentalOption("prefs", prefs);
//        //options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
//        options.setCapability("chrome.switches", Collections.singletonList("--incognito"));
//        options.setCapability(ChromeOptions.CAPABILITY, options);
        return options;
    }

    private static FirefoxOptions setFirefoxOptions() {
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        FirefoxOptions opt = new FirefoxOptions();
        opt.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        return opt;
    }
}
