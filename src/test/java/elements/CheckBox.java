package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static Helpers.TheExpectant.waitElement;

public class CheckBox {
    private final SelenideElement selector;
    private String name;

    public CheckBox(String name, SelenideElement element) {

        this.selector = element;
        this.name = name;
    }
    @Step("Чек-бокс  выбран")
    public void checkBoxOn(){
        selector.shouldBe(Condition.visible,Duration.ofSeconds(waitElement)).setSelected(true);
    }

    @Step("Чек-бокс не выбран")
    public void checkBoxOff(){
        selector.setSelected(false);
    }

    @Step("Кликнуть чек-бокс")
    public void checkBoxClick(){
       // selector.
    }
}

