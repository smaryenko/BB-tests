package steps.ui;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pageobjects.LoginPage;
import pageobjects.MainPage;

public class LoginSteps {
    MainPage mainPage;
    LoginPage loginPage;

    @Step("Login to account with user {0}")
    public void login(String userName, String password) {
        mainPage.open();
        mainPage.goToLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.login(userName, password);
    }

    @Step("Check error message {0}")
    public void checkError(String error) {
        Assert.assertTrue(loginPage.getErrorsContainer().getText().contains(error));
    }
}
