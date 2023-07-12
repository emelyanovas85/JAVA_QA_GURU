package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.exactTextCaseSensitive;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Home4 {
    @Test
    @Disabled
    void git() {
        open("https://github.com/");
        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $(".application-main").shouldHave(text("Build like the best"));
//                $(byText("Solutions")).hover();
//        $(".list-style-none").$(byText("Enterprize")).click();
//        $(".HeaderMenu-item").$(byText("S")).hover();
//                HeaderMenu-link.$(byText(" Solutions ")).click();
        sleep(5000);

    }

/*
1. На главной странице GitHub выберите меню Solutions -> Enterprise
с помощью команды hover для Solutions. Убедитесь что загрузилась нужная страница
(например что заголовок - "Build like the best."
*/

    @Test
    @Disabled
    void home4() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $$(".column").first().shouldHave(exactTextCaseSensitive("B"));
        sleep(5000);
    }

    @Test
    @Disabled
    void home4_2() {
        Configuration.browserSize="1920х1080";
        open("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement eleA = $("#column-a");
        WebElement eleB = $("#column-b");
        WebElement eleC = $("#page-footer");
        WebElement eleD = $(byText("B"));

//        actions().moveToElement(eleA).clickAndHold().moveToElement(eleB);
////        $("#column-b").hover();
//        $$(".column").first().shouldHave(exactTextCaseSensitive("B"));
//        sleep(5000);

        actions().moveToElement(eleA).clickAndHold().
                moveByOffset(270,0).release().build().perform();
        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
    }
}

/*
опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()
 - Откройте https://the-internet.herokuapp.com/drag_and_drop
 - Перенесите прямоугольник А на место В
 - Проверьте, что прямоугольники действительно поменялись
 - В Selenide есть команда $(element).dragAndDrop($(to-element)),
 проверьте работает ли тест, если использовать её вместо actions()
*/