package steps.api;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import models.users.UserDto;
import models.users.UserRequestDto;
import net.thucydides.core.annotations.Step;
import utils.restassured.RestAssuredHelper;

import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.is;
import static tests.TestBase.*;

public class UserSteps {
    private static final String BASE_PATH = "users";
    private static RequestSpecification ra = RestAssuredHelper.createSerenityRest(apiBaseUrl);

    public UserSteps() {
        ra.basePath(BASE_PATH);
    }

    @Step("Check whether status code is as expected")
    public UserSteps assertResponseCode(int statusCode) {
        then().statusCode(is(statusCode));
        return this;
    }

    @Step("Make post new user")
    public UserSteps makePostNewUserCall(UserRequestDto userRequest) {
        ValidatableResponse resp = ra.body(userRequest).post("/").then();
        return this;
    }

    @Step("Make login call")
    public UserSteps makeLoginCall(UserRequestDto userRequest) {
        ra.body(userRequest).post("/login").then();
        return this;
    }

    @Step("Extract booking from response")
    public UserDto extractUser() {
        return then().extract().as(UserRequestDto.class).user;
    }
}
