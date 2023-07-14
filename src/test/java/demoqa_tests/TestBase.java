package demoqa_tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import page.RegPage;

public class TestBase {
    public RegPage regPage = new RegPage();

    @BeforeAll
    static void conf() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/";

//    Настройка времени ожидания прогрузки страницы
        Configuration.pageLoadTimeout = 50000;

//        Настройка для того чтобы браузер не закрывался
        Configuration.holdBrowserOpen=true;

//        Configuration.timeout = 3000;
    }
}
