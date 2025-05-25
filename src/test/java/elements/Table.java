package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;


public class Table {
    private SelenideElement selector;
    private String name;

    public Table(String name, SelenideElement selector) {
        this.selector = selector;
        this.name = name;
    }


    @Step("Получить все строки")
    public List<String> getAllRows() {
        List<String> rows = new ArrayList<String>();

        ElementsCollection rowsElements = selector.$$x(".//tr");
        for (SelenideElement el: rowsElements){
            rows.add(el.getText());
        }
        return rows;
    }

    @Step("Получить столбец по индексу {index}")
    public List<String> getColumnByIndex(Integer index) {
        List<String> column = new ArrayList<String>();
        ElementsCollection trs = selector.$$x(".//tr"); // коллекция из tr ов
        for (SelenideElement tr: trs){
            ElementsCollection tds = tr.$$x(".//td[" + index + "]");
            for (SelenideElement td: tds){
                column.add(td.getText());
            }
        }
        return column;
    }

}

