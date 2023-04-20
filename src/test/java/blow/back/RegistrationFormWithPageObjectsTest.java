package blow.back;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormWithPageObjectsTest extends TestBase {

  RegistrationPage registrationPage = new RegistrationPage();

  String firstName = "Dmitry", lastName = "Plotnikov", gender = "Other",
  email = "kokoko@koko.ru", phoneNumber = "9008007000",
  birthdayDay = "27", birthdayMonth = "June", birthdayYear = "2000",
  subject = "English", hobbie = "Music",
  picture = "src/test/resources/Fotka.jpg",
  address = "SDFSDFS", state = "NCR", city = "Delhi";


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
            .setBirthday(birthdayDay, birthdayMonth, birthdayYear)
            .setSubjects(subject)
            .setHobbies(hobbie)
            .uploadFoto(picture)
            .setAddress(address)
            .setState(state)
            .setCity(city)
            .pressEnter();


    registrationPage.verifyResultsAppearModal()
            .verifyResult("Student Name", lastName)
            .verifyResult("Student Email", email)
            .verifyResult("Gender", gender)
            .verifyResult("Mobile", phoneNumber)
            .verifyResult("Date of Birth", birthdayDay + " " + birthdayMonth + " " + birthdayYear)
            .verifyResult("Subjects", subject)
            .verifyResult("Hobbies", hobbie)
            .verifyResult("Picture", picture)
            .verifyResult("Address", address)
            .verifyResult("State and City", state + " " + city)
            .closeModal();


  }
}
