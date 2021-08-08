package steps.ui;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pageobjects.LoginPage;
import pageobjects.MainPage;

public class MainSteps {
    MainPage mainPage;

    @Step("Check current feed {0}")
    public void checkFeed(String expectedFeed) {
        Assert.assertTrue(mainPage.getActiveFeed().getText().contains(expectedFeed));
    }

    @Step("Check last nav item is {0}")
    public void checkLastNavItem(String expectedFeed) {
        Assert.assertTrue(mainPage.getLastNavItem().getText().contains(expectedFeed));
    }
}
