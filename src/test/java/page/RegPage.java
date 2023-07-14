package page;

import com.codeborne.selenide.SelenideElement;
import page.components.CalendarComponent;
import page.components.RegResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegPage extends CalendarComponent {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegResultsModal regResults = new RegResultsModal();

    private final String
            TITLE_TXT = "Practice Form";
    private final SelenideElement
            FIRSTNAME_SELECTOR = $("#firstName"),
            LASTNAME_SELECTOR = $("#lastName"),
            EMAIL_SELECTOR = $("#userEmail"),
            RADIO_BUT_MALE_SELECTOR = $("label[for=gender-radio-1]"),
            RADIO_BUT_FEMALE_SELECTOR = $("label[for=gender-radio-2]"),
            RADIO_BUT_OTHER_SELECTOR = $("label[for=gender-radio-3]"),
            NUMBER_TELEPHONE_SELECTOR = $("#userNumber"),
            SUBJECTS_SELECTOR = $(".subjects-auto-complete__input input"),
            HOBBIES_SPORT_SELECTOR = $(byText("Sport")),
            HOBBIES_READING_SELECTOR = $(byText("Reading")),
            HOBBIES_MUSIC_SELECTOR = $(byText("Music")),
            LOAD_PICTURE_SELECTOR = $("#uploadPicture"),
            CURRENT_ADDRESS_SELECTOR = $("#currentAddress"),
            STATE_SELECTOR = $("#state"),
            CITY_SELECTOR = $("#city"),
            BUTTON_SUBMIT_SELECTOR = $(".btn.btn-primary");
    public RegPage openRegPageAndDelBanners() {
        open("automation-practice-form");
        $(".main-header").shouldHave(text(TITLE_TXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegPage setFirstName(String value) {
        $(FIRSTNAME_SELECTOR).setValue(value);
        return this;
    }

    public RegPage setFirstName() {
        $(FIRSTNAME_SELECTOR).setValue("DefaultName");
        return this;
    }

    public RegPage delFirstName() {
        $(FIRSTNAME_SELECTOR).clear();
        return this;
    }

    public RegPage setLastName(String value) {
        LASTNAME_SELECTOR.setValue(value);
        return this;
    }

    public RegPage setEmail(String value) {
        EMAIL_SELECTOR.setValue(value);
        return this;
    }
    public RegPage chooseGender(String value) {
        switch (value) {
            case "Other": RADIO_BUT_OTHER_SELECTOR.click(); break;
            case "Female": RADIO_BUT_FEMALE_SELECTOR.click(); break;
            case "Male": RADIO_BUT_MALE_SELECTOR.click(); break;
        }
        return this;
    }

    public RegPage setTelephoneNumber(String value) {
        NUMBER_TELEPHONE_SELECTOR.setValue(value);
        return this;
    }

    public RegPage setDateOfBirthDayMonthYear(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setData(day, month, year);
        return this;
    }

    public RegPage setSubjects(String value) {
        SUBJECTS_SELECTOR.setValue(value).pressEnter();
//        $(byText(value)).click();
        return this;
    }

    public RegPage setHobbies(String value) {
        switch (value) {
            case "Sports": HOBBIES_SPORT_SELECTOR.click(); break;
            case "Music": HOBBIES_MUSIC_SELECTOR.click(); break;
            case "Reading": HOBBIES_READING_SELECTOR.click(); break;
        };
        return this;
    }

    public RegPage loadPicture(String path) {
        LOAD_PICTURE_SELECTOR.uploadFile(new File(path));
        return this;
    }

    public RegPage setCurrentAddress(String value) {
        CURRENT_ADDRESS_SELECTOR.setValue(value);
        return this;
    }

    public RegPage setState(String value) {
        STATE_SELECTOR.click();
        $(byText(value)).click();
        return this;
    }

    public RegPage setCity(String value) {
        CITY_SELECTOR.click();
        $(byText(value)).click();
        return this;
    }

    public RegPage pushButtonSubmit() {
        BUTTON_SUBMIT_SELECTOR.click();
        return this;
    }

    public RegPage verifyTabTitle() {
        regResults.checkResultsTableUI();
//        $("#closeLargeModal").scrollTo().click();
        return this;
    }
    public RegPage verifyOneStringTabValue(String key, String value) {
        regResults.checkValue(key, value);
        return this;
    }
}
