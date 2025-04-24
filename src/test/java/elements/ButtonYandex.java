package elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


public class ButtonYandex {
    private SelenideElement buttonSelector;
    public ButtonYandex(SelenideElement button){
        this.buttonSelector= button;
    }
    @Step("Получить данные о кнопке \"Главный экран\"")
    public String getMainPageButtonSelectorText(){
        return buttonSelector.toString();
    }

}
