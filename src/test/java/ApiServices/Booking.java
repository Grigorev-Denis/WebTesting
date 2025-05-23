package ApiServices;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.BookingInfo;
import pojo.CreateBookingBodyResponse;

import static io.restassured.RestAssured.given;

public class Booking {
    public static final String BASE_URL = "https://restful-booker.herokuapp.com/booking/";

    @Step("Отправить GET Запрос")
    public static BookingInfo get (Integer urlParameter, Integer statusCode){
        return given()
                .spec(Specs.requestSpec())
                .get(BASE_URL + urlParameter)
                .then()
                .spec(Specs.responeSpec())
                .statusCode(statusCode)
                .extract().body().as(BookingInfo.class);

    }


    @Step("Отправить POST запрос")
    public static CreateBookingBodyResponse post (BookingInfo request, Integer statusCode){
        return given()
                .spec(Specs.requestSpec())
                .body(request)
                .post(BASE_URL)
                .then()
                .spec(Specs.responeSpec())
                .statusCode(statusCode)
                .extract().body().as(CreateBookingBodyResponse.class);
    }

    @Step("Отправить PUT Запрос")
    public static BookingInfo put (Integer urlParameter, BookingInfo request, String token, Integer statusCode){
        return given()
                .spec(Specs.requestSpec())
                .header("Cookie","token=" + token)
                .body(request)
                .put(BASE_URL + urlParameter)
                .then()
                .spec(Specs.responeSpec())
                .statusCode(statusCode)
                .extract().body().as(BookingInfo.class);

    }

    @Step("Оправить запрос PUT ")
    public static String putString(Integer urlParameter, BookingInfo request, String token, Integer statusCode){
        return given()
                .spec(Specs.requestSpec())
                .header("Cookie","token=" + token)
                .body(request)
                .put(BASE_URL + urlParameter)
                .then()
                .statusCode(statusCode)
                .spec(Specs.responeSpec())
                .extract().response().getBody().asString();

    }

    @Step("Отправить DELETE Запрос")
    public static String delete (Integer urlParameter, String token, Integer statusCode){
        return given()
                .spec(Specs.requestSpec())
                .header("Cookie","token=" + token)
                .delete(BASE_URL + urlParameter)
                .then()
                .statusCode(statusCode)
                .spec(Specs.responeSpec())
                .extract().response().getBody().asString();
    }

}
