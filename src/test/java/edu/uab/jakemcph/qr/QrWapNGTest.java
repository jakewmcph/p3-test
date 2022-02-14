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
public class QrWapNGTest {
  private QrWap dos;

  public QrWapNGTest() {}

  @BeforeMethod
  public void setUpMethod() throws Exception {
    dos = new QrWap("lets", "go", "pacers", "haliburton", false);
  }

  @AfterMethod
  public void tearDownMethod() throws Exception {
    System.out.println("Completed");
  }

  /** Test of getNetworkType method, of class QrWap. */
  @Test
  public void testGetNetworkType() {
    assertEquals(dos.getNetworkType(), "pacers");
  }

  /** Test of getSsid method, of class QrWap. */
  @Test
  public void testGetSsid() {
    assertEquals(dos.getSsid(), "go");
  }

  /** Test of getPassword method, of class QrWap. */
  @Test
  public void testGetPassword() {
    assertEquals(dos.getPassword(), "haliburton");
  }

  /** Test of isHidden method, of class QrWap. */
  @Test
  public void testIsHidden() {
    assertFalse(dos.isHidden());
  }

  /** Test of getQrText method, of class QrWap. */
  @Test
  public void testGetQrText() {
    assertEquals(dos.getQrText(), "WIFI:S:go;T:pacers;P:haliburton;H:false;;");
  }

  /** Test of isValid method, of class QrWap. */
  @Test
  public void testIsValid() {
    assertFalse(dos.isValid());
  }

  /** Test of toString method, of class QrWap. */
  @Test
  public void testToString() {
    assertEquals(dos.toString(), "QrWap: lets");
  }

  /** Test of setNetworkType method, of class QrWap. */
  @Test
  public void testSetNetworkType() {
    dos.setNetworkType("reese");
    assertEquals(dos.getNetworkType(), "reese");
  }

  /** Test of setSsid method, of class QrWap. */
  @Test
  public void testSetSsid() {
    dos.setSsid("sabonis");
    assertEquals(dos.getSsid(), "sabonis");
  }

  /** Test of setPassword method, of class QrWap. */
  @Test
  public void testSetPassword() {
    dos.setPassword("turner");
    assertEquals(dos.getPassword(), "turner");
  }

  /** Test of isHidden method, of class QrWap. */

  /** Test of setHidden method, of class QrWap. */
  @Test
  public void testSetHidden() {
    boolean hidden = true;
    QrWap instance = dos;
    instance.setHidden(hidden);
    assertTrue(dos.isHidden());
  }
}