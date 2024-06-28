package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AddTranslationsTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void AddTranslation() {
        open("https://admintest5.jmart.kz/");
        $x("/html/body/div[2]/div/div/form/div/div/div[2]/input").setValue("dev_test_admin@email.com");
        $x("/html/body/div[2]/div/div/form/div/div/div[3]/input").setValue("Test_4dmin_Jmart");
        $x("/html/body/div[2]/div/div/form/div/div/button").click();

        $x("//a[@href='https://admintest5.jmart.kz/translation/index']").shouldBe(visible, Duration.ofSeconds(30)).click();
//
//        $x("//*[@id=\"filename_ru\"]").scrollTo().uploadFromClasspath("img/example.json");
//        $x("//*[@id=\"filename_kz\"]").uploadFromClasspath("img/example.json");
//        $x("//*[@id=\"filename_en\"]").uploadFromClasspath("img/example.json");

//        $x("//*[@id=\"translation_type\"]/option[3]").click();


//        $x("//*[@id=\"vue-app\"]/div[2]/div[2]/form/div[2]/div/input").click();
//        $x("//input[@value=\"Загрузить\"]").click();
//        "//input[@value=\"Загрузить\"]"

//        $x("#slug").click();
        $("#slug").setValue("qqq");
        $x("//button[text()=\"Применить\"]").shouldBe(visible, Duration.ofSeconds(30)).click();



        $x("//tbody/tr").$(byText("qqq"))
                        .parent().shouldHave(text("Дата начисления"));


        sleep(5000);


    }

}
