package tests;

import core.SelenoidExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

//@Disabled("Test")
@ExtendWith(SelenoidExtension.class)
public class TextBoxFormTest extends TestBase {

    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("UserName");
        $("#userEmail").setValue("UserEmail@email.com");
        $("#currentAddress").setValue("CurrentAddress");
        $("#permanentAddress").setValue("PermanentAddress");
        $("#submit").click();

        $("#output").shouldHave(text("UserName"), text("UserName"), text("UserEmail@email.com"), text("CurrentAddress"), text("PermanentAddress"));
        System.out.println("В выводе есть весь текст из формы");

    }

}
