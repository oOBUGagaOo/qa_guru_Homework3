package pages;

import pages.components.DatepickerComponent;
import pages.components.FinishRegistrationModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

  DatepickerComponent calendarComponent = new DatepickerComponent();
  FinishRegistrationModal finishRegistrationModal = new FinishRegistrationModal();
  private final String TITLE_TEXT = "Student Registration Form";

  public RegistrationPage openPage() {
    open("https://demoqa.com/automation-practice-form");
    $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('#footer').remove()");
    return this;
  }

  public RegistrationPage setFirstName(String value) {
    $("#firstName").setValue(value);
    return this;
  }

  public RegistrationPage setLastName(String value) {
    $("#lastName").setValue(value);
    return this;
  }

  public RegistrationPage setEmail(String value) {
    $("#userEmail").setValue(value);
    return this;
  }

  public RegistrationPage setGender(String value) {
    $("#genterWrapper").$(byText(value)).click();
    return this;
  }

  public RegistrationPage setNumber(String value) {
    $("#userNumber").setValue(value);
    return this;
  }

  public RegistrationPage setBirthday(String day, String month, String year) {
    $("#dateOfBirthInput").click();
    calendarComponent.setDate(day, month, year);
    return this;
  }

  public RegistrationPage verifyResultsAppearModal() {
    finishRegistrationModal.verifyAppearModal();
    return this;

  } public RegistrationPage verifyResult(String key, String value) {
    finishRegistrationModal.verifyResult(key, value);
    return this;
  }


}
