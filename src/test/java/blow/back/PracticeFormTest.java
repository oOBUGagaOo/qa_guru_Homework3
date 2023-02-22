package blow.back;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

  @BeforeAll
  static void beforeAll() {
    open("https://demoqa.com/automation-practice-form");
  }

  @Test
  void FillFormTest() {
    $("[id=firstName]").setValue("Dmitry");
    $("[id=lastName]").setValue("Plotnikov");
    $("[id=userEmail]").setValue("kokoko@koko.ru");
    $("[id=userNumber]").setValue("900800700");
  }
}
