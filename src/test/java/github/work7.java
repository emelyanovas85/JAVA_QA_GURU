package github;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Browsers.FIREFOX;

public class work7 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = FIREFOX;
        System.out.println("Это метод beforeAll");
    }

    @AfterAll
    static void afterAll() {
        Configuration.browser = FIREFOX;
        System.out.println("Это метод afterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Это метод beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Это метод afterEach");
    }

    @Test
    void firstTest() {
        System.out.println("Это тест firstTest");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void secondTest() {
        System.out.println("Это тест secondTest");
    }
}
