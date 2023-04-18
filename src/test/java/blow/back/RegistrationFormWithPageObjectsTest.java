package blow.back;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormWithPageObjectsTest extends TestBase {

  RegistrationPage registrationPage = new RegistrationPage();

  String FirstName = "Dmitry";
  String LastName = "Plotnikov";
  String Email = "kokoko@koko.ru";
  String Gender = "Other";
  String PhoneNumber = "9008007000";
  String Birthday_day = "27";
  String Birthday_month = "June";
  String Birthday_year = "2000";
  String Subjects = "English";
  String Hobbies = "Music";
  String Picture = "src/test/resources/Fotka.jpg";
  String Address = "SDFSDFS";
  String State = "NCR";
  String City = "Delhi";


  @Test
  void fillFormTest() {

    registrationPage.openPage()
            .removeFixbar()
            .removeFooter()
            .setFirstName(FirstName)
            .setLastName(LastName)
            .setEmail(Email)
            .setGender(Gender)
            .setPhoneNumber(PhoneNumber)
            .setBirthday(Birthday_day, Birthday_month, Birthday_year)
            .setSubjects(Subjects)
            .setHobbies(Hobbies)
            .uploadFoto(Picture)
            .setAddress(Address)
            .setState(State)
            .setCity(City)
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
