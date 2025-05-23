package elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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
}
