package blow.back;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragnDropActionsTest {

  @BeforeAll
  static void beforeAll() {
    open("https://the-internet.herokuapp.com/drag_and_drop");
  }

  @Test
  void checkingActionsDrugAndDrop() {
    SelenideElement sourceEl = $("#column-a");
    SelenideElement targetEl = $("#column-b");
    actions()
            .clickAndHold(sourceEl)
            .moveToElement(targetEl)
            .release()
            .perform();
    $("#column-a").shouldHave(text("B"));
    $("#column-b").shouldHave(text("A"));
  }
}
