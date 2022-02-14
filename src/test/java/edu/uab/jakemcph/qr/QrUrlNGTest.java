/*
 * Author: Jake McPhearson <jakemcph@uab.edu>
 * Assignment:  qr-p3 - EE333 Spring 2022
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.jakemcph.qr;

import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/** */
public class QrUrlNGTest {
  private QrUrl uno;

  public QrUrlNGTest() {}

  @BeforeMethod
  public void setUpMethod() throws Exception {
    uno = new QrUrl("tyrese", "https://www.nba.com");
  }

  @AfterMethod
  public void tearDownMethod() throws Exception {}

  /** Test of isValid method, of class QrUrl. */
  @Test
  public void testIsValid() {
    assertTrue(uno.isValid());
  }

  /** Test of toString method, of class QrUrl. */
  @Test
  public void testToString() {
    assertEquals(uno.toString(), "QrUrl: tyrese");
  }

  /** Test of getQrText method, of class QrUrl. */
  @Test
  public void testGetQrText() {
    assertEquals(uno.getQrText(), "https://www.nba.com");
  }

  /** Test of setUrl method, of class QrUrl. */
  @Test
  public void testSetUrl() {
    uno.setUrl("https://www.nfl.com");
    assertEquals(uno.getQrText(), "https://www.nfl.com");
  }
} 