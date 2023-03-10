package blow.back;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormWithPageObjectsTest extends TestBase {


  @Test
  void fillFormTest() {

    registrationPage.openPage()
            .setFirstName("Dmitry")
            .setLastName("Plotnikov")
            .setEmail("kokoko@koko.ru")
            .setGender("Other")
            .setNumber("9008007000")
            .setBirthday("27", "June", "2000")
            .setSubjects("English")
            .setHobbies("Music")
            .uploadFoto()
            .setAddress("SDFSDFS")
            .setStateAndCity("NCR", "Delhi")
            .pressEnter();


    registrationPage.verifyResultsAppearModal()
            .verifyResult("Student Name", "Dmitry Plotnikov")
            .verifyResult("Student Email", "kokoko@koko.ru")
            .verifyResult("Gender", "Other")
            .verifyResult("Mobile", "9008007000")
            .verifyResult("Date of Birth", "27 June,2000")
            .verifyResult("Subjects", "English")
            .verifyResult("Hobbies", "Music")
            .verifyResult("Picture", "Fotka.jpg")
            .verifyResult("Address", "SDFSDFS")
            .verifyResult("State and City", "NCR Delhi");


    $("#closeLargeModal").click();

  }
}
