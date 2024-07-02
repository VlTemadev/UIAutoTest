package pages;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.TestConfig;
import core.SelenoidExtension;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.components.CalendarComponents;
import pages.components.SelenideElements;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@ExtendWith(SelenoidExtension.class)

public class RegistrationPage extends SelenideElements {
    
    @BeforeEach
    void testBase() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    static TestConfig config = ConfigFactory.create(TestConfig.class);

    CalendarComponents calendarComponents = new CalendarComponents();
    private final String TITLE_TEXT = "Student Registration Form";

    public RegistrationPage openPage() {
        open(config.demoqa_url() + "/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue((value));

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue((value));

        return this;
    }

    public RegistrationPage setGender() {
        genderInput.parent().click();

        return this;
    }

    public RegistrationPage setNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public RegistrationPage setCalendar(String day, String month, String year) {
        calendarInput.click();
        calendarComponents.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjectsInput(String value) {
        subjectsInput.setValue(value);
        subjectAutoCompileInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUploadPicture() {
        uploadImageInput.uploadFromClasspath("img/test.png");

        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        stateCityWrapperInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateCityWrapperInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setSubmit() {
        submitInput.click();

        return this;
    }

    public RegistrationPage resultVerify(String verifyText, String currentAddress) {
        modalInput.click();
        modalInput.shouldHave(text(verifyText));
        tableResponsiveInput.shouldHave(text(currentAddress));
        modalFooterInput.lastChild().pressEnter();

        return this;
    }

}
