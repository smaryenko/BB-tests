package tests.api.users;

import models.users.UserDto;
import models.users.UserRequestDto;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.api.UserSteps;
import tests.TestBase;

@RunWith(SerenityRunner.class)
@WithTag(type="api", name="Users")
public class UserTests extends TestBase {
    @Steps
    UserSteps userSteps;

    @Test
    public void testPostNewUser() {
        //Arrange
        UserDto userForTest = UserDto.getRandomUser();

        //Act
        UserDto userCreated = userSteps
                .makePostNewUserCall(new UserRequestDto(userForTest))
                .assertResponseCode(HttpStatus.SC_OK)
                .extractUser();

        //Assert
        checkResponse(userCreated, userForTest);
    }

    @Test
    public void testLoginNewUser() {
        //Arrange
        UserDto userForTest = UserDto.getRandomUser();

        //Act
        UserDto userCreated = userSteps
                .makePostNewUserCall(new UserRequestDto(userForTest))
                .assertResponseCode(HttpStatus.SC_OK)
                .makeLoginCall(new UserRequestDto(userForTest))
                .assertResponseCode(HttpStatus.SC_OK)
                .extractUser();

        //Assert
        checkResponse(userCreated, userForTest);
    }

    private void checkResponse(UserDto userCreated, UserDto userForTest) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(userCreated.username).as("username").isEqualTo(userForTest.username);
        softly.assertThat(userCreated.email).as("email").isEqualTo(userForTest.email);
        softly.assertThat(userCreated.token).as("token").isNotEmpty();
        softly.assertThat(userCreated.password).as("password").isNull();
        softly.assertAll();
    }
}

