package ApiServices;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.jspecify.annotations.Nullable;
import pojo.BookingInfo;
import pojo.CreateBookingBodyResponse;
import pojo.GetBookingsResponse;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Booking {
    public static final String BASE_URL = "https://restful-booker.herokuapp.com/booking/";

    @Step("Отправить GET Запрос")
    public static BookingInfo getById(Integer urlParameter, Integer statusCode){
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

    @Step("Отправить GET Запрос на получение всех Id")
    public static List<GetBookingsResponse> getAllId(Integer statusCode){
        return given()
                .spec(Specs.requestSpec())
                .get(BASE_URL)
                .then()
                .spec(Specs.responeSpec())
                .statusCode(statusCode)
                .extract().body().jsonPath().getList("$",GetBookingsResponse.class);
    }

    @Step("Отправить GET Запрос на получение всех Id по фильтру Фамилия + Имя")
    public static List<GetBookingsResponse> getByName(String firstname, String lastname,Integer statusCode){
        return given()
                .spec(Specs.requestSpec())
                .get("https://restful-booker.herokuapp.com/booking?firstname=" +firstname+ "&lastname=" +lastname)
                .then()
                .spec(Specs.responeSpec())
                .statusCode(statusCode)
                .extract().body().jsonPath().getList("$",GetBookingsResponse.class);
    }

    @Step("Отправить GET Запрос на получение всех Id по фильтру checkin/checkout):")
    public static List<GetBookingsResponse> getByDate(String checkin, String checkout,Integer statusCode){
        return given()
                .spec(Specs.requestSpec())
                .get("https://restful-booker.herokuapp.com/booking?checkin=" +checkin+ "&checkout=" +checkout)
                .then()
                .spec(Specs.responeSpec())
                .statusCode(statusCode)
                .extract().body().jsonPath().getList("$",GetBookingsResponse.class);
    }


}
