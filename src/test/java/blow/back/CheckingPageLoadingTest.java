package blow.back;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckingPageLoadingTest {


  @BeforeAll
  static void beforeAll() {
    open("https://github.com/");
  }

  @Test
  void verifyPage() {
    $(byText("Solutions")).hover();
    $(byText("Enterprise")).click();
    $("div.application-main").shouldHave(text("Build like the best"));
  }
}
