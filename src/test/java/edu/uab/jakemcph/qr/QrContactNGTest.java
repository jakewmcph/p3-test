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
public class QrContactNGTest {
  private QrContact quatro;

  public QrContactNGTest() {}

  @BeforeMethod
  public void setUpMethod() throws Exception {
    quatro =
        new QrContact(
            "1.0",
            "Tyrese",
            "Haliburton",
            "Point Guard",
            "Indiana Pacers",
            "https://www.nba.com",
            "pacers@gmail.com",
            "+1 (463)-123-4567",
            "+1 (463)-098-7654",
            "123 Pacers Way",
            "Indianapolis",
            "46077",
            "IN");
  }

  @AfterMethod
  public void tearDownMethod() throws Exception {}

  /** Test of getCellNumber method, of class QrContact. */
  @Test
  public void testGetCellNumber() {
    assertEquals(quatro.getCellNumber(), "+1 (463)-098-7654");
  }

  /** Test of getCity method, of class QrContact. */
  @Test
  public void testGetCity() {
    assertEquals(quatro.getCity(), "Indianapolis");
  }

  /** Test of getCompany method, of class QrContact. */
  @Test
  public void testGetCompany() {
    assertEquals(quatro.getCompany(), "Indiana Pacers");
  }

  /** Test of getEmail method, of class QrContact. */
  @Test
  public void testGetEmail() {
    assertEquals(quatro.getEmail(), "pacers@gmail.com");
  }

  /** Test of getFirstName method, of class QrContact. */
  @Test
  public void testGetFirstName() {
    assertEquals(quatro.getFirstName(), "Tyrese");
  }

  /** Test of getJobTitle method, of class QrContact. */
  @Test
  public void testGetJobTitle() {
    assertEquals(quatro.getJobTitle(), "Point Guard");
  }

  /** Test of getLastName method, of class QrContact. */
  @Test
  public void testGetLastName() {
    assertEquals(quatro.getLastName(), "Haliburton");
  }

  /** Test of getState method, of class QrContact. */
  @Test
  public void testGetState() {
    assertEquals(quatro.getState(), "IN");
  }

  /** Test of getStreet method, of class QrContact. */
  @Test
  public void testGetStreet() {
    assertEquals(quatro.getStreet(), "123 Pacers Way");
  }

  /** Test of getUrl method, of class QrContact. */
  @Test
  public void testGetUrl() {
    assertEquals(quatro.getUrl(), "https://www.nba.com");
  }

  /** Test of getVersion method, of class QrContact. */
  @Test
  public void testGetVersion() {
    assertEquals(quatro.getVersion(), "1.0");
  }

  /** Test of getWorkNumber method, of class QrContact. */
  @Test
  public void testGetWorkNumber() {
    assertEquals(quatro.getWorkNumber(), "+1 (463)-123-4567");
  }

  /** Test of getZip method, of class QrContact. */
  @Test
  public void testGetZip() {
    assertEquals(quatro.getZip(), "46077");
  }

  /** Test of isValid method, of class QrContact. */
  @Test
  public void testIsValid() {
    assertTrue(quatro.isValid());
  }

  /** Test of setVersion method, of class QrContact. */
  @Test
  public void testSetVersion() {
    quatro.setVersion("3.0");
    assertEquals(quatro.getVersion(), "3.0");
  }

  /** Test of setFirstName method, of class QrContact. */
  @Test
  public void testSetFirstName() {
    quatro.setFirstName("LeBron");
    assertEquals(quatro.getFirstName(), "LeBron");
  }

  /** Test of setLastName method, of class QrContact. */
  @Test
  public void testSetLastName() {
    quatro.setLastName("James");
    assertEquals(quatro.getLastName(), "James");
  }

  /** Test of setJobTitle method, of class QrContact. */
  @Test
  public void testSetJobTitle() {
    quatro.setJobTitle("Small Forward");
    assertEquals(quatro.getJobTitle(), "Small Forward");
  }

  /** Test of setCompany method, of class QrContact. */
  @Test
  public void testSetCompany() {
    quatro.setCompany("Los Angeles Lakers");
    assertEquals(quatro.getCompany(), "Los Angeles Lakers");
  }

  /** Test of setUrl method, of class QrContact. */
  @Test
  public void testSetUrl() {
    quatro.setUrl("https://www.nba.com");
    assertEquals(quatro.getUrl(), "https://www.nba.com");
  }

  /** Test of setEmail method, of class QrContact. */
  @Test
  public void testSetEmail() {
    quatro.setEmail("lakers@gmail.com");
    assertEquals(quatro.getEmail(), "lakers@gmail.com");
  }

  /** Test of setWorkNumber method, of class QrContact. */
  @Test
  public void testSetWorkNumber() {
    quatro.setWorkNumber("+1 (100)-101-1234");
    assertEquals(quatro.getWorkNumber(), "+1 (100)-101-1234");
  }

  /** Test of setCellNumber method, of class QrContact. */
  @Test
  public void testSetCellNumber() {
    quatro.setCellNumber("+1 (100)-101-0987");
    assertEquals(quatro.getCellNumber(), "+1 (100)-101-0987");
  }

  /** Test of setStreet method, of class QrContact. */
  @Test
  public void testSetStreet() {
    quatro.setStreet("23 King's Way");
    assertEquals(quatro.getStreet(), "23 King's Way");
  }

  /** Test of setCity method, of class QrContact. */
  @Test
  public void testSetCity() {
    quatro.setCity("Los Angeles");
    assertEquals(quatro.getCity(), "Los Angeles");
  }

  /** Test of setZip method, of class QrContact. */
  @Test
  public void testSetZip() {
    quatro.setZip("12345");
    assertEquals(quatro.getZip(), "12345");
  }

  /** Test of setState method, of class QrContact. */
  @Test
  public void testSetState() {
    quatro.setState("CA");
    assertEquals(quatro.getState(), "CA");
  }

  /** Test of isUrlValid method, of class QrContact. */
  @Test
  public void testIsUrlValid() {
    assertTrue(quatro.isUrlValid());
  }

  /** Test of isEmailValid method, of class QrContact. */
  @Test
  public void testIsEmailValid() {
    assertTrue(quatro.isEmailValid());
  }

  /** Test of isWorkNumberValid method, of class QrContact. */
  @Test
  public void testIsWorkNumberValid() {
    assertTrue(quatro.isWorkNumberValid());
  }

  /** Test of isCellNumberValid method, of class QrContact. */
  @Test
  public void testIsCellNumberValid() {
    assertTrue(quatro.isCellNumberValid());
  }
} 