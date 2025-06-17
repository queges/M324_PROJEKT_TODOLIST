package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TastTest {

  /**
   * test for setter and getter of taskdescription attribute
   */
  @Test
  void testDescription() {
    final String tastdescription = "Demo";

    Task testee = new Task();
    testee.setTaskdescription(tastdescription);
    assertEquals(tastdescription, testee.getTaskdescription(), "should be the same");
  }
}