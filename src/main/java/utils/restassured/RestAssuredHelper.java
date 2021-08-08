package utils.restassured;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class RestAssuredHelper {
    private static final HeaderConfig headerConfig = new HeaderConfig()
            .overwriteHeadersWithName("Content-Type", "Authorization");

    public static RequestSpecification createSerenityRest(String baseUri) {
        RequestSpecification ra = SerenityRest
                .given()
                .config(RestAssured.config().headerConfig(headerConfig))
                .contentType(ContentType.JSON)
                .baseUri(baseUri);

        return ra;
    }


}
