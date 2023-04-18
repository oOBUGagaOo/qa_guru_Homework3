package blow.back;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormWithPageObjectsTest extends TestBase {

  RegistrationPage registrationPage = new RegistrationPage();

  String firstName = "Dmitry";
  String lastName = "Plotnikov";
  String email = "kokoko@koko.ru";
  String gender = "Other";
  String phoneNumber = "9008007000";
  String birthday_day = "27";
  String birthday_month = "June";
  String birthday_year = "2000";
  String subjects = "English";
  String hobbies = "Music";
  String picture = "src/test/resources/Fotka.jpg";
  String address = "SDFSDFS";
  String state = "NCR";
  String city = "Delhi";


  @Test
  void fillFormTest() {

    registrationPage.openPage()
            .removeFixbar()
            .removeFooter()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(email)
            .setGender(gender)
            .setPhoneNumber(phoneNumber)
            .setBirthday(birthday_day, birthday_month, birthday_year)
            .setSubjects(subjects)
            .setHobbies(hobbies)
            .uploadFoto(picture)
            .setAddress(address)
            .setState(state)
            .setCity(city)
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
            .verifyResult("State and City", "NCR Delhi")
            .closeLargeModal();


  }
}
