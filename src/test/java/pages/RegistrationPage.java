package pages;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.components.CalendarComponents;
import pages.components.SelenideElements;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage extends SelenideElements {

    CalendarComponents calendarComponents = new CalendarComponents();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = false;
    }

    private final String TITLE_TEXT = "Student Registration Form";

    public RegistrationPage openPage() {
        open("/automation-practice-form");
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

    public RegistrationPage setGender(){
        genderInput.parent().click();

        return this;
    }

    public RegistrationPage setNumber(String value){
      numberInput.setValue(value);

        return this;
    }

    public RegistrationPage setCalendar(String day, String month, String year) {
      calendarInput.click();
        calendarComponents.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjectsInput(String value){
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
