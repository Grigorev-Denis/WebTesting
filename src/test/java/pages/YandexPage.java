package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import elements.InputArea;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.page;

public class YandexPage {
    private final String URL = "https://ya.ru/";
    private final SelenideElement searchField = Selenide.$x(".//*[@placeholder=\"Найдётся всё\"]");

    @Step("Открыть главную страницу поиска Яндекс")
    public void openPage(){
        Selenide.open(URL);
    }

    public InputArea searchArea= new InputArea(searchField);


}
