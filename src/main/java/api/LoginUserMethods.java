package api;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class LoginUserMethods extends RestClient {
    public ValidatableResponse login(LoginUserRequest loginUserRequest) {
        return given().log().all()
                .spec(getDefaultRequest())
                .body(loginUserRequest)
                .post("/api/auth/login")
                .prettyPeek()
                .then();
    }
}