package blow.back;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragnDropTest {

  @BeforeAll
  static void beforeAll() {
    open("https://the-internet.herokuapp.com/drag_and_drop");
  }

  @Test
  void checkingDrugAndDrop() {
    $("#column-a").dragAndDropTo($("#column-b"));
    $("#column-a").shouldHave(text("B"));
    $("#column-b").shouldHave(text("A"));
  }
}
