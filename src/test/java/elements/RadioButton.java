package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static Helpers.TheExpectant.waitElement;

public class RadioButton {
    private SelenideElement radioButtonSelector;
    private String radiobuttonName;

    public RadioButton(String radiobuttonName,SelenideElement radioButtonSelector) {
        this.radioButtonSelector = radioButtonSelector;
    }

    @Step("Выбрать радиокнопку")
    public void clickRadioButton(){
        radioButtonSelector.click();
    }

    @Step("Проверить цвет радиобаттона")
    public String checkColor(String color){
        radioButtonSelector.shouldBe(Condition.cssValue("border-color", color));
        return radioButtonSelector.getCssValue("border-color");
    }

}
