import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static pages.testData.TestData.*;

public class RegistrationTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationForm() {

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender()
                .setNumber(userNumber)
                .setCalendar(day, month, year)
                .setSubjectsInput(subject)
                .setHobbies(hobbies)
                .setUploadPicture()
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .setSubmit()
                .resultVerify(verifyText, currentAddress);
    }


}
