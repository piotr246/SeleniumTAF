package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePageObject {

    WebDriver driver;

    public BasePageObject() {
        //BaseDriver.instantiateWebDriverChrome();
        PageFactory.initElements(BaseDriver.getDriver(), this);
        this.driver = driver;
    }
}
