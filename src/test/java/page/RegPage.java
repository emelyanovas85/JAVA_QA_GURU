package page;

import com.codeborne.selenide.SelenideElement;
import page.components.CalendarComponent;
import page.components.RegResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegPage extends CalendarComponent {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegResultsModal regResults = new RegResultsModal();

    private final String
            TITLETXT = "Practice Form";
    private final SelenideElement
            FIRSTNAME = $("#firstName"),
            LASTNAME = $("#lastName"),
            EMAIL = $("#userEmail");

    public RegPage openPage() {
        open("automation-practice-form");
        $(".main-header").shouldHave(text(TITLETXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegPage setFirstName(String value) {
        $(FIRSTNAME).setValue(value);
        return this;
    }

    public RegPage setFirstName() {
        $(FIRSTNAME).setValue("DefaultName");
        return this;
    }

    public RegPage delFirstName() {
        $(FIRSTNAME).clear();
        return this;
    }

    public RegPage setLastName(String value) {
        LASTNAME.setValue(value);
        return this;
    }

    public RegPage setEmail(String value) {
        EMAIL.setValue(value);
        return this;
    }

    public RegPage setBirthData(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setData(day, month, year);
        return this;
    }

    public RegPage veryfyTab() {
        regResults.regResultsChek();
//        $("#closeLargeModal").scrollTo().click();
        return this;
    }
    public RegPage veryfyonestringtabvalue(String key, String value) {
        regResults.checkValue(key, value);
        return this;
    }
}
