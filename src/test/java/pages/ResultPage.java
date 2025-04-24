package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import elements.ButtonYandex;
import io.qameta.allure.Step;


public class ResultPage {
    private SelenideElement mainPageButton = Selenide.$x("//*[@id=\"HeaderDesktop-PPJApIZ\"]//*[@fill=\"#F8604A\"]");
    private SelenideElement closePopupButton = Selenide.$x(".//*[@class=\"Button Distribution-Button Distribution-ButtonClose Distribution-ButtonClose_view_button Button_view_default Button_size_m\"]");

    @Step("Закрыть окно \"Браузер по умолчанию\"")
    public void closePopup(){
        closePopupButton.click();
    }

    public ButtonYandex button(){
        ButtonYandex butYan = new ButtonYandex(mainPageButton);
        return butYan;
    }
}
