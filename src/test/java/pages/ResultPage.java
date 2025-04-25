package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import io.qameta.allure.Step;


public class ResultPage {
    private final SelenideElement mainPageButton = Selenide.$x("//*[@data-type=\"header-desktop\"]//*[@fill=\"#F8604A\"]");
    private final SelenideElement closePopupButton = Selenide.$x(".//*[@class=\"Button Distribution-Button Distribution-ButtonClose Distribution-ButtonClose_view_button Button_view_default Button_size_m\"]");

    public Button buttonInResult = new Button(mainPageButton);  // иконка/кнопка яндекса
    public Button closePopup = new Button(closePopupButton);  // кнопка закрытия всплывающего окна

}
