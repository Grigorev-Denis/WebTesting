import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

public class YandexTest {
    @Test
    @DisplayName("Проверка цвета иконки на странице выдачи")
    public void openYandex(){
        Selenide.open("https://ya.ru/");
        SelenideElement search = Selenide.$x(".//*[@placeholder=\"Найдётся всё\"]");
        search.sendKeys("Selenide maven зависимость");
        search.sendKeys(Keys.ENTER);
        SelenideElement defaultBrowserWindowClose = Selenide.$x(".//*[@class=\"Button Distribution-Button Distribution-ButtonClose Distribution-ButtonClose_view_button Button_view_default Button_size_m\"]");
        defaultBrowserWindowClose.click();
        SelenideElement iconRed = Selenide.$x("//*[@id=\"HeaderDesktop-PPJApIZ\"]//*[@fill=\"#F8604A\"]");
        String colorExp = "F8604A";
        String colorActual = iconRed.toString();
        Assertions.assertTrue(colorActual.contains(colorExp), "Цвет иконки отличается от красного");

    }

}