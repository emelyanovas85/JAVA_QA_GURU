package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import page.RegPage;

public class TestBase {
    public RegPage reg = new RegPage();

    @BeforeAll
    static void conf() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/";
//    Настройка времени ожидания прогрузки страницы
        Configuration.pageLoadTimeout = 50000;
//        Configuration.holdBrowserOpen=true;
//        Configuration.timeout = 3000;
    }
}
