package RestTests;

import ApiServices.Authentication;
import ApiServices.Booking;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import lombok.Setter;
import org.junit.jupiter.api.*;
import pojo.BookingInfoDates;
import pojo.BookingInfo;
import pojo.CreateBookingBodyResponse;
import pojo.GetBookingsResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Сервис 'BOOKING'")
public class BookingTest {

    private BookingInfo request = BookingInfo.builder()
            .firstname("Иван")
            .lastname("Петров")
            .additionalneeds("No")
            .depositpaid(true)
            .totalprice(12345)
            .bookingdates(new BookingInfoDates(LocalDate.of(2019,3,22),
                        LocalDate.of(2020,3,22)))
            .build();
    @Setter
    private static Integer bookingId;
    @Setter
    private static String token;


    @Test
    @Order(1)
    @DisplayName("Проверка метода CreateBooking")
    @Owner("Григорьев Денис")
    @Description("Проверить, что метод создает бронирование. Ответ должен содержать информацию о бронировании и ID бронирования." +
            " Ожидаемый статус = 200")
    @Tag("API")
    @Tag("smoke")
    public void createBooking(){
        CreateBookingBodyResponse response = Booking.post(request, 200);
        Assertions.assertNotNull(response.getBookingid(),"В ответе отсутствует ID- бронирования");
        Assertions.assertEquals(response.getBooking().toString(),request.toString(), "Бронирование в запросе" +
                " отличается от бронирования в ответе");
        setBookingId(response.getBookingid());
    }

    @Test
    @Order(5)
    @DisplayName("Проверка метода GetBooking")
    @Owner("Григорьев Денис")
    @Description("Проверить, что метод возвращает информацию о бронировании по ID." +
            " Ожидаемый статус = 200")
    @Tag("API")
    @Tag("smoke")
    public void getBooking(){
        Allure.step("Проверить что получены данные о бронировании и статус-код = 200");
            BookingInfo response = Booking.getById(bookingId, 200);
        Assertions.assertEquals(request.toString(),response.toString(), "Полученное бронирование не " +
                "соответствуют записи с ID"+ bookingId +".");
    }

    @Test
    @Order(6)
    @DisplayName("Проверка метода UpdateBooking")
    @Owner("Григорьев Денис")
    @Description("Проверить, что метод обновляет данные о бронировании и тело ответа включает информацию о бронировании." +
            " Ожидаемый статус = 200")
    @Tag("API")
    @Tag("smoke")
    public void updateBooking(){
        setToken(Authentication.getToken());
        BookingInfo requestPut = request.withAdditionalneeds("Yes")
                .withLastname("Герасимов");
        Allure.step("Проверить что данные ответа = данным из запроса");
        BookingInfo response = Booking.put(bookingId, requestPut,token,200);
        Assertions.assertEquals(requestPut.toString(),response.toString(), "Данные в ответе не соответствуют данным запроса");
    }

    @Test
    @Order(7)
    @DisplayName("Проверка метода DeleteBooking")
    @Owner("Григорьев Денис")
    @Description("Проверить, что метод удаляет данные о бронировании." +
            " Ожидаемый статус = 201")
    @Tag("API")
    @Tag("smoke")
    public void deleteBooking(){
        Allure.step("Проверить что ответ = 201 и Response = Created");
        String response = Booking.delete(bookingId, token, 201);
        Assertions.assertEquals("Created",response, "Текст ответа не 'Created'");
    }


    @Test
    @Order(8)
    @DisplayName("Проверка метода UpdateBooking// Обновление несуществующей записи ")
    @Owner("Григорьев Денис")
    @Description("Проверить, что метод не обновит данные по ID, которого нет базе" +
            " Ожидаемый статус = 405")
    @Tag("API")
    @Tag("smoke")
    public void updateBookingNotFound(){
        setToken(Authentication.getToken());
        BookingInfo requestPutNf = request.withAdditionalneeds("Yes")
                .withLastname("Борисов");
        Allure.step("Проверить что вернулся код 405");
       Booking.putString(bookingId, requestPutNf,token,405);
    }

