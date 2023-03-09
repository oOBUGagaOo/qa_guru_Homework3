package blow.back;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
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

    registrationPage.verifyResultsAppearModal();

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