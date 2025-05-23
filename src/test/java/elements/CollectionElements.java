package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static Helpers.TheExpectant.waitElement;

public class CollectionElements {

    private ElementsCollection selector;
    private String name;
    public CollectionElements(String name, ElementsCollection selector) {
        this.selector = selector;
        this.name = name;
    }

    @Step("Проверка отображения списка")
    public void collectionIsVisible(){
        for(SelenideElement element : selector){
            element.shouldBe(Condition.visible,Duration.ofSeconds(waitElement));
        }
    }

    @Step("Выбрать элемент по индексу")
    public void getElementByIndex(Integer index){
        SelenideElement el = selector.get(index);
        el.click();
    }


}
