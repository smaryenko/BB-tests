package pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageObject {

    @FindBy(xpath="//input[@formcontrolname='email']")
    WebElement email;

    @FindBy(xpath="//input[@formcontrolname='password']")
    WebElement pass;

    @FindBy(xpath="//button[text()=' Sign in ']")
    WebElement submit;

    @FindBy(tagName="app-list-errors")
    WebElement errorsContainer;

    public void waitUntilPageIsLoaded() {
        element(email).waitUntilVisible();
    }

    public void login(String userName, String password) {
        email.sendKeys(userName);
        element(pass).waitUntilVisible().sendKeys(password);
        element(submit).waitUntilClickable().click();
    }

    public WebElement getErrorsContainer() {
        return element(errorsContainer).waitUntilVisible();
    }
}
