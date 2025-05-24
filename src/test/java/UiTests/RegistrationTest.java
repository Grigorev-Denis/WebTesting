package UiTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;


@DisplayName("Тесты формы регистрации студента")
public class RegistrationTest extends BaseTest {
    StudentRegistrationFormPage page = new StudentRegistrationFormPage();

//    @Test
//    @DisplayName("Зарегистрировать студента(только обязательные поля)")
//    @Owner("Григорьев Денис")
//    @Description("Проверка регистрации студента при заполнении только обязательных полей")
//    @Tag("smoke")
//    @Tag("UI")
//    public void studentRegistry(){
//        Configuration.pageLoadTimeout= 60000;
//        page.openRegPage();
//        page.setFirstName("Denis");
//        page.setLastName("Grigorev");
//        page.setGenderMale();
//        page.setMobileNumber("1234567890");
//        page.setBirthDate("10 May 1990");
//        page.clickSubmit();
//        page.modalIsVisible();
//        page.modalCloseWithEscape();
//    }
//


   // @Test
    @DisplayName("Зарегистрировать студента(заполнены все поля)")
    @Owner("Григорьев Денис")
    @Description("Проверка регистрации студента при заполнении всех полей")
    @Tag("UI")



//
//    @Test
//    @DisplayName("Проверка обязательности полей")
//    @Owner("Григорьев Денис")
//    @Description("Проверить, что при регистрации к заполнению обязательны поля: Имя, Фамилия, Номер телефона, Дата рождения, выбор пола." +
//            "При отсутствии одного/нескольких из значений не должна происходить регистрация")
//    @Tag("smoke")
//    @Tag("UI")
//    public void checkingWhetherFields(){
//        page.openRegPage();
//        page.clickSubmit();
//        page.modalIsNotVisible(); // ждать 5 сек
//        page.setFirstName("Imya");
//        page.clickSubmit();
//        page.modalIsNotVisible();
//        page.setLastName("Familia");
//        page.clickSubmit();
//        page.modalIsNotVisible();
//        page.setBirthDate("10 October 1998");
//        page.clickSubmit();
//        page.modalIsNotVisible();
//        page.setMobileNumber("9997775553");
//        page.clickSubmit();
//        page.modalIsNotVisible();
//        page.setGenderOther();
//        page.clickSubmit();
//        page.modalIsVisible();
//    }
//
//
//    @Test
//    @DisplayName("Проверка подсветки полей")
//    @Owner("Григорьев Денис")
//    @Description("Проверить, что поля подсвечиваются красным(если не заполнено обязательное поле)," +
//            " голубым(при фокусировке на пустом поле), зеленым(при подсказке обязательных/необязательных полей)")
//    @Tag("UI")
//    public void checkingTheColorOfFields(){
//        page.openRegPage();
//        page.firstNameFieldClick();
//        page.checkColorBlue(page.getFirstNameField());
//
//
//
//    }
    //@Test
    public void test() {
     page.openRegPage();
     page.dropDownStateClick();
     page.checkStatesList();
     page.stateListClickFirst();
     page.dropDownCityClick();
     page.checkCityList();
     page.cityListClickFirst();
    }

    @Test
    public void checks(){
        page.openRegPage();
        page.setFirstName("Denis");
        page.setLastName("Grigorev");
        page.setGenderMale();
        page.setMobileNumber("1234567890");
        page.setSubjects("Maths");
        page.setBirthDate("10 May 1990");
        page.calendarIsVisible();
        page.musicRadioSelect();
        page.sportRadioSelect();
        page.readingRadioSelect();
        page.dropDownStateClick();
        page.stateListClickFirst();
        page.dropDownCityClick();
        page.cityListClickFirst();
        page.setCurrentAddress("Kazan");
        page.uploadFile();
        page.clickSubmit();
        page.modalIsVisible();
        page.getFirstColumn();
        page.getSecondColumn();

       // Selenide.sleep(6000000);
    }

}

