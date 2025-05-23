package ApiServices;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.BookingInfo;
import pojo.CreateBookingBodyResponse;

import static io.restassured.RestAssured.given;

public class Booking {
    private static final String BASE_URL = "https://restful-booker.herokuapp.com/booking/";

    @Step("Отправить GET Запрос")
    public static Response get (String urlParameter){
        return given()
                .spec(Specs.requestSpec())
                .get(BASE_URL + urlParameter);
    }


    @Step("Отправить POST запрос")
    public static CreateBookingBodyResponse post (BookingInfo request, Integer statusCode){
        return given()
                .spec(Specs.requestSpec())
                .body(request)
                .post(BASE_URL)
                .then()
                .statusCode(statusCode)
                .extract().body().as(CreateBookingBodyResponse.class);
    }

    @Step("Отправить PUT Запрос")
    public static Response put (String urlParameter, BookingInfo request, String token){
        return given()
                .spec(Specs.requestSpec())
                .header("Cookie","token=" + token)
                .body(request)
                .put(BASE_URL + urlParameter);
    }

    @Step("Отправить DELETE Запрос")
    public static Response delete (String urlParameter, String token){
        return given()
                .spec(Specs.requestSpec())
                .header("Cookie","token=" + token)
                .delete(BASE_URL + urlParameter);
    }

}
