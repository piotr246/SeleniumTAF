package pageobjects;

import base.BaseDriver;
import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePageObject {

    public LoginPage() {
        super();
    }

    @FindBy(xpath = "//*[@href=\"/accounts/password/reset/\"]")
    WebElement forgetPasswordButton;

    @FindBy(xpath = "//*[text()=\"Zezwól tylko na niezbędne pliki cookie\"]")
    WebElement acceptCookieButton;

    public void forgetPasswordButtonClick() {
        WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(forgetPasswordButton));
        acceptCookieButton.click();
        forgetPasswordButton.click();
    }
}
