package demoqa;

import Data.Locale;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest7 extends TestBase {


//    @CsvSource({"Андрей, Емельянов",
//            "Людмила, Емельянова"})
    @ValueSource(strings = {"Андрей", "Людмила"}) //для передачи одного арргумента с одним типом данных
    @CsvFileSource (resources = "/testData.scv")
    @ParameterizedTest (name = "Супер тест с именем {0} и фамилией {1}")
//    @DisplayName("Супер тест") пишут только в непараметризованном тесте
    @Tags({@Tag("critical"), @Tag("registration")})
    void dZ(
            String FirstNameData,
            String LastNameData,
            Locale locale,
            List<String> buttons
    ) {
        String FirstName = FirstNameData;
        String LastName = LastNameData;
        String Email = "emelyanovas85@mail.ru";

        reg.openPage()
                .setFirstName(FirstName)
                .setLastName(LastName) // простой вариант с this
                .setBirthData("05", "October", "1985");
        reg.setEmail(Email); // можно так

        $("#genterWrapper").$(".custom-control-inline", 0).click();
        $("label[for=gender-radio-3]").click();
        $("#userNumber").setValue("1234567890");
        $("#subjectsInput").setValue("a");
        $(byText("Arts")).click();
        $("#hobbiesWrapper").$(".custom-control-inline", 2).click();
        $("#uploadPicture").uploadFile(new File("/Users/eas/Desktop/9ce2d3974b3dd6ca57cf9491b23c9949.jpg"));
        $("#uploadPicture").uploadFromClasspath("rty/123.png");
        WebElement a = $("#state");
        $("#currentAddress").setValue("gythgytgyhtygyhtyghythgythYYY");
        $("#state").scrollTo().click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $(".btn.btn-primary").click();

        reg.veryfyTab()
                .veryfyonestringtabvalue("Student Name", FirstName + " " + LastName)
                .veryfyonestringtabvalue("Student Email", Email);
//        $("gender-radio-2").parent().click();
//        $("#dateOfBirthInput").click();
//        $(".col-md-9.col-sm-12").selectRadio("Female"); //bad
//        $("#firstName").setValue("First Name");
//        $("#firstName").setValue("First Name");



//        $(".subjects-auto-complete__option").
//        $(".react-datepicker__month-select").click();
//        $(byText("October")).click();
//        $(".react-datepicker__month-select").selectOption("October");
//        $(".react-datepicker__month-select").selectOptionByValue("10");
//        $(".react-datepicker__year-select").click();
//        $(byText("1985")).click();
//        $(by("aria-label", "Choose Saturday, October 5th, 1985")).click();
//        $(".react-datepicker__day--001:not(react-datepicker__day--outside-month)").click();
//        $x("//*[@class=react-datepicker__day--001][:not(contains(@class, 'react-datepicker__day--outside-month'))]").click();

//        $(".modal-content").should(appear);
//        $(".modal-header").shouldHave(text("Thanks for submitting the form")).shouldBe(visible);
//        $(".table.table-dark").shouldHave(text(FirstName), text(Email));
//        $("#closeLargeModal").scrollTo().click();

        locale.name(); // встроенный метод

        sleep(5000);
    }

    @Test
    @Disabled("Причина или ссылка на дефект, т.е. почему отключен")
    void fillFormTest() {

        open("text-box");
        $(".main-header").shouldHave(text("Text Box"));

        $("#userName").setValue("andr");
        $("#userEmail").setValue("ad@ad.ru");
        $("#currentAddress").setValue("rrrrr");
        $("#permanentAddress").setValue("rchvhecNINi123345#$@$");
        $("#submit").click();

        $("#output").shouldBe(visible).shouldHave();

        $("#name").shouldHave(text("andr"));
        $("#email").shouldHave(text("ad@ad.ru"));
        $(".border #currentAddress").shouldHave(text("rrrrr"));
        $(".border #permanentAddress").shouldHave(text("rchvhecNINi123345#$@$"));

        sleep(5000);
    }

//$("#firstName").remove();   удаление элемента из консоли
}
