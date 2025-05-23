package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static Helpers.TheExpectant.waitElement;

public class Input {
    private SelenideElement inputSelector;
    private String name;

    public Input(String name, SelenideElement inputSelector) {
        this.inputSelector = inputSelector;
        this.name = name;
    }

    @Step("Проверить доступность поля ввода")
    public void visibilityCheck(){
        inputSelector.shouldBe(Condition.visible, Duration.ofSeconds(waitElement));
    }

    @Step("Ввод в поле '{value}' + Enter")
    public void searchValue(String value){
        inputSelector.sendKeys(value);
        inputSelector.sendKeys(Keys.ENTER);
    }

    @Step("Вводим значение '{value}'")
    public void setValue(String value){
        inputSelector.sendKeys(value);
    }

    @Step("Заменить дефолтный текст в поле на '{value}'")
    public void replaceValue(String value){
        inputSelector.sendKeys(Keys.CONTROL+"a");
        inputSelector.sendKeys(value);
    }

    @Step("Стереть содержимое поля")
    public void clearValue(String value) {
        inputSelector.sendKeys(Keys.CONTROL + "a");
        inputSelector.sendKeys(Keys.DELETE);
    }

    @Step("Проверяем наличие поля ввода")
    public void existsInput(){
        Assertions.assertTrue(inputSelector.exists(),"Элемент отсутствует на странице");
    }

    @Step("Ввести в поле '{input.name}' значение '{value}'")
    public static void setValueIn(Input input, String value){
        input.inputSelector.sendKeys(value);
    }

    @Step("Получить цвет поля")
    public String checkColor(String color){
        inputSelector.shouldBe(Condition.cssValue("border-color", color));
        return inputSelector.getCssValue("border-color");
    }

    @Step("Кликнуть на поле")
    public void clickToInput(){
        inputSelector.click();
    }
}
