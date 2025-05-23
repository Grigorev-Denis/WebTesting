package restservices;

import ApiServices.Authentication;
import ApiServices.Booking;
import ApiServices.Specs;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.BookingInfoDates;
import pojo.BookingInfo;
import pojo.CreateBookingBodyResponse;

import java.time.LocalDate;


@DisplayName("Сервис 'CreateBooking'")
public class BookingTest {

    public BookingInfo request = BookingInfo.builder()
            .firstname("Иван")
            .lastname("Петров")
            .additionalneeds("No")
            .depositpaid(true)
            .totalprice(12345)
            .bookingdates(new BookingInfoDates(LocalDate.of(2019,3,22),
                        LocalDate.of(2020,3,22)))
            .build();

   // @Test
    public void get(){
        Booking.get("2").then().spec(Specs.checkStatusCode(200));
    }


    //@Test
    public void post(){
//        BookingInfo request=new BookingInfo(RandomDatas.randomName(),"No",
//                new BookingInfoDates(LocalDate.of(2019,3,22),
//                        LocalDate.of(2020,3,22)),true, 124,"Grigorev");

//        Response response = Booking.post(request);
//        response.then().spec(Specs.checkStatusCode(200));
        CreateBookingBodyResponse response = Booking.post(request, 200);

    }

//    @Test
//    public void put(){
////        BookingInfo request = new BookingInfo(RandomDatas.randomName(),"No",
////                new BookingInfoDates(LocalDate.of(2019,3,22),
////                        LocalDate.of(2020,3,22)),true, 124,"Grigorev");
//        Response response = Booking.post(request);
//        String id = response
//                .then()
//                .spec(Specs.checkStatusCode(200))
//                .extract().body().jsonPath().getString("bookingid");
//
////        BookingInfo requestPut = new BookingInfo(RandomDatas.randomName(),"No",
////                new BookingInfoDates(LocalDate.of(2019,3,22),
////                        LocalDate.of(2022,3,22)),true, 124,"Grigorev");
//
//        String token = Authentication.getToken();
//        //BookingInfo requestPut = request.withAdditionalneeds("Yes");
//        Booking.put(id,request,token).then().spec(Specs.checkStatusCode(200));
//
//    }

//    @Test
//    public void delete (){
////            BookingInfo request = new BookingInfo(RandomDatas.randomName(),"No",
////                    new BookingInfoDates(LocalDate.of(2019,3,22),
////                            LocalDate.of(2020,3,22)),true, 124,"Grigorev");
//            Response response = Booking.post(request);
//            String id = response.then().statusCode(200).extract().body().jsonPath().getString("bookingid");
//            String token = Authentication.getToken();
//            Booking.delete(id,token).then().spec(Specs.checkStatusCode(201));
//        Allure.step("Проверяем что действительно удалился");
//            Booking.get(id).then().spec(Specs.checkStatusCode(404));
//
//    }

}
