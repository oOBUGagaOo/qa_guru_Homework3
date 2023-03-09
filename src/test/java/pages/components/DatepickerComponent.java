package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DatepickerComponent {
  public void setDate(String day, String month, String year) {
    $(".react-datepicker__month-select").$(byText(month)).click();
    $(".react-datepicker__year-select").$(byText(year)).click();
    $(".react-datepicker__month-container").$(byText(day)).click();

  }
}