package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SelenideElements {
    public final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#gender-radio-1"),
            numberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            subjectAutoCompileInput = $(".subjects-auto-complete__menu-list"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadImageInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateCityWrapperInput = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submitInput = $("#submit"),
            modalInput = $(".modal-content"),
            tableResponsiveInput = $(".table-responsive"),
            modalFooterInput = $(".modal-footer");
}
