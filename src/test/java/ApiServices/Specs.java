package ApiServices;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

 public class Specs {
     static AllureRestAssured filterAllure = new AllureRestAssured()
             .setRequestAttachmentName("Запрос")
             .setResponseAttachmentName("Ответ");

    public static RequestSpecification requestSpec(){
        return new RequestSpecBuilder()
                .setContentType("application/json")
                .setAccept("application/json")
                .addFilter(filterAllure)
                .log(LogDetail.ALL)
                .build();
    }


    @Step("Проверка Статус {statusCode}")
    public static ResponseSpecification checkStatusCode(Integer statusCode){
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectStatusCode(statusCode)
                .build();
    }
}
