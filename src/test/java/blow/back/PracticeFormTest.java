package blow.back;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    open("https://demoqa.com/automation-practice-form");
  }

  @Test
  void fillFormTest() {
    $("#firstName").setValue("Dmitry");
    $("#lastName").setValue("Plotnikov");
    $("#userEmail").setValue("kokoko@koko.ru");
    $("#userNumber").setValue("9008007000");
    $("#genterWrapper").$(byText("Other")).click();
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").$(byText("August")).click();
    $(".react-datepicker__year-select").$(byText("1997")).click();
    $(".react-datepicker__month-container").$(byText("26")).click();
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

    $("#closeLargeModal").click();

  }
}
