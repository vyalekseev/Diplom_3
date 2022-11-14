package api;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class DeleteUserMethods extends RestClient {

    public ValidatableResponse delete(String bearerToken) {
        return given().log().all()
                .spec(getDefaultRequest())
                .auth().oauth2(bearerToken)
                .delete("/api/auth/user")
                .prettyPeek()
                .then();
    }
}
