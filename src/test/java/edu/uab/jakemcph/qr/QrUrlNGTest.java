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

/**
 *
 */
public class QrUrlNGTest {

    public QrUrlNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of isValid method, of class QrUrl.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        QrUrl instance = null;
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class QrUrl.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        QrUrl instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQrText method, of class QrUrl.
     */
    @Test
    public void testGetQrText() {
        System.out.println("getQrText");
        QrUrl instance = null;
        String expResult = "";
        String result = instance.getQrText();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUrl method, of class QrUrl.
     */
    @Test
    public void testSetUrl() {
        System.out.println("setUrl");
        String url = "";
        QrUrl instance = null;
        instance.setUrl(url);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}