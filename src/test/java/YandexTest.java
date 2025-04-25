import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ResultPage;
import pages.YandexPage;

public class YandexTest {

    @Test
    @DisplayName("Проверка цвета иконки на странице выдачи красная(цвет = \"rgb(248, 96, 74)\")")
    public void openYandex1(){
        YandexPage yandexPage = new YandexPage();
        yandexPage.openPage();
        yandexPage.searchArea.visibilityCheck(); // проверить доступность поля поиска
        yandexPage.searchArea.searchValue("Проверка теста"); // ввести и найти значение
        ResultPage resultPage = new ResultPage();
        resultPage.closePopup.shouldExist().buttonClick();// закрыть попап
        String actColor = resultPage.buttonInResult.getColorOfButton(); //получить цвет кнопки
        Assertions.assertEquals("rgb(248, 96, 74)", actColor, "Цвет иконки отличается от красного");
    }
}