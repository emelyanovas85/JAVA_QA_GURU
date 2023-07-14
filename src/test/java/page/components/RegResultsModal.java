package page.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegResultsModal {
    public void checkResultsTableUI() {
        $(".modal-content").should(appear);
        $(".modal-header").shouldHave(text("Thanks for submitting the form")).shouldBe(visible);
    }
    public void checkValue(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }
}
