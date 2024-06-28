package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static pages.testData.TestData.*;

public class RegistrationTest extends RegistrationPage {

    @Test
    void successfulRegistrationForm() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Отерытие страницы", this::openPage);
        step("Заполнение username и lastname", () -> setFirstName(userName).setLastName(lastName));
        step("Заполнение адреса и номера", () -> setEmail(email).setGender().setNumber(userNumber));
        step("Заполнение календаря", () -> setCalendar(day, month, year));
        step("Заполненеи subject and hobbies", () -> setSubjectsInput(subject).setHobbies(hobbies));
        step("Заполнение изображения и адреса", () -> setUploadPicture().setAddress(currentAddress));
        step("Заполнение штата и города", () -> setState(state).setCity(city).setSubmit());
        step("Проверка результата", () -> resultVerify(verifyText, currentAddress));

    }


}
