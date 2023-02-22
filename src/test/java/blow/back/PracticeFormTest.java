package blow.back;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
  void FillFormTest() {
    $("#firstName").setValue("Dmitry");
    $("#lastName").setValue("Plotnikov");
    $("#userEmail").setValue("kokoko@koko.ru");
    $("#userNumber").setValue("900800700");
    $("#genterWrapper").$(byText("Other")).click();
    //датапикер
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").$(byText("April")).click();
    $(".react-datepicker__year-select").$(byText("1995")).click();
    //нужно добавить число, н пока нет

    $(".css-2b097c-container").setValue("e");
    $("#subjectsContainer").$(byText("English")).click();


  }
}
