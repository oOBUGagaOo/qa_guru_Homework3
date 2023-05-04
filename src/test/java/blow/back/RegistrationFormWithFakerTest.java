package blow.back;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.RandomUtils.*;

public class RegistrationFormWithFakerTest extends TestBase {
  RegistrationPage registrationPage = new RegistrationPage();

  String firstName = getFirstName(), lastName = getLastName(),
          gender = getRandomGender(),
          email = getRandomEmailAddress(), phoneNumber = getPhoneNumber(),
          birthdayDay = String.valueOf(getBirthdayDay()),
          birthdayMonth = getBirthdayMonth(),
          birthdayYear = String.valueOf(getBirthdayYear()),
          subject = getRandomSubject(),
          hobbies = getRandomHobbies(),
          picturePath = "src/test/resources/Fotka.jpg",
          pictureName = "Fotka.jpg",
          address = getRandomAddress(), state = "NCR", city = getRandomCity();

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
            .setHobbies(hobbies)
            .uploadFoto(picturePath)
            .setAddress(address)
            .setState(state)
            .setCity(city)
            .pressEnter();

    registrationPage.verifyResultsAppearModal()
            .verifyResult("Student Name", lastName)
            .verifyResult("Student Email", email)
            .verifyResult("Gender", gender)
            .verifyResult("Mobile", phoneNumber)
            .verifyResult("Date of Birth",birthdayDay +" "+ birthdayMonth +","+ birthdayYear)
            .verifyResult("Subjects", subject)
            .verifyResult("Hobbies", hobbies)
            .verifyResult("Picture", pictureName)
            .verifyResult("Address", address)
            .verifyResult("State and City", state + " " + city)
            .closeModal();


  }
}