    @Test
    @Order(9)
    @DisplayName("Проверка метода DeleteBooking// Удаление несуществующей записи")
    @Owner("Григорьев Денис")
    @Description("Проверить, что метод вернет 404 ошибку при попытке удалить запись которой нет в базе")
    @Tag("API")
    @Tag("smoke")
    public void deleteBookingNotFound(){
        Allure.step("Проверить что в ответе пришел статус код 405");
        Booking.delete(bookingId, token, 405);
    }

    @Test
    @Order(10)
    @DisplayName("Проверка метода UpdateBooking// Обновление авторизации ")
    @Owner("Григорьев Денис")
    @Description("Проверить, что метод вернет 403 ошибку при, условии что в заголовках нет токенаавторизации")
    @Tag("API")
    @Tag("smoke")
    public void updateBookingForbidden (){
        BookingInfo requestPutNf = request.withAdditionalneeds("NO")
                .withLastname("Буйнов");
        Allure.step("Отправить запрос без токена");
        Booking.putString(bookingId, requestPutNf,"",403);
    }

    @Test
    @Order(11)
    @DisplayName("Проверка метода DeleteBooking// Ошибка авторизации")
    @Owner("Григорьев Денис")
    @Description("Проверить, что метод вернет 403 ошибку при, условии что в заголовках нет токенаавторизации")
    @Tag("API")
    @Tag("smoke")
    public void deleteBookingForbidden (){
        Allure.step("Отправить запрос без токена");
        Booking.delete(bookingId, "", 403);
    }


    @Test
    @Order(2)
    @DisplayName("Проверка метода GetBookingIds без параметров")
    @Owner("Григорьев Денис")
    @Description("Проверить, что метод вернет массив со всеми ID. Ожидаемый статус код = 200")
    @Tag("API")
    @Tag("smoke")
    public void getAllIds(){
        List<GetBookingsResponse> response = Booking.getAllId(200);
        List<Integer> bookingIds = new ArrayList<>();
        for (GetBookingsResponse res: response){
            bookingIds.add(res.getBookingid());
        }
        long uniqueIdsCount = bookingIds.stream().distinct().count();
        Allure.step("Проверка, что массив в ответе не пустой");
        Assertions.assertFalse(response.isEmpty(),"Список ID пустой");
        Allure.step("Проверка, что значения полученных ID уникальные");
        Assertions.assertEquals(uniqueIdsCount, bookingIds.size(), "В списке полученных ID есть неуникальные значения");
    }

    @Test
    @Order(3)
    @DisplayName("Проверка метода GetBookingIds c фильтрацией по Имени и Фамилии")
    @Owner("Григорьев Денис")
    @Description("Проверить, что метод вернет ID бронирования при фильтрации по Имя/Фамилия. Ожидаемый статус код = 200")
    @Tag("API")
    @Tag("smoke")
    public void getByName(){
        List<GetBookingsResponse> response = Booking.getByName(request.getFirstname(),request.getLastname(),200);
        List<Integer> bookingIds = new ArrayList<>();
        for (GetBookingsResponse res: response){
            bookingIds.add(res.getBookingid());
        }
        Allure.step("Проверка, что массив в ответе не пустой");
        Assertions.assertFalse(response.isEmpty(),"Список ID пустой");
        Allure.step("Проверить, что в ответе есть ID созданного бронирования");
        Assertions.assertTrue(bookingIds.contains(bookingId));
    }

    @Test  // Для ошибки в Allure
    @Order(4)
    @DisplayName("Проверка метода GetBookingIds c фильтрацией по checkin/checkout")
    @Owner("Григорьев Денис")
    @Description("Проверить, что метод вернет ID бронирования при фильтрации по checkin/checkout. Ожидаемый статус код = 200")
    @Tag("API")
    @Tag("smoke")
    public void getByDates(){
        List<GetBookingsResponse> response = Booking.getByDate(request.getBookingdates().getCheckin().toString()
                ,request.getBookingdates().getCheckout().toString(),200);
        List<Integer> bookingIds = new ArrayList<>();
        for (GetBookingsResponse res: response){
            bookingIds.add(res.getBookingid());
        }
        Allure.step("Проверка, что массив в ответе не пустой");
        Assertions.assertFalse(response.isEmpty(),"Список ID пустой");
        Allure.step("Проверить, что в ответе есть ID созданного бронирования");
        Assertions.assertTrue(bookingIds.contains(bookingId), "Не найден ID по фильтру даты");
    }


}
