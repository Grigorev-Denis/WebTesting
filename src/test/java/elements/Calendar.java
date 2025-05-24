package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.With;

import java.time.Duration;

import static Helpers.TheExpectant.waitElement;

public class Calendar {
    private final SelenideElement selector;
    private String name;

    public Calendar(String name, SelenideElement element) {

        this.selector = element;
        this.name = name;
    }

    @Step("Проверить отображение")
    public void checkCalendarIsVisible(){
        selector.shouldBe(Condition.visible, Duration.ofSeconds(waitElement));
    }
}
