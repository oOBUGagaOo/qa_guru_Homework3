package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {


  public static void main(String[] args) {
    System.out.println(getRandomString(10));
    System.out.println(getrandomInt(10, 100));
    System.out.println(getRandomEmail());

    String[] names = {"a", "b", "c", "d", "e"};
    System.out.println(getRandomItemFromArray(names));
  }

  public static int getrandomInt(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }

  public static String getRandomString(int lenght) {
    String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    SecureRandom rnd = new SecureRandom();
    StringBuilder sb = new StringBuilder(lenght);
    for (int i = 0; i < lenght; i++)
      sb.append(AB.charAt(rnd.nextInt(AB.length())));
    return sb.toString();
  }

  public static String getFirstName() {
    return new Faker().name().firstName();
  }

  public static String getLastName() {
    return new Faker().name().lastName();
  }

  public static String getRandomGender() {
    return new Faker().options().option("Male", "Female", "Other");
  }

  public static String getRandomEmail() {
    return getRandomString(10) + "@mail.ru";
  }

  public static String getRandomEmailAddress() {
    return new Faker().internet().emailAddress();
  }

  public static String getPhoneNumber() {
    return new Faker().phoneNumber().subscriberNumber(10);
  }

  public static int getBirthdayDay() {
    return new Faker().options().option(1, 28);
  }

  public static String getBirthdayMonth() {
    return new Faker().options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
  }

  public static int getBirthdayYear() {
    return new Faker().options().option(1900, 2023);
  }

  public static String getRandomSubject() {
    return new Faker().options().option("English", "Maths", "Biology");
  }

  public static String getRandomHobbies() {
    return new Faker().options().option("Sports", "Reading", "Music");
  }

  public static String getRandomAddress() {
    return new Faker().address().fullAddress();
  }

  public static String getRandomCity() {
    return new Faker().options().option("Delhi", "Gurgaon", "Noida");
  }

  public static String getRandomItemFromArray(String[] values) {
    int index = getrandomInt(0, values.length - 1);

    return values[index];
  }
}