package ApiServices;


import io.qameta.allure.Step;
import pojo.AuthRequest;
import pojo.AuthResponse;

import static io.restassured.RestAssured.given;

public class Authentication {
    private static final String BASE_URL_AUTH = "https://restful-booker.herokuapp.com/auth/";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password123";

    @Step("Получение токена")
    public static String getToken(){
        AuthRequest request = new AuthRequest(USERNAME, PASSWORD);
        AuthResponse response = given()
                .spec(Specs.requestSpec())
                .body(request)
                .post(BASE_URL_AUTH)
                .then()
                .extract().response().as(AuthResponse.class);
        return response.getToken();
    }


}
