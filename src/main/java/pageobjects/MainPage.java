package pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.WebElement;

public class MainPage extends PageObject {

    @FindBy(xpath="//a[@class='nav-link' and text()=' Sign in ']")
    WebElement signInButton;

    @FindBy(className="home-page")
    WebElement mainContainer;

    @FindBy(xpath="//div[@class='feed-toggle']//a[@class='nav-link active']")
    WebElement activeFeed;

    @FindBy(xpath="//ul[contains(@class, 'navbar-nav')]//li[last()]")
    WebElement lastNavItem;

    @WhenPageOpens
    public void waitUntilPageIsLoaded() {
        element(mainContainer).waitUntilVisible();
    }

    public void goToLoginPage() {
        element(signInButton).waitUntilClickable().click();
    }

    public WebElement getActiveFeed() {
        return element(activeFeed).waitUntilVisible();
    }

    public WebElement getLastNavItem() {
        return element(lastNavItem).waitUntilVisible();
    }
}
