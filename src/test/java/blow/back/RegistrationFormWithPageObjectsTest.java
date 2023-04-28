package blow.back;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

public class RegistrationFormWithPageObjectsTest extends TestBase {

  RegistrationPage registrationPage = new RegistrationPage();
  Faker faker = new Faker(new Locale("ru"));

  String firstName = faker.name().firstName(),
          lastName = faker.name().lastName(),
          gender = "Other",
          email = faker.internet().emailAddress(),
          phoneNumber = faker.phoneNumber().phoneNumber(),
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
