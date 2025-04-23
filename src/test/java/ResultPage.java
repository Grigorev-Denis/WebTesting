import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.page;

public class ResultPage {
private SelenideElement mainPageButton = Selenide.$x("//*[@id=\"HeaderDesktop-PPJApIZ\"]//*[@fill=\"#F8604A\"]");
    @Step("Получить данные о кнопке 'Главный экран'")
public String getMainPageButtonSelectorText(){
     return mainPageButton.toString();
 }
}
