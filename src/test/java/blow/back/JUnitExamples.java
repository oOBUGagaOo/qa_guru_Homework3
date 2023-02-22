package blow.back;

import org.junit.jupiter.api.*;

public class JUnitExamples {

  @BeforeAll
  static void beforeAll() {
    System.out.println("This is beforeAll");
  }

  @BeforeEach
  void beforeEach() {
    System.out.println("  This is beforeEach");
  }

  @AfterAll
  static void afterAll() {
    System.out.println("This is afterAll");
  }

  @AfterEach
  void afterEach() {
    System.out.println("  This is afterEach");
  }

  @Test
  void firstTest() {
    System.out.println("    This is firstTest");
  }

  @Test
  void secondTest() {
    System.out.println("    This is secondTest");
  }


}