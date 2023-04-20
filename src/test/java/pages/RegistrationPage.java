package pages;

import org.openqa.selenium.Keys;
import pages.components.DatepickerComponent;
import pages.components.RegistrationModalComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

  DatepickerComponent calendarComponent = new DatepickerComponent();
  RegistrationModalComponent RegistrationModalWindow = new RegistrationModalComponent();

  public RegistrationPage openPage() {
    open("https://demoqa.com/automation-practice-form");
    return this;
  }

  public RegistrationPage removeFixbar() {
    executeJavaScript("$('#fixedban').remove()");
    return this;
  }

  public RegistrationPage removeFooter() {
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

  public RegistrationPage setPhoneNumber(String value) {
    $("#userNumber").setValue(value);
    return this;
  }

  public RegistrationPage setBirthday(String day, String month, String year) {
    $("#dateOfBirthInput").click();
    calendarComponent.setDate(day, month, year);
    return this;
  }

  public RegistrationPage setSubjects(String value) {
    $("#subjectsInput").setValue(value).pressEnter();
    return this;
  }

  public RegistrationPage setHobbies(String value) {
    $(byText(value)).click();
    return this;
  }

  public RegistrationPage uploadFoto(String value) {
    File fileUpload = new File(value);
    $("#uploadPicture").uploadFile(fileUpload);
    return this;
  }

  public RegistrationPage setAddress(String value) {
    $("#currentAddress").setValue(value);
    return this;
  }

  public RegistrationPage setState(String state) {
    $("#state").click();
    $("#stateCity-wrapper").$(byText(state)).click();
    return this;
  }

  public RegistrationPage setCity(String city) {
    $("#city").click();
    $("#stateCity-wrapper").$(byText(city)).click();
    return this;
  }

  public void pressEnter() {
    $("#submit").sendKeys(Keys.ENTER);
  }

  public RegistrationPage verifyResultsAppearModal() {
    RegistrationModalWindow.verifyThatModalAppears();
    return this;
  }

  public RegistrationPage verifyResult(String key, String value) {
    RegistrationModalWindow.verifyResult(key, value);
    return this;
  }

  public void closeModal() {
    $("#closeLargeModal").click();
  }
}
