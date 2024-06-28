package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class cookiesTests {

    String BASE_URL = "https://www.otpbank.ru/";
    String LOREM_TEXT = "Продолжая просмотр сайта, вы даете согласие на обработку";

    @Test
    void closePopapModalCookiesTest() {
        open(BASE_URL);
        $(withText(LOREM_TEXT)).shouldBe(visible);
        $(".cookies-notification").$(byText("Закрыть")).click();
        $(withText(LOREM_TEXT)).shouldBe(hidden);
        sleep(3000);

    }
}

