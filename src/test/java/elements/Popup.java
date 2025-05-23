package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static Helpers.TheExpectant.waitElement;

public class Popup {
    private SelenideElement selector;
    private String name;

    public Popup(String name, SelenideElement selector) {
        this.selector = selector;
        this.name = name;
    }

    @Step("Проверить доступность модального окна")
    public void visibilityCheck(){
        selector.shouldBe(Condition.visible, Duration.ofSeconds(waitElement));
    }

    @Step("Проверить, что модальное окно не отображается")
    public void NotVisibilityCheck(){
        selector.shouldBe(Condition.not(Condition.visible), Duration.ofSeconds(waitElement));
    }

    @Step("Закрыть модальное окно")
    public void closeModalWithEscape(){
        selector.shouldBe(Condition.visible, Duration.ofSeconds(waitElement));
        selector.click();
        selector.sendKeys(Keys.ESCAPE);
    }
}
