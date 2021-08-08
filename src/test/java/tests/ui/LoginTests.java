package tests.ui;

import models.users.UserDto;
import models.users.UserRequestDto;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.api.UserSteps;
import steps.ui.LoginSteps;
import steps.ui.MainSteps;
import tests.TestBase;

@RunWith(SerenityRunner.class)
@WithTag(type="ui", name="login")
public class LoginTests extends TestBase {

    @Managed
    WebDriver driver;

    @Steps
    LoginSteps loginSteps;

    @Steps
    MainSteps mainSteps;

    @Steps
    UserSteps userSteps;

    @Test
    public void logInTest_Success() {
        //Arrange
        UserDto userForTest = UserDto.getRandomUser();

        userSteps
                .makePostNewUserCall(new UserRequestDto(userForTest))
                .assertResponseCode(HttpStatus.SC_OK);

        //Act
        loginSteps.login(userForTest.email, userForTest.password);

        //Assert
        mainSteps.checkFeed("Your Feed");
        mainSteps.checkLastNavItem(userForTest.username);
    }

    @Test
    public void logInTest_Error() {
        //Arrange
        UserDto userForTest = UserDto.getRandomUser();

        //Act
        loginSteps.login(userForTest.email, userForTest.password);

        //Assert
        loginSteps.checkError("email or password is invalid");
    }
}
