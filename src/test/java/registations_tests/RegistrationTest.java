package registations_tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest{

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void succesfulRegistationForm(){
        String userName = "Artem";
        String lastName = "Test";
        String email = "test@mail.ru";
        String userNumber = "7778087999";
        String currentAddress = "Аль-Фараби 36";
        String day = "028";
        String subject = "Maths";


        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);

        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__year-select").$(byText("2004")).click();
        $(".react-datepicker__day--" + day + ":not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(subject);
        $(".subjects-auto-complete__menu-list").$(byText(subject)).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/test.png");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").click();
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(currentAddress));

        $(".modal-footer").lastChild().pressEnter();

    }


}
