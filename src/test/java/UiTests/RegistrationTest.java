package UiTests;

import Helpers.StudentData;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;


@DisplayName("Тесты формы регистрации студента")
public class RegistrationTest extends BaseTest {
    StudentRegistrationFormPage page = new StudentRegistrationFormPage();
    StudentData student = new StudentData();

    @Test
    @Tag("UI")
    @DisplayName("Зарегистрировать студента(заполнены все поля)")
    @Owner("Григорьев Денис")
    @Description("Проверка регистрации студента при заполнении всех полей// Проверка таблицы результатов")

    public void registrationTest(){
        page.openRegPage();
        page.setFirstName(student.getFirstName());
        page.setLastName(student.getLastName());
        page.setEmail(student.getEmail());
        page.setGenderMale();
        page.setMobileNumber(student.getMobileNum());
        page.setSubjects(student.getSubject());
        page.setBirthDate(student.getDateOfBirth());
        page.calendarIsVisible();
        page.sportRadioSelect();
        page.readingRadioSelect();
        page.musicRadioSelect();
        page.dropDownStateClick();
        page.stateListClickFirst();
        page.dropDownCityClick();
        page.cityListClickFirst();
        page.setCurrentAddress(student.getCurrentAddress());
        page.uploadFile(student.getPicture());
        page.clickSubmit();
        page.modalIsVisible();
        page.checkResult(student.dataList);

    }

    @Test
    @Tag("UI")
    @DisplayName("Проверка обязательности полей")
    @Owner("Григорьев Денис")
    @Description("Проверить, что регистрация не завершиться, если не заполнены все обязательные поля.// Проверить что " +
            "незаполненные обязательные поля выделяются красным цветом")
    public void validTest(){
        page.openRegPage();
        page.clickSubmit();
        page.modalIsNotVisible();
        page.checkAllColorRed();
    }



    @Test
    @Tag("UI")
    @DisplayName("Проверка формата полей 'Email','Mobile number'")
    @Owner("Григорьев Денис")
    @Description("1) Проверить, что поле 'Email' принимает только строку в формате 'name@example.com'." +
            "2) Проверить, что поле 'Mobile number' ринимает строго 10 числовых значений .")
    public void formatTest(){
        page.openRegPage();
        page.setEmail("Строка без точки и собачки");
        page.setMobileNumber("123456789");
        page.clickSubmit();
        page.emailCheckColorRed();
        page.mobileNumberCheckColorRed();
        page.cleanMobileNumberField();
        page.setMobileNumber("вапершгнвп"); // 10 нечисел
        page.clickSubmit();
        page.mobileNumberCheckColorRed();
    }

}

