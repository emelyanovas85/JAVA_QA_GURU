package github;

import static com.codeborne.selenide.Selectors.*;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class BestC {

    @Test
    @Disabled
    void shouldSoln(){
//        Configuration.browserSize="200x100";
        open("https://github.com/selenide/selenide");
        $(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();
        $$(".Popover .Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
        sleep(5000);
    }
}
//    setTimeout (function () {debugger;}, 4000)
// hjkjh