import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class PopupDefaultBrowser {
    SelenideElement closePopupButton = Selenide.$x(".//*[@class=\"Button Distribution-Button Distribution-ButtonClose Distribution-ButtonClose_view_button Button_view_default Button_size_m\"]");
    @Step("Закрыть окно - Браузер по умолчанию")
    public void closePopup(){
        closePopupButton.click();
    }
}
