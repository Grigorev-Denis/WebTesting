package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static Helpers.TheExpectant.waitElement;

public class DropDown {
    private SelenideElement selector;
    private String name;

    public DropDown(String name, SelenideElement selector) {
        this.selector = selector;
        this.name = name;
    }


    @Step("Нажать на выпадающий список")
    public void clickToDropDown() {
        selector.scrollTo().shouldBe(Condition.enabled, Duration.ofSeconds(waitElement)).click();
    }

    @Step("Ввести текст в DropDown")
    public void setValueInDropDown(String value) {
        selector.scrollTo().shouldBe(Condition.visible, Duration.ofSeconds(waitElement)).setValue(value);
    }

    @Step("Закрыть выпадающий список")
    public void dropDownEscape() {
        selector.sendKeys(Keys.ESCAPE);
    }

    @Step("Проверить блокировку DropDown")
    public void dropDownCheckBlock(){
        selector.scrollTo().shouldBe(Condition.cssValue("background-color", "rgb(242, 242, 242)"));
    }
}


