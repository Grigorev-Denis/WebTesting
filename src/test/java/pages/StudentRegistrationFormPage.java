package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import elements.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.Builder;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static Helpers.TheExpectant.waitElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class StudentRegistrationFormPage {
    protected final String URL_STUDENT_REGFORM = "https://demoqa.com/automation-practice-form";
    protected final String COLOR_RED = "rgb(220, 53, 69)";

    protected final Input firstNameField = new Input("Поле ввода 'First Name'", $x(".//*[@placeholder=\"First Name\"]"));
    protected final Input lastNameField = new Input("Поле ввода 'Last Name'", $x(".//*[@placeholder=\"Last Name\"]"));
    protected final Input emailField = new Input("Поле ввода 'Email'", $x(".//*[@placeholder=\"name@example.com\"]"));
    protected final Input mobileNumberField = new Input("Поле ввода 'Mobile Number'", $x(".//*[@placeholder=\"Mobile Number\"]"));
    protected final RadioButton genderMale = new RadioButton("Радиобаттон 'Male'", $x("//*[@for=\"gender-radio-1\"]"));
    protected final RadioButton genderFemale = new RadioButton("Радиобаттон 'Female'", $x("//*[@for=\"gender-radio-2\"]"));
    protected final RadioButton genderOther = new RadioButton("Радиобаттон 'Other'", $x("//*[@for=\"gender-radio-3\"]"));
    protected final Input birthDateField = new Input("Поле ввода 'Birth Date'", $x(".//*[@id=\"dateOfBirthInput\"]"));
    protected final CheckBox hobbiesSport = new CheckBox("Чек-бокс 'Sport'", $x("//*[@for=\"hobbies-checkbox-1\"]"));
    protected final CheckBox hobbiesReading = new CheckBox("Чек-бокс 'Reading'", $x("//*[@for=\"hobbies-checkbox-2\"]"));
    protected final CheckBox hobbiesMusic = new CheckBox("Чек-бокс 'Music'", $x("//*[@for=\"hobbies-checkbox-3\"]"));
    protected final Input currentAddress = new Input("Поле 'Current Address'", $x("//*[@id=\"currentAddress\"]"));
    protected final SelenideElement City = $x(".//*[@id=\"react-select-7-option-0\"]");
    protected final Button buttonSubmit = new Button("Кнопка SUBMIT", $x(".//*[@id=\"submit\"]"));
    protected final Popup submittingForm = new Popup("Окно с результатом регистрации", $x("//*[@class=\"modal-content\"]"));
    protected final DropDown stateDropDown = new DropDown("Выпадающий список 'State'", $x("//*[@id=\"state\"]"));
    protected final DropDown cityDropDown = new DropDown("Выпадающий список 'City'", $x("//*[@id=\"city\"]"));
    protected final CollectionElements stateList = new CollectionElements("Список 'State'", $$x("//*[@class=\" css-11unzgr\"]"));
    protected final Input subjectsField = new Input("Поле ввода 'Subject'", $x("//*[@id=\"subjectsInput\"]"));
    protected final CollectionElements subjectsList = new CollectionElements("Список 'Subject'", $$x("//*[@class=\"subjects-auto-complete__menu css-26l3qy-menu\"]"));
    protected final CollectionElements cityList = new CollectionElements("Список 'City'", $$x("//*[@class=\" css-11unzgr\"]"));
    protected final Button closePopup = new Button("Кнопка закрытия окна результатов регистрации", $x("//*[@id=\"closeLargeModal\"]"));
    protected final Table resultTableHead = new Table("Оглавление таблицы", $x("//thead"));
    protected final Table resultTableBody = new Table("Таблица 'Результат регистрации'", $x("//tbody"));
    protected final Calendar calendar = new Calendar("Календарь", $x("//*[@class=\"react-datepicker\"]"));
    protected final SelenideElement fileDownload = $x("//*[@type=\"file\"]");


    @Step("Открыть форму регистрации")
    public void openRegPage() {
        Selenide.open(URL_STUDENT_REGFORM);
    }

    @Step("Ввод значение '{value}' в поле 'First Name'")
    public void setFirstName(String value) {
        firstNameField.setValue(value);
    }

    @Step("Кликнуть на поле 'First Name'")
    public void firstNameFieldClick() {
        firstNameField.clickToInput();
    }

    @Step("Ввод значение '{value}' в поле 'Last Name'")
    public void setLastName(String value) {
        lastNameField.setValue(value);
    }

    @Step("Кликнуть на поле 'Last Name'")
    public void LastNameFieldClick() {
        lastNameField.clickToInput();
    }

    @Step("Ввод значение '{value}' в поле 'Mobile Number'")
    public void setMobileNumber(String value) {
        mobileNumberField.setValue(value);
    }

    @Step("Кликнуть на поле 'Mobile Number'")
    public void mobileNumberFieldClick() {
        mobileNumberField.clickToInput();
    }

    @Step("Ввод значение '{value}' в поле 'Email'")
    public void setEmail(String value) {
        emailField.setValue(value);
    }

    @Step("Кликнуть на поле 'Email'")
    public void emailFieldClick() {
        emailField.clickToInput();
    }

    @Step("Ввод значение '{value}' в поле 'Birth Date' вместо дефолтного")
    public void setBirthDate(String value) {
        birthDateField.replaceValue(value);
    }

    @Step("Выбрать радиобаттон 'Male'")
    public void setGenderMale() {
        genderMale.clickRadioButton();
    }

    @Step("Выбрать радиобаттон 'Female'")
    public void setGenderFemale() {
        genderFemale.clickRadioButton();
    }

    @Step("Выбрать радиобаттон 'Other'")
    public void setGenderOther() {
        genderOther.clickRadioButton();
    }

    @Step("Ввод значение '{value}' в поле 'Current Address'")
    public void setCurrentAddress(String value) {
        currentAddress.setValue(value);
    }

    @Step("Нажать кнопку 'Submit'")
    public void clickSubmit() {
        buttonSubmit.buttonClickWithScroll();
    }

//    @Step("Проверить, что поле '{field.name}' подсвечено красным")
//    public void checkColorRed(Input field) {
//        String redColor = "rgb(220, 53, 69)";
//        String color = field.checkColor(redColor);
//        Assertions.assertEquals(redColor, color, "Цвет не соответствует");
//    }

//    @Step("Проверить, что поле '{field.name}' подсвечивается голубым при клике")
//    public void checkColorBlue(Input field) {
//        field.clickToInput();
//        String blueColor = "rgb(128, 189, 255)";
//        String color = field.checkColor(blueColor);
//        Assertions.assertEquals(blueColor, color, "Цвет не соответствует");
//    }

//    @Step("Проверить, что поле '{field.name}' подсвечивается зеленым")
//    public void checkColorGreen(Input field) {
//        String greenColor = "rgb(40, 167, 69)";
//        String color = field.checkColor(greenColor);
//        Assertions.assertEquals(greenColor, color, "Цвет не соответствует");
//    }


    @Step("Проверить что появилось модальное окно результата регистрации")
    public void modalIsVisible() {
        submittingForm.visibilityCheck();
    }

    @Step("Проверить закрытие модального окна")
    public void modalClose() {
        closePopup.buttonClickWithScroll();
    }

    @Step("Нажать на выпадающий список 'State'")
    public void dropDownStateClick() {
        stateDropDown.clickToDropDown();
    }

    @Step("Проверить что появился список 'State'")
    public void checkStatesList() {
        stateList.collectionIsVisible();
    }

    @Step("Выбрать первый элемент из списка 'State'")
    public void stateListClickFirst() {
        stateList.getElementByIndex(0);
    }

    @Step("Проверить что 'Select City' заблокирован")
    public void dropDownCityCheckBlock(){
    }

    @Step("Нажать на выпадающий список 'City'")
    public void dropDownCityClick() {
        cityDropDown.clickToDropDown();
    }

    @Step("Проверить что появился список 'City'")
    public void checkCityList() {
        cityList.collectionIsVisible();
    }

    @Step("Выбрать первый элемент из списка 'City'")
    public void cityListClickFirst() {
        cityList.getElementByIndex(0);
    }

    @Step("Выбрать чек бокс 'Sport'")
    public void sportRadioSelect() {
        hobbiesSport.checkBoxClick();
    }

    @Step("Выбрать чек бокс 'Reading'")
    public void readingRadioSelect() {
        hobbiesReading.checkBoxClick();
    }

    @Step("Выбрать чек бокс 'Music'")
    public void musicRadioSelect() {
        hobbiesMusic.checkBoxClick();
    }

    @Step("Заполнить поле 'Subjects'")
    public void setSubjects(String value){
        subjectsField.setValue(value);
        subjectsList.collectionIsVisible();
        subjectsList.getElementByIndex(0);
    }


    @Step("Получить все строки таблицы результата регистрации")
    public void getAllRows(){
        resultTableBody.getAllRows();
    }

    @Step("Получить колонку 'Label'")
    public void getFirstColumn(){
        resultTableBody.getColumnByIndex(1);
    }

    @Step("Получить колонку 'Values'")
    public void getSecondColumn(){
        resultTableBody.getColumnByIndex(2);
    }

    @Step("Проверить отображение календаря")
    public void calendarIsVisible(){
        birthDateField.clickToInput();
        calendar.checkCalendarIsVisible();
        birthDateField.escapeFromInput();
    }

    @Step("Проверить, что поле 'First Name' выделено красным цветом")
    public void firsNameCheckColorRed() {
        firstNameField.checkColor(COLOR_RED);
    }

    @Step("Проверить, что поле 'Last Name' выделено красным цветом")
    public void lastNameCheckColorRed() {
        lastNameField.checkColor(COLOR_RED);
    }

    @Step("Проверить, что поле 'Email' выделено красным цветом")
    public void emailCheckColorRed() {
        emailField.checkColor(COLOR_RED);
    }

    @Step("Проверить, что поле 'Mobile Number' выделено красным цветом")
    public void mobileNumberCheckColorRed() {
        mobileNumberField.checkColor(COLOR_RED);
    }

    @Step("Проверить, что радиобаттон 'Male' выделен красным цветом")
    public void genderMaleCheckColorRed() {
        genderMale.checkColor(COLOR_RED);
    }

    @Step("Проверить, что радиобаттон 'Female' выделен красным цветом")
    public void genderFemaleCheckColorRed() {
        genderFemale.checkColor(COLOR_RED);
    }

    @Step("Проверить, что радиобаттон 'Other' выделен красным цветом")
    public void genderOtherCheckColorRed() {
        genderOther.checkColor(COLOR_RED);
    }

    public void uploadFile(){
        File fileToUpload = new File("src/test/resources/photo.jpg");
        fileDownload.uploadFile(fileToUpload);
    }


}



