package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.matchers.JUnitMatchers.containsString;

public class TestGreeter {

  private Greeter greeter;

  @Before
  public void setup() {
    greeter = new Greeter();
  }

  @Test
  public void greetShouldIncludeTheOneBeingGreeted() {
    String someone = "World";
    assertThat(greeter.greet(someone), containsString(someone));
  }

  // @Test
  // public void intentionallyFailed() {
  //   fail("Intentional failure for testing");
  // }

  @Test
  public void greetShouldIncludeGreetingMessage() {
    String someone = "World, Thanks you making me Happy";
    assertThat(greeter.greet(someone).length(), greaterThan(someone.length()));
  }

  // ✅ New Test #1: Greeting should not be null
  @Test
  public void greetShouldNotReturnNull() {
    String someone = "Alice";
    assertThat("Greeting should not be null", greeter.greet(someone), containsString("Alice"));
  }

  // ✅ New Test #2: Greeting should start with "Hello"
  // @Test
  // public void greetShouldStartWithHello() {
  //   String someone = "Bob";
  //   String greeting = greeter.greet(someone);
  //   if (!greeting.startsWith("Hello")) {
  //     fail("Greeting should start with 'Hello'");
  //   }
  // }

  // ✅ Toggle-able Test: Can pass or fail by changing flag
  @Test
  public void togglePassOrFail() {
    boolean shouldPass = true; // 🔄 change this to false to make test fail intentionally
    String someone = "Charlie";
    String greeting = greeter.greet(someone);

    if (shouldPass) {
      // Passing condition
      assertThat(greeting, containsString(someone));
    } else {
      // Failing condition
      fail("Toggle set to fail this test");
    }
  }
}
