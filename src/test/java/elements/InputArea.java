package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.time.Duration;

public class InputArea {
    private SelenideElement inputAreaSelector;

    public InputArea(SelenideElement area){
        this.inputAreaSelector = area;
    }

    @Step("Проверить доступность поля ввода")
    public void visibilityCheck(){
        inputAreaSelector.shouldBe(Condition.visible, Duration.ofSeconds(4));
    }

    @Step("Ввод в поле поиска + Поиск")
    public void searchValue(String text){
        inputAreaSelector.sendKeys(text);
        inputAreaSelector.sendKeys(Keys.ENTER);
    }
}
