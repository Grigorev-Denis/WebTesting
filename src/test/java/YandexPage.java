import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.page;

public class YandexPage {
    private final String URL = "https://ya.ru/";
    private String searchField = ".//*[@placeholder=\"Найдётся всё\"]";

    @Step("Открыть главную страницу поиска Яндекс")
    public void openPage(){
        Selenide.open(URL);
    }

    @Step("Ввод в поле поиска")
    public void search(String text){
        SelenideElement searchInput = Selenide.$x(searchField);
        searchInput.sendKeys(text);
        searchInput.sendKeys(Keys.ENTER);
    }

}
