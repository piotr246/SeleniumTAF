package tests;

import base.BaseTest;
import other.Constants;
import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;


public class FirstTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test
    public void fT() {
        open(Constants.INSTAGRAM_URL);
        ///open(Constants.GOOGLE_URL,$browser);  //pytanie3
        loginPage.forgetPasswordButtonClick();
    }
}
