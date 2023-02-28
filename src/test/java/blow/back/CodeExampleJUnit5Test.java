package blow.back;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CodeExampleJUnit5Test {

  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    open("https://github.com/selenide/selenide");
  }

  @Test
  void checkingPresenceJUnitCode() {

    $("#wiki-tab").click();
    $("#wiki-pages-filter").setValue("SoftAssertions");
    $(".wiki-rightbar").$(byText("SoftAssertions")).click();
    $(".markdown-body").shouldHave(text("""
            @ExtendWith({SoftAssertsExtension.class})
            class Tests {
              @Test
              void test() {
                Configuration.assertionMode = SOFT;
                open("page.html");
                $("#first").should(visible).click();
                $("#second").should(visible).click();
              }
            }
            """));
  }
}
