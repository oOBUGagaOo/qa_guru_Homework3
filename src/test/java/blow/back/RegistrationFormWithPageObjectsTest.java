package blow.back;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
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
            .setBirthday("27", "June", "2000");


    $("#subjectsInput").setValue("English").pressEnter();
    $(byText("Music")).click();
    File fileUpload = new File("src/test/resources/Fotka.jpg");
    $("#uploadPicture").uploadFile(fileUpload);
    $("#currentAddress").setValue("SDFSDFS");
    $("#state").click();
    $("#stateCity-wrapper").$(byText("NCR")).click();
    $("#city").click();
    $("#stateCity-wrapper").$(byText("Delhi")).click();
    $("#submit").sendKeys(Keys.ENTER);

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

/*
$(".modal-body").shouldHave(text("Dmitry Plotnikov"));
        $(".modal-body").shouldHave(text("kokoko@koko.ru"));
        $(".modal-body").shouldHave(text("9008007000"));
        $(".modal-body").shouldHave(text("Other"));
        $(".modal-body").shouldHave(text("26 August,1997"));
        $(".modal-body").shouldHave(text("English"));
        $(".modal-body").shouldHave(text("Music"));
        $(".modal-body").shouldHave(text("Fotka.jpg"));
        $(".modal-body").shouldHave(text("SDFSDFS"));
        $(".modal-body").shouldHave(text("NCR Delhi"));

 */