/*
 * Author: Jake McPhearson <jakemcph@uab.edu>
 * Assignment:  qr-p3 - EE333 Spring 2022
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.jakemcph.qr;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/** */
public class QrEventNGTest {
  private QrEvent tres;

  public QrEventNGTest() {}

  @BeforeMethod
  public void setUpMethod() throws Exception {
    tres =
        new QrEvent(
            "1000000000",
            LocalDateTime.now(),
            LocalDateTime.of(2022, Month.APRIL, 22, 0, 0),
            LocalDateTime.of(2022, Month.APRIL, 22, 23, 59),
            "EE333 Final",
            "This is the final project for EE333",
            "EE 333");
  }

  @AfterMethod
  public void tearDownMethod() throws Exception {}

  /** Test of getUid method, of class QrEvent. */
  @Test
  public void testGetUid() {
    assertEquals(tres.getUid(), "1000000000");
  }

  /** Test of getCLASS method, of class QrEvent. */
  @Test
  public void testGetCLASS() {
    assertEquals(tres.getCLASS(), "EE 333");
  }

  /** Test of getDescription method, of class QrEvent. */
  @Test
  public void testGetDescription() {
    assertEquals(tres.getDescription(), "This is the final project for EE333");
  }

  /** Test of getDtend method, of class QrEvent. */
  @Test
  public void testGetDtend() {
    assertEquals(tres.getDtend(), LocalDateTime.of(2022, Month.APRIL, 22, 23, 59));
  }

  /** Test of getDtstamp method, of class QrEvent. */
  @Test
  public void testGetDtstamp() {
    assertEquals(tres.getDtstamp(), LocalDateTime.now());
    System.out.println(tres.getDtstamp());
  }

  /** Test of getDtstart method, of class QrEvent. */
  @Test
  public void testGetDtstart() {
    assertEquals(tres.getDtstart(), LocalDateTime.of(2022, Month.APRIL, 22, 0, 0));
  }

  /** Test of getSummary method, of class QrEvent. */
  @Test
  public void testGetSummary() {
    assertEquals(tres.getSummary(), "EE333 Final");
  }

  /** Test of isValid method, of class QrEvent. */
  @Test
  public void testIsValid() {
    assertTrue(tres.isValid());
    System.out.println(tres.getQrText());
  }

  /** Test of getQrText method, of class QrEvent. */
  //  @Test
  //  public void testGetQrText() {
  //    System.out.println("getQrText");
  //    QrEvent instance = null;
  //    String expResult = "";
  //    String result = instance.getQrText();
  //    assertEquals(result, expResult);
  //    // TODO review the generated test code and remove the default call to fail.
  //    fail("The test case is a prototype.");
  //  }

  /** Test of setUid method, of class QrEvent. */
  @Test
  public void testSetUid() {
    tres.setUid("1000000001");
    assertEquals(tres.getUid(), "1000000001");
  }

  /** Test of setDtstamp method, of class QrEvent. */
  @Test
  public void testSetDtstamp() {
    tres.setDtstamp(LocalDateTime.of(2022, Month.FEBRUARY, 12, 0, 0));
    assertEquals(tres.getDtstamp(), (LocalDateTime.of(2022, Month.FEBRUARY, 12, 0, 0)));
  }

  /** Test of setDtstart method, of class QrEvent. */
  @Test
  public void testSetDtstart() {
    tres.setDtstart(LocalDateTime.of(2022, Month.FEBRUARY, 28, 23, 59));
    assertEquals(tres.getDtstart(), (LocalDateTime.of(2022, Month.FEBRUARY, 28, 23, 59)));
  }

  /** Test of setDescription method, of class QrEvent. */
  @Test
  public void testSetDescription() {
    tres.setDescription("This is the entire duration of the month of March.");
    assertEquals(tres.getDescription(), "This is the entire duration of the month of March.");
  }

  /** Test of setDtend method, of class QrEvent. */
  @Test
  public void testSetDtend() {
    tres.setDtend(LocalDateTime.of(2022, Month.APRIL, 1, 0, 0));
    assertEquals(tres.getDtend(), (LocalDateTime.of(2022, Month.APRIL, 1, 0, 0)));
  }

  /** Test of setSummary method, of class QrEvent. */
  @Test
  public void testSetSummary() {
    tres.setSummary("The month of March.");
    assertEquals(tres.getSummary(), "The month of March.");
  }

  /** Test of setCLASS method, of class QrEvent. */
  @Test
  public void testSetCLASS() {
    tres.setCLASS("MARCH");
    assertEquals(tres.getCLASS(), "MARCH");
  }
}