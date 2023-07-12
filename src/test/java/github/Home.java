package github;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Condition.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;



//public class Home {
//    @Test
//    void home() {
//        open("https://github.com/selenide/selenide");
//        $("#wiki-tab").click();
//        $(".markdown-body ul").shouldHave(text("Soft assertions"));
//        $(".markdown-body ul").$(byText("Soft assertions")).click();
//        $(".markdown-body").shouldHave(text("JUnit5"));
//
//        sleep(5000);


//    }
//}
/*
 - Откройте страницу Selenide в Github
         - Перейдите в раздел Wiki проекта
         - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
         - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
*/

public class Home {

    @Test
    @Disabled
    void home() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(".wiki-rightbar").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("JUnit5"));

        sleep(5000);
    }
}