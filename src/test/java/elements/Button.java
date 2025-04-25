package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Exist;
import com.codeborne.selenide.conditions.Visible;
import io.qameta.allure.Step;

import java.time.Duration;


public class Button {
    private final SelenideElement buttonSelector;
    public Button(SelenideElement button){

        this.buttonSelector= button;
    }

    @Step("Проверить доступность кнопки")
    public Button shouldExist(){
        buttonSelector.shouldBe(Condition.visible, Duration.ofSeconds(4));
        return this;
    }

    @Step("Кликаем на кнопку")
    public Button buttonClick(){
        buttonSelector.shouldBe(Condition.visible, Duration.ofSeconds(4)).click();
        return this;
    }

    @Step("Получить цвет кнопки")
    public String getColorOfButton(){
        return buttonSelector.getCssValue("fill");
    }

}
